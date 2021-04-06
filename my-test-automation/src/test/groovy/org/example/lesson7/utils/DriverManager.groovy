package org.example.lesson7.utils

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

class DriverManager {

    static WebDriver driver

    static WebDriver launchChrome() {
        WebDriverManager.chromedriver().setup()
        DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        ChromeOptions options = new ChromeOptions()
        options.addArguments('--incognito')
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        driver = new ChromeDriver(capabilities)
    }

    static void closeBrowser() {
        driver.quit()
    }
}
