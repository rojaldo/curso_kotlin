package org.example.tetris.piezas

class TetrisPiece(var shape: Array<IntArray>, val type: Int) {

    protected var rotation = 0
    // print shape 
    fun print() {
        shape.forEach {
            it.forEach {
                print(if (it == 0) " " else "*")
            }
            println()
        }
    }

}