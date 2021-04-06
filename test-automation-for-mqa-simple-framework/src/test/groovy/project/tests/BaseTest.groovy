package project.tests

import my.testframework.utils.DriverManager
import my.testframework.utils.Reporter
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Listeners

@Listeners([Reporter])
class BaseTest {

    @BeforeClass
    void launchBrowser() {
        DriverManager.launchBrowser()
    }

    @AfterClass
    void closeBrowser() {
        DriverManager.closeBrowser()
    }

}
