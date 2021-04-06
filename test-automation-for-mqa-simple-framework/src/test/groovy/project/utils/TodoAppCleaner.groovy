package project.utils

import my.testframework.utils.ConfigsReader
import my.testframework.utils.DriverManager
import my.testframework.utils.uielements.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class TodoAppCleaner {

    private static WebElement uncheckedCheckbox = new WebElement("//input[@class='toggle'][not(@checked)]")
    private static WebElement clearButton = new WebElement("//button[text()='Clear completed']")
    private static WebElement inputField = new WebElement("//input[contains(@class, 'new-todo')]")

    static clean() {
        driver.get(ConfigsReader.BASE_URL)
        inputField.waitForVisible()

        int maxCount = 50
        int counter = 0
        while (uncheckedCheckbox.isPresent() && counter < maxCount) {
            counter++
            click(uncheckedCheckbox)
        }
        if (clearButton.isDisplayed()) {
            click(clearButton)
            clearButton.waitForNotVisible()
        }
    }

    protected static WebDriver getDriver() {
        DriverManager.getDriver()
    }

    protected static executeJsOnElement(String script, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(script.toString(), element.getElement())
    }

    protected static click(WebElement element) {
        executeJsOnElement('arguments[0].click();', element)
    }
}
