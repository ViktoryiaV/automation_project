package my.testframework.utils.uielements

import groovy.util.logging.Log4j
import org.openqa.selenium.By

import static my.testframework.utils.DriverManager.getDriver
import static my.testframework.utils.WaitUtil.waitForCondition


@Log4j
class WebElement extends BaseWebElement {

    private String xpath

    WebElement(String xpath) {
        this.xpath = xpath
    }

    org.openqa.selenium.WebElement getElement() {
        log.debug("Getting element - $this")
        getDriver().findElement(By.xpath(xpath))
    }

    @Override
    boolean isDisplayed() {
        getDriver().findElements(By.xpath(xpath)).any { it.isDisplayed() }
    }

    boolean isPresent() {
        getDriver().findElements(By.xpath(xpath)).size() > 0
    }

    @Override
    String toString() {
        xpath
    }

    void waitForVisible() {
        waitForCondition(10, 500) {
            try {
                isDisplayed()
            } catch (org.openqa.selenium.NoSuchElementException ignored) {
                false
            }
        }
    }

    void waitForNotVisible() {
        waitForCondition(10, 500) {
            try {
                !isDisplayed()
            } catch (org.openqa.selenium.NoSuchElementException ignored) {
                false
            }
        }
    }
}
