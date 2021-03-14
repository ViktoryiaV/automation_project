package org.example.lesson8

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.ElementNotVisibleException
import org.openqa.selenium.Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.Test

import java.awt.Dimension
import java.time.Duration
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class SeleniumTests {

    @Test(priority = 101)
    void seleniumTest() {

        //WebDriverManager.chromedriver().setup()
        WebDriverManager.firefoxdriver().setup()
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        DesiredCapabilities capabilities = DesiredCapabilities.firefox()

        ChromeOptions options = new ChromeOptions()
        options.addArguments('--incognito')
        //options.addArguments('--headless')
        //options.addArguments('--window-size=1920,1080')
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)

        //WebDriver driver = new ChromeDriver(capabilities)
        WebDriver driver = new FirefoxDriver(capabilities)
        driver.get('https://todomvc.com/examples/backbone')

        driver.manage().window().maximize()

        //driver.manage().window().setSize(new org.openqa.selenium.Dimension(400,400))

        def inputBy = By.xpath("//section//input[contains(@class,'new-todo')]")
        WebElement element = driver.findElement(inputBy)

/*        def placeholderBy = By.xpath("//input[@placeholder]")
        WebElement element2 = driver.findElement(placeholderBy)
        assert element2.getAttribute('placeholder') == "What needs to be done?"*/

        element.sendKeys('Hello')
/*        element.clear()
        element.sendKeys('Hello' + Keys.ENTER)
        printScreen(driver)*/

        assert element.getAttribute('value') == 'Hello'



        waitCondition(30, 500) {
            driver.findElement(inputBy).isDisplayed()
        }




        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)


/*        WebDriverWait wait = new WebDriverWait(driver, 30)
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputBy))

        Wait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoreAll([ElementNotVisibleException])
        fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(inputBy)
            }
        }) as WebElement*/


        //List<WebElement> elements = driver.findElements()

        //driver.close()
        driver.quit()
    }

    File printScreen(WebDriver driver) {
        File target = new File("target/${Calendar.instance.timeInMillis}.png")
        File original = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)

        def input = original.newDataInputStream()
        def output = target.newDataOutputStream()
        output << input
        input.close()
        output.close()

        target
    }

    void waitCondition(int sec, int ping, Closure condition) {
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
