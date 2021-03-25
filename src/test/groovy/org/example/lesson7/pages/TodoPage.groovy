package org.example.lesson7.pages

import org.example.lesson7.TodoAppTest
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import java.util.concurrent.TimeoutException

class TodoPage {

    private todoHeader = '//header/h1'
    private inputField = "//input[contains(@class, 'new-todo')]"
    private footer = "//footer[contains(@class, 'footer')]"

    TodoPage getPage() {
        waitForElementDisplayed(inputField)
        this
    }

    TodoPage navigate() {
        driver.get('https://todomvc.com/examples/backbone/')
        getPage()
    }

    boolean isTodoHeaderDisplayed() {
        isDisplayed(todoHeader)
    }

    boolean isInputFieldDisplayed() {
        isDisplayed(inputField)
    }

    String getInputFieldPlaceholder() {
        getElement(inputField).getAttribute('placeholder')

    }

    boolean isFooterDisplayed() {
        isDisplayed(footer)
    }


















    private WebElement getElement(String xpath) {
        getDriver().findElement(By.xpath(xpath))
    }


    private WebDriver getDriver() {
        TodoAppTest.driver
    }

    boolean isDisplayed(xpath) {
        getDriver().findElements(By.xpath(xpath)).any {it.isDisplayed()}
    }

    private waitForElementDisplayed(String xpath) {
        waitForCondition(10, 500) {
            try {
                getDriver().findElement(By.xpath(xpath)).isDisplayed()
            } catch (org.openqa.selenium.NoSuchElementException ignored) {
                false
            }
        }

    }

    private void waitForCondition(int sec, int ping, Closure condition) {
        def ms = sec * 1000
        long endTime = Calendar.getInstance().getTimeInMillis() + (ms)
        boolean isSuccess = false
        while (Calendar.getInstance().getTimeInMillis() <= endTime) {
            if (condition.call()) {
                isSuccess = true
                return
            }
            sleep(ping)
        }
        if (!isSuccess) {
            throw new TimeoutException("Condition not appeared in $sec sec")
        }
    }
}
