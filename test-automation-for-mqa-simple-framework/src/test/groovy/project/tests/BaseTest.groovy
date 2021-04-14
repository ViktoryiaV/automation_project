package project.tests

import my.testframework.utils.DriverManager
import my.testframework.utils.Reporter
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Listeners

@Listeners([Reporter])
class BaseTest {

    @BeforeTest
    void launchBrowser() {
        DriverManager.launchBrowser()
    }

    @AfterTest
    void closeBrowser() {
        DriverManager.closeBrowser()
    }

}
