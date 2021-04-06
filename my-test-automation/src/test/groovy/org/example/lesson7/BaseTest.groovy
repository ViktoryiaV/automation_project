package org.example.lesson7

import org.example.lesson7.utils.DriverManager
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass

import java.lang.reflect.Method

import static org.example.lesson7.utils.DriverManager.getDriver

class BaseTest {

    @BeforeClass
    void launchBrowser() {
        DriverManager.launchChrome()
    }

    @AfterClass
    void closeBrowser() {
        DriverManager.closeBrowser()
    }

    @AfterMethod
    void takeScreenshot(Method m) {
        File target = new File("target/${m.getName()}${Calendar.instance.timeInMillis}.png")
        File original = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)

        def input = original.newDataInputStream()
        def output = target.newDataOutputStream()
        output << input
        input.close()
        output.close()

        target
    }
}
