package org.example.lesson3


class Route {

    protected Location from
    protected Location to

    Route (Location from, Location to) {

        this.from = from
        this.to = to

    }

    double getDistance () {

        from.point.distance(to.point)

    }
}
