package org.example.lesson3


class Main {

    static void main(args) {

        Vehicle car = new Vehicle("Subaru Impreza", "car", 60, 15)
        Vehicle motorcycle = new Vehicle("Triumph Thunderbird", "motorcycle", 22, 5)
        Vehicle truck = new Vehicle("Gas-3302", "truck", 70, 12)

        Location paris = new Location("Paris", new java.awt.Point(620, 160))
        Location caen = new Location("Caen", new java.awt.Point(400, 195))
        Location quemper = new Location("Quemper", new java.awt.Point(50, 100))

        GasStation station1 = new GasStation("Station 1", new java.awt.Point(210, 107))
        GasStation station2 = new GasStation("Station 2", new java.awt.Point(510, 115))
        GasStation station3 = new GasStation("Station 3", new java.awt.Point(515, 200))
        GasStation station4 = new GasStation("Station 4", new java.awt.Point(208, 145))

        // car journey

        println("${car.type.capitalize()} $car.model Journey:")
        car.setFirstLocation(paris)
        car.driveTo(station3)
        car.driveTo(caen)
        car.driveTo(station4)
        car.driveTo(quemper)

        println("--------------------------")
        // truck journey

        println("${truck.type.capitalize()} $truck.model Journey:")
        truck.setFirstLocation(quemper)
        truck.driveTo(station1)
        //truck.driveTo(station2)
        truck.driveTo(paris)

        println("--------------------------")
        // motorcycle journey

        println("${motorcycle.type.capitalize()} $motorcycle.model Journey:")
        motorcycle.setFirstLocation(caen)
        motorcycle.driveTo(station3)
        motorcycle.driveTo(paris)

    }
}
