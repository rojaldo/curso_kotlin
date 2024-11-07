package org.example

class Circle(var radius: Double) {

    val area: Double
        get() {
            return Math.PI * Math.pow(radius, 2.0)
        }

    val perimeter: Double
        get() {
            return 2 * Math.PI * radius
        }
}