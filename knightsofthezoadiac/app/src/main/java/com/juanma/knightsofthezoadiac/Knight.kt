package com.juanma.knightsofthezoadiac

import android.util.Log

class Knight (val name: String, val armor: String, var powerUp: Boolean){

      fun viewInf(): String{
          var info = "knight: " + name +"\nArmor: " + armor

          if(powerUp == true) {
              info += "\n Strong and ready to fight"
          }
          else {
              info += "\nWeak knight"
          }

          return info
      }

      fun initPowerUp(): String{
          powerUp = true

          return "$name is increasing his strength"
      }

      fun fight(): String = "$name with armor $armor is fighting"

      fun cleanView(){

      }

  }
