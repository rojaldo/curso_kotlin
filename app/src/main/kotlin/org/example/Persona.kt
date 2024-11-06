package org.example

class Persona(val nombre: String, var edad: Int) {
    val esMayorEdad: Boolean
        get() = edad >= 18

    fun presentarse() {
        println("Hola, soy $nombre y tengo $edad años")
    }
    
}
