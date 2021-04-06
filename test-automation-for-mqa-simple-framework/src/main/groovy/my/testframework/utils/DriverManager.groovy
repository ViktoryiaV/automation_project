package my.testframework.utils

import groovy.util.logging.Log4j
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities

import static my.testframework.utils.ConfigsReader.BROWSER_NAME
import static my.testframework.utils.ConfigsReader.IS_HEADLESS

@Log4j
class DriverManager {

    static WebDriver driver
    private static Map browserNames = [
            chrome : 'chrome',
            firefox: 'firefox',
    ]

    static WebDriver launchBrowser() {
        log.info("Launch browser $BROWSER_NAME")
        if (BROWSER_NAME == browserNames.chrome) {
            driver = launchChrome()
        } else if (BROWSER_NAME == browserNames.firefox) {
            driver = launchFirefox()
        } else {
            //throw new RuntimeException("Unknown browser $BROWSER_NAME")
            log.warn("Unknown browser $BROWSER_NAME, will use ${browserNames.chrome}")
            launchChrome()
        }
        driver.manage().window().maximize()
        driver
    }

    protected static WebDriver launchChrome() {
        WebDriverManager.chromedriver().setup()
        DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        ChromeOptions options = new ChromeOptions()
        options.addArguments('--incognito')
        if (IS_HEADLESS) {
            options.addArguments('--headless')
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        new ChromeDriver(capabilities)
    }

    protected static WebDriver launchFirefox() {
        WebDriverManager.firefoxdriver().setup()
        // todo Add options if needed
        FirefoxOptions options = new FirefoxOptions()
        if (IS_HEADLESS) {
            options.addArguments('--headless')
        }
        new FirefoxDriver(options)
    }

    static void closeBrowser() {
        driver.quit()
    }


}
