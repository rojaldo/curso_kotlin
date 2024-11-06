package org.example

class Rectangle(var width: Double, var height: Double) {

    val area: Double
        get() {
            return width * height
        }

    val perimeter: Double
        get() {
            return 2 * (width + height)
        }
}