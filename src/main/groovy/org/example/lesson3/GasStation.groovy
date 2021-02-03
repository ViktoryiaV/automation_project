package org.example.lesson3

import java.awt.Point

class GasStation extends Location {

    GasStation(String name, Point point) {
        super(name, point)
    }

    void refuel (Vehicle vehicle) {

        vehicle.addFuel()

    }
}
