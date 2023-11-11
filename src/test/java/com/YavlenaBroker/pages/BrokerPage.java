package com.YavlenaBroker.pages;

import com.YavlenaBroker.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokerPage {
    public BrokerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".brokers-loading")
    private WebElement loader;

    public WebElement getLoader() {
        return loader;
    }

    @FindBy(css = "input.input-search")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

    @FindBy(css = "div.load-more-brokers > a")
    private WebElement loadMoreBrokersBtn;

    public WebElement getLoadMoreBrokersBtn() {
        return loadMoreBrokersBtn;
    }

    @FindBy(css = "div.header-group > h3 > a")
    private List<WebElement> brokersNames;

    public List<WebElement> getBrokersNames() {
        return brokersNames;
    }

    @FindBy(css = "article.broker-card")
    private List<WebElement> brokersCards;

    public List<WebElement> getBrokersCards() {
        return brokersCards;
    }

    @FindBy(css = "article.broker-card .name")
    private WebElement brokerName;

    public WebElement getBrokerName() {
        return brokerName;
    }

    @FindBy(css = "article.broker-card .office")
    private WebElement brokerAddress;

    public WebElement getBrokerAddress() {
        return brokerAddress;
    }

    @FindBy(css = "article.broker-card .position a")
    private WebElement brokerNumProperties;

    public WebElement getBrokerNumProperties() {
        return brokerNumProperties;
    }

    @FindBy(css = "article.broker-card .tel")
    private List<WebElement> brokerPhoneNumbers;

    public List<WebElement> getBrokerPhoneNumbers() {
        return brokerPhoneNumbers;
    }
}
