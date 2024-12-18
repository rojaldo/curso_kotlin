/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

// import persona class

import org.example.Persona
// import org.example.tetris.piezas.LPiece
import org.example.tetris.TetrisPieceSingleton
import org.example.tetris.TetrisPieceBuilder

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun charCount(s: String, c: Char): Int {
    return s.count { it == c }
}

//charCount as lambda

val charCount: (String, Char) -> Int = { s, c -> s.count { it == c } 

}

fun invertString(s: String): String {
    return s.reversed()
}

// invertString as lambda

val invertString: (String) -> String = { s -> s.reversed() }

// minutes to hours:minutes
fun convertMinutesToHMm(minutes: Int): String {
    val hours = minutes / 60
    val minutes = minutes % 60
    // min < 10 -> 0min
    var minStr = if (minutes < 10) "0$minutes" else minutes.toString()
    var hStr = if (hours < 10) "0$hours" else hours.toString()
    return "$hStr:$minStr"
}

fun nthNumberInArray(n: Int, arr: Array <Int>): Int {
    if (n > arr.size || n < 0) throw IllegalArgumentException("n must be between 0 and array size")
    arr.sortDescending()
    return arr[n-1]
}

fun main() {

    println(charCount("Hello World!", 'o'))

    println(invertString("Hello World!"))

    println(convertMinutesToHMm(123))

    // try
    try {
        println(nthNumberInArray(-3, arrayOf(1, 2, 3, 4, 5)))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    var myList = listOf(1, 2, 3, 4, 5)

    var myArray = arrayOf(1, 2, 3, 4, 5)

    // push to list

    myList = myList + 6

    // push to array a new element (6)

    myArray = myArray.plus(6)

    println(myList)
    println(myArray.toList())

    val persona = Persona("Juan", 30)
    println("Nombre: ${persona.nombre }")

    val circle = Circle(5.0)
    println("Radio: ${circle.radius} Area: ${circle.area} Perimeter: ${circle.perimeter}")
    circle.radius = 3.0
    println("Radio: ${circle.radius} Area: ${circle.area} Perimeter: ${circle.perimeter}")

    

    
    // val lPiece = LPiece()
    // lPiece.print()
    // lPiece.rotate()
    // lPiece.print()

    var singleton = TetrisPieceSingleton.getInstance()
    singleton.showAttribute() // Imprime: Valor inicial

    // Modificando el atributo del singleton
    singleton.attribute = "Nuevo valor"
    singleton.showAttribute() 
    singleton = TetrisPieceSingleton.getInstance()
    singleton.showAttribute() // Imprime: Nuevo valor


    val tetrisPiece = TetrisPieceBuilder()
        .setShape(arrayOf(
            intArrayOf( 0,0, 0, 0, 0),
            intArrayOf( 0,0, 0, 1, 0),
            intArrayOf( 0,1, 1, 1, 0),
            intArrayOf( 0,0, 0, 1, 0),
            intArrayOf( 0,0, 0, 0, 0),
        )).setType(1).build()

    tetrisPiece.print();
}
