package edu.westminsteru.cmpt300f.turtle

import java.awt.BorderLayout
import javax.swing.*

class TurtleWindow(val fieldWidth: Int, val fieldHeight: Int) extends JFrame("Turtle"):

  private val canvas: TurtleCanvas = TurtleCanvas(fieldWidth, fieldHeight)
  val executeCommand: Command => Unit = canvas.executeCommand

  setLayout(new BorderLayout())
  add(canvas, BorderLayout.CENTER)
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

  pack()
  setResizable(false)

