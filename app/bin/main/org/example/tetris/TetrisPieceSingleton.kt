package org.example.tetris

class TetrisPieceSingleton private constructor() {
    var attribute: String = "Valor inicial"

    companion object {
        @Volatile
        private var instance: TetrisPieceSingleton? = null

        fun getInstance(): TetrisPieceSingleton {
            return instance ?: synchronized(this) {
                instance ?: TetrisPieceSingleton().also { instance = it }
            }
        }
    }

    fun showAttribute() {
        println(attribute)
    }
}