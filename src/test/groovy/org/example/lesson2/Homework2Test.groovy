package org.example.lesson2

import org.testng.annotations.Test

class Homework2Test {

    @Test
    void shouldIGotoSchool() {

        Homework2 homework2 = new Homework2()
        assert !homework2.shouldIGotoSchool(-30, 0.5)
        assert homework2.shouldIGotoSchool(-25, 0.5)
        assert !homework2.shouldIGotoSchool(-21, 1.5)
        assert homework2.shouldIGotoSchool(-21, 0.5)
        assert homework2.shouldIGotoSchool(-19, 10)
    }
}
