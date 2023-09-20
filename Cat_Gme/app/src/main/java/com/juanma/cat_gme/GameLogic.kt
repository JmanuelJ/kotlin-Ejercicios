package com.juanma.cat_gme

import com.juanma.cat_gme.Info.Companion.turn
import com.juanma.cat_gme.Info.Companion.winner
import com.juanma.cat_gme.Info.Companion.winnerType

class GameLogic {


    private var board = arrayOfNulls<String>(9)

    fun pressBox(index: Int) {
        when(turn){
            "X" -> {
                board[index] = "X"
            }
            else ->{
                board[index] = "O"
            }
        }
        }

    fun valueWinner() {
        valueRowDiagonal()
        valueColumn()
    }

    private fun valueRowDiagonal(){

        for(i in 0..8 step 3){
            if(i == 0 && (board[i] == "X" || board[i] == "O")){
                if(board[i] == board[i + 1] && board[i] == board[i + 2]){
                    aplicationWiner()
                }

                if(board[i] == board[i+4] && board[i] == board[i+8]){
                    aplicationWiner()
                }
            }
            if(i == 3 && (board[i] == "X" || board[i] == "O")){
                if(board[i] == board[i + 1] && board[i] == board[i + 2]){
                    aplicationWiner()
                }
            }

            if(i == 6 && (board[i] == "X" || board[i] == "O")){
                if(board[i] == board[i + 1] && board[i] == board[i + 2]){
                    aplicationWiner()
                }
                if(board[i] == board[i - 2] && board[i] == board[i - 4]){
                    aplicationWiner()
                }
            }
        }
    }
    private fun valueColumn(){
        for (i in 0..2 ){
            if(board[i] == "X" || board[i] == "O"){
                if(board[i] == board[i+3] && board[i] == board[i+6]){
                    aplicationWiner()
                }
            }
        }
    }

    private fun aplicationWiner(){
        winner = true
        winnerType = turn
    }


}