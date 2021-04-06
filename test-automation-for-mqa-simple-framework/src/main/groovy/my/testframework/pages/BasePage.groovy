package my.testframework.pages

import my.testframework.utils.ConfigsReader
import my.testframework.utils.DriverManager
import org.openqa.selenium.WebDriver

class BasePage {

    final static BASE_URL = ConfigsReader.BASE_URL

    protected WebDriver getDriver() {
        DriverManager.driver
    }
}
