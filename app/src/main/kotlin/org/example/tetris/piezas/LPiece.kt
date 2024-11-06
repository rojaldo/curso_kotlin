package org.example.tetris.piezas

class LPiece : TetrisPiece(arrayOf(
    intArrayOf( 0,0, 0, 0, 0),
    intArrayOf( 0,0, 0, 1, 0),
    intArrayOf( 0,1, 1, 1, 0),
    intArrayOf( 0,0, 0, 0, 0),
    intArrayOf( 0,0, 0, 0, 0),
), 1) {

    //rotations of the piece 

    
    val  rotations = arrayOf(
            arrayOf(
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,0, 0, 1, 0),
                intArrayOf( 0,1, 1, 1, 0),
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,0, 0, 0, 0),
            ),
            arrayOf(
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,0, 1, 0, 0),
                intArrayOf( 0,0, 1, 0, 0),
                intArrayOf( 0,0, 1, 1, 0),
                intArrayOf( 0,0, 0, 0, 0),
            ),
            arrayOf(
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,1, 1, 1, 0),
                intArrayOf( 0,1, 0, 0, 0),
                intArrayOf( 0,0, 0, 0, 0),
            ),
            arrayOf(
                intArrayOf( 0,0, 0, 0, 0),
                intArrayOf( 0,1, 1, 0, 0),
                intArrayOf( 0,0, 1, 0, 0),
                intArrayOf( 0,0, 1, 0, 0),
                intArrayOf( 0,0, 0, 0, 0),
            )
        )

        fun rotate() {
            rotation = (rotation + 1) % 4
            shape = rotations[rotation]
        }
    
}