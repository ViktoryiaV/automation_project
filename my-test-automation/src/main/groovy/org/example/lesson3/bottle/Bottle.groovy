package org.example.lesson3.bottle

class Bottle {

    private double volume
    private double filledVolume

    Bottle (double volume) {
        this.volume = volume
    }

    // methods

    void fillMaxVolume() {
        filledVolume = volume
    }

    void makeEmpty() {
        filledVolume = 0
    }

    void addWater(double amount) {

        filledVolume += amount
        if (filledVolume > volume) {
            filledVolume = volume
        }
    }

    void pourOutWater(double amount) {

        filledVolume -= amount
        if (filledVolume < 0) {
            filledVolume = 0
        }
    }

    double getVolume() {
        filledVolume
    }

    double getMaxVolume() {
        volume
    }

    boolean isEmpty() {

        if (filledVolume == 0) {
            true
        } else {
            false
        }
    }


}
