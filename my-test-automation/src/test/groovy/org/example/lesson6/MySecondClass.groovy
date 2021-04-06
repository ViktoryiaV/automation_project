package org.example.lesson6

import org.testng.annotations.Test

class MySecondClass extends MyParentConfigClass {

    @Test(priority = 201)
    void firstTest() {
        println('Run of MySecondClass firstTest')
        assert 1 < 5
    }

    @Test(priority = 202)
    void secondTest() {
        println('Run of MySecondClass secondTest')
        assert 1 < 5
    }
}
