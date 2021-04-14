package my.testframework.utils

import groovy.util.logging.Log4j
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver

import static my.testframework.utils.ConfigsReader.BROWSER_NAME
import static my.testframework.utils.ConfigsReader.IS_HEADLESS
import static my.testframework.utils.ConfigsReader.IS_REMOTE
import static my.testframework.utils.ConfigsReader.REMOTE_HUB

@Log4j
class DriverManager {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>()

    static WebDriver getDriver() {
        driverThreadLocal.get()
    }
    private static Map browserNames = [
            chrome : 'chrome',
            firefox: 'firefox',
    ]

    static void launchBrowser() {
        WebDriver driver
        log.info("Launch browser $BROWSER_NAME")
        if(IS_REMOTE) {
            DesiredCapabilities capabilities
            driver = launchRemoteDriver(REMOTE_HUB, getCapabilities(BROWSER_NAME, true))
        } else {
            driver = launchLocalDriver(BROWSER_NAME)
        }
        driver.manage().window().maximize()
        driverThreadLocal.set(driver)
    }

    protected static WebDriver launchLocalDriver(String browserName) {
        WebDriver driver
        if (browserName == browserNames.chrome) {
            driver = launchChrome()
        } else if (browserName == browserNames.firefox) {
            driver = launchFirefox()
        } else {
            //throw new RuntimeException("Unknown browser $BROWSER_NAME")
            log.warn("Unknown browser $browserName, will use ${browserNames.chrome}")
            driver = launchChrome()
        }
        driver
    }

    protected static WebDriver launchRemoteDriver(String remoteHub, Capabilities capabilities) {
        def driver = new RemoteWebDriver(new URL(remoteHub), capabilities)
        driver.setFileDetector(new LocalFileDetector())
        driver
    }

    protected static DesiredCapabilities getCapabilities(String browser, boolean isRemote=false) {
        DesiredCapabilities capabilities
        if(browser == browserNames.chrome) {
            capabilities = DesiredCapabilities.chrome()
            ChromeOptions options = new ChromeOptions()
            options.addArguments('--incognito')
            if (IS_HEADLESS) {
                options.addArguments('--headless')
            }
            capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        } else if(browser == browserNames.firefox) {
            capabilities = DesiredCapabilities.firefox()
        } else {
            throw new RuntimeException("Uknown browser $browser")
        }
        if(isRemote) {
            //capabilities.setCapability('version', '48')
            capabilities.setCapability('enableVNC', true)
            capabilities.setCapability('name', 'todo-app project')
        }
        capabilities
    }

    protected static WebDriver launchChrome() {
        WebDriverManager.chromedriver().setup()
        new ChromeDriver(getCapabilities(browserNames.chrome))
    }

    protected static WebDriver launchFirefox() {
        WebDriverManager.firefoxdriver().setup()
        new FirefoxDriver(getCapabilities(browserNames.firefox))
    }

    static void closeBrowser() {
        getDriver().quit()
    }


}
