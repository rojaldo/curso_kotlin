package org.example.tetris

import org.example.tetris.piezas.TetrisPiece

class TetrisPieceBuilder {
    private var shape: Array<IntArray> = arrayOf()
    private var type: Int = 0

    fun setShape(shape: Array<IntArray>): TetrisPieceBuilder {
        this.shape = shape
        return this
    }

    fun setType(type: Int): TetrisPieceBuilder {
        this.type = type
        return this
    }

    fun build(): TetrisPiece {
        return TetrisPiece(shape, type)
    }
}