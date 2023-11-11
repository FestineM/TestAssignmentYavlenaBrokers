package com.YavlenaBroker.tests;

import com.YavlenaBroker.pages.BrokerPage;
import com.YavlenaBroker.utilities.BrowserUtils;
import com.YavlenaBroker.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestBrokers {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
    }

    @Test
    public void testBrokers() {
        // Open the browser and navigate to a website
        driver.get(" https://www.yavlena.com/broker/");

        BrokerPage brokerPage = new BrokerPage();

        //Click on the "Зареди още" button (this way the brokers are loaded on the page)
        BrowserUtils.scrollToElement(brokerPage.getLoadMoreBrokersBtn());
        brokerPage.getLoadMoreBrokersBtn().click();
        BrowserUtils.waitForInvisibilityOf(brokerPage.getLoadMoreBrokersBtn());

        //For each broker on the page, get the name of the broker and search by the name of that broker
        List<String> brokersNames = BrowserUtils.getElementsText(brokerPage.getBrokersNames());

        SoftAssert softAssert = new SoftAssert();

        for (String name : brokersNames) {
            brokerPage.getSearchBox().sendKeys(name);

            //Loader
            BrowserUtils.waitForLoaderToFinish(brokerPage.getLoader());

            //On the search result view, verify that the searched broker is the only one
            //displayed, and make sure that the address, the two phone numbers (landline
            //and mobile) and the number of properties assigned to that broker are
            //displayed
            softAssert.assertTrue(brokerPage.getBrokersCards().size() == 1, "Only one broker is displayed");
            softAssert.assertTrue(name.equals(brokerPage.getBrokerName().getText()), "Name is correct!");
            softAssert.assertTrue(brokerPage.getBrokerAddress().isDisplayed(), "Address is visible");
            softAssert.assertTrue(brokerPage.getBrokerNumProperties().isDisplayed(), "Number of Properties is visible");

            List<WebElement> brokerPhoneNumbers = brokerPage.getBrokerPhoneNumbers();
            softAssert.assertTrue(brokerPhoneNumbers.size() > 0 && brokerPhoneNumbers.size() < 3, "Phone numbers are visible");

            if (brokerPhoneNumbers.size() != 2) {
                System.out.println("Broker: " + name + " doesn't have 2 numbers appeared");
            }

            //clear search
            brokerPage.getSearchBox().clear();
        }

        softAssert.assertAll();
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        Driver.closeDriver();
    }
}
