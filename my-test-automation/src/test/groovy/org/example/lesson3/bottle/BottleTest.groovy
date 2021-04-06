package org.example.lesson3.bottle

import org.testng.annotations.Test

class BottleTest {

    @Test
    void myBottleTest() {
        Bottle bottle = new Bottle(1.5)
        assert bottle.isEmpty()
        assert bottle.getMaxVolume() == 1.5d

        bottle.addWater(1)
        assert !bottle.isEmpty()
        assert bottle.getVolume() == 1

        bottle.pourOutWater(0.6)
        assert bottle.getVolume() == 0.4d

        bottle.pourOutWater(0.5)
        assert bottle.isEmpty()

        bottle.addWater(5)
        assert bottle.getVolume() == bottle.getMaxVolume()

        bottle.makeEmpty()
        assert bottle.isEmpty()

        bottle.fillMaxVolume()
        assert bottle.getVolume() == bottle.getMaxVolume()

        bottle.pourOutWater(2)
        assert bottle.isEmpty()
    }
}
