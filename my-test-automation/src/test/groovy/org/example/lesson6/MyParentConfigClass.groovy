package org.example.lesson6

import org.testng.annotations.AfterSuite
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeSuite
import org.testng.annotations.BeforeTest

class MyParentConfigClass {

    @BeforeSuite
    void beforeSuiteConfig() {
        println('--------------------------------------------- beforeSuiteConfig')
    }

    @AfterSuite
    void afterSuiteConfig() {
        println('--------------------------------------------- afterSuiteConfig')
    }

    @BeforeTest
    void beforeTestConfig() {
        println('----------------------- beforeTestConfig')
    }

    @AfterTest
    void afterTestConfig() {
        println('----------------------- afterTestConfig')
    }
}
