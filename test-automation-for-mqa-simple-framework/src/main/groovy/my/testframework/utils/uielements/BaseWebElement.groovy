package my.testframework.utils.uielements

import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.WebElement

abstract class BaseWebElement implements WebElement {

    abstract WebElement getElement()

    @Override
    void click() {
        getElement().click()
    }

    @Override
    void submit() {
        getElement().submit()
    }

    @Override
    void sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend)
    }

    @Override
    void clear() {
        getElement().clear()
    }

    @Override
    String getTagName() {
        getElement().getTagName()
    }

    @Override
    String getAttribute(String name) {
        getElement().getAttribute(name)
    }

    @Override
    boolean isSelected() {
        getElement().isSelected()
    }

    @Override
    boolean isEnabled() {
        getElement().isEnabled()
    }

    @Override
    String getText() {
        getElement().getText()
    }

    @Override
    List<WebElement> findElements(By by) {
        getElement().findElements(by)
    }

    @Override
    WebElement findElement(By by) {
        getElement().findElement(by)
    }

    @Override
    boolean isDisplayed() {
        getElement().isDisplayed()
    }

    @Override
    Point getLocation() {
        getElement().getLocation()
    }

    @Override
    Dimension getSize() {
        getElement().getSize()
    }

    @Override
    Rectangle getRect() {
        getElement().getRect()
    }

    @Override
    String getCssValue(String propertyName) {
        getElement().getCssValue(propertyName)
    }

    @Override
    def <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        getElement().getScreenshotAs(target)
    }
}
