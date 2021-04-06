package org.example.lesson7.utils.uielements

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
    void sendKeys(CharSequence... charSequences) {
        getElement().sendKeys(charSequences)
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
    String getAttribute(String s) {
        getElement().getAttribute(s)
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
    String getCssValue(String s) {
        getElement().getCssValue(s)
    }

    @Override
    def <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        getElement().getScreenshotAs(outputType)
    }
}
