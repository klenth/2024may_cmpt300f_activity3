package edu.westminsteru.cmpt300f.turtle

import edu.westminsteru.cmpt300f.turtle.parser.*
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import edu.westminsteru.cmpt300f.turtle.TurtleVisitor

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
        val command = parseCommand(line)
        window.executeCommand(command)
      } catch
        case e: Exception => e.printStackTrace()
    }

  private def parseCommand(text: String): Command =
    val lexer = TurtleLexer(CharStreams.fromString(text))
    val parser = TurtleParser(new CommonTokenStream(lexer))
    val ctx = parser.command()
    TurtleVisitor.visitCommand(ctx)
