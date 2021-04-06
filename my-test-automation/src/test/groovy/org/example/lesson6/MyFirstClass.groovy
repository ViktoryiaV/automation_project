package org.example.lesson6

import org.testng.Assert
import org.testng.SkipException
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals


class MyFirstClass extends MyParentConfigClass {

    @BeforeClass
    void beforeClassConfig() {
        println('---------- MyFirstClass beforeClassConfig')
    }

    @AfterClass
    void afterClassConfig() {
        println('---------- MyFirstClass afterClassConfig')
    }

    @BeforeMethod
    void beforeMethodConfig() {
        println('------- MyFirstClass beforeMethodConfig')
    }

    @AfterMethod
    void afterMethodConfig() {
        println('------- MyFirstClass afterMethodConfig')
    }

    @Test(priority = 101, dataProvider = "provideDataForMultiplyTest")
    void multiplyTest(int a, int b, int expected) {
        println('Run of MyFirstClass firstTest')
        int actualResult =  a * b
        assertEquals(actualResult, expected, 'Multiplication works incorrectly.')
    }

    @DataProvider
    Object[][] provideDataForMultiplyTest() {
        [
                [4, 4, 16],
                [7, 10, 70],
                [1, -3, -7]
        ]
    }

    @Test(priority = 102)
    void secondTest() {
        println('Run of MyFirstClass secondTest')
        try {
            throw new Exception('Test 2 fails')
        } catch(Throwable e) {
            println(e.getMessage())
        }
    }

    @Test(priority = 103)
    void skippedTest() {
        println('Run of MyFirstClass secondTest')
        boolean precondition = false
        if (!precondition) {
            throw new SkipException('skippedTest is skipped')
        }
    }
}
