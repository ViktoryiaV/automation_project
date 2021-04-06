package org.example.lesson7.projectutils

import org.example.lesson7.utils.DriverManager
import org.example.lesson7.utils.uielements.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class TodoAppCleaner {

    private static WebElement uncheckedCheckbox = new WebElement("//input[@class='toggle'][not(@checked)]")
    private static WebElement clearButton = new WebElement("//button[text()='Clear completed']")
    private static WebElement inputField = new WebElement("//input[contains(@class, 'new-todo')]")

    static clean() {
        driver.get('https://todomvc.com/examples/backbone/')
        inputField.waitForVisible()

        int maxCount = 50
        int counter
        while(uncheckedCheckbox.isPresent() && counter < maxCount) {
            counter++
            uncheckedCheckbox.click()
        }
        if (clearButton.isDisplayed()) {
            clearButton.click()
            clearButton.waitForNotVisible()
        }
    }

    protected static WebDriver getDriver() {
        DriverManager.getDriver()
    }

    protected static executeJsOnElement(String script, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(script.toString(), element)
    }

    protected static click(WebElement element) {
        executeJsOnElement('arguments[0].click()', element)
    }
}
