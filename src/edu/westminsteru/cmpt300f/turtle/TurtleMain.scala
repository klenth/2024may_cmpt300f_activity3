package edu.westminsteru.cmpt300f.turtle

import java.util.Scanner

object TurtleMain:
  def main(args: Array[String]): Unit =
    val in = Scanner(System.in)
    val window = TurtleWindow(fieldWidth = 500, fieldHeight = 500)
    window.setVisible(true)

    while (true) {
      println()
      val line = in.nextLine()

      try {
        val command = Command.parse(line)
        window.executeCommand(command)
      } catch
        case e: Exception => e.printStackTrace()
    }
