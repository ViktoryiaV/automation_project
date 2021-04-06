package org.example.lesson3

class Vehicle {

    protected String model
    protected String type
    private double tankVolume
    private double currentTankVolume
    private double fuelConsumption
    private Location location
    private Location previousLocation

    Vehicle(String model, String type, double tankVolume, double fuelConsumption) {

        this.model = model
        this.type = type
        this.tankVolume = tankVolume
        currentTankVolume = tankVolume
        this.fuelConsumption = fuelConsumption

    }

    // methods

    void setFirstLocation(Location location) {

        this.location = location
        println("First location is $location.name, left fuel is ${currentTankVolume as int}")

    }

    void addFuel () {

        int amount = tankVolume - currentTankVolume
        currentTankVolume += amount
        println("Refueled for $amount litters, left fuel is ${currentTankVolume as int} l")

    }

    void driveTo (Location to) {

        double distance = new Route(location, to).getDistance()
        double consumedFuel = (fuelConsumption * distance) / 100

        if (currentTankVolume >= consumedFuel) {

            currentTankVolume -= consumedFuel
            previousLocation = location
            location = to

            println("Next location is $location.name, distance traveled is " +
                    "${distance as int} km, left fuel is ${currentTankVolume as int} l")

            if (to instanceof GasStation) {
                to.refuel(this)
            }
        } else {

            throw new RuntimeException("Fuel is not enough to reach $to.name")
        }
    }
}
