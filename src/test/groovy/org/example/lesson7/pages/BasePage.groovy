package org.example.lesson7.pages

import org.example.lesson7.utils.DriverManager
import org.openqa.selenium.WebDriver

class BasePage {

    protected WebDriver getDriver() {
        DriverManager.driver
    }
}
