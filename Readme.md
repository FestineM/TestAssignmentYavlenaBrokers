# Test Assignment of Broker Page

### Technology:
- Tool: Selenium
- IDE: IntelIJ
- Build tool: Maven
- Language: Java
- Framework: TestNG

## Project Description:

#### BrokerPage
    This class contains references of main elements of the page that are needed to test this project.
#### TestBrokers
    Contains the automated test case, that covers steps that we need to take in order to complete testing
    based on the requirements. 
    
#### BrowserUtils
    Contain utils functions to make it easier to controll the WebElements in the page. It contains methods such as 
    waitForLoaderToFinish, waitForInvisibilityOf, getElementsText, scrollToElement
#### Driver
    Contain utils functions for our Driver, which will help to create and close the Driver.
        
#### ConfigurationReader
    It is used to read the configurations (browser and waitTimeOut) of the project that are saved in configuration.properties file. 
    "browser" property it is used to specify the browser we want to excetute the project tests, while "waitTimeOut" it 
    is used to specify the waiting time in implicitlyWait of WebDriver and WebDriverWait
    


