package edu.westminsteru.cmpt300f.turtle

import java.awt.{BasicStroke, Color, Dimension, Graphics, Graphics2D, RenderingHints, Shape}
import java.awt.geom.{GeneralPath, Line2D}
import java.awt.image.BufferedImage
import javax.swing.JComponent
import scala.compiletime.uninitialized

class TurtleCanvas(val fieldWidth: Int, val fieldHeight: Int) extends JComponent {

  private var buffer: BufferedImage = uninitialized
  private var bufferGraphics: Graphics2D = uninitialized
  private var turtle: Turtle = uninitialized

  buffer = new BufferedImage(fieldWidth, fieldHeight, BufferedImage.TYPE_INT_RGB)
  bufferGraphics = buffer.createGraphics()
  bufferGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
  resetTurtle()
  clearCanvas()

  private def turtleShape: Shape =
    val p = GeneralPath()
    p.moveTo(-10, -10)
    p.lineTo(20, 0)
    p.lineTo(-10, 10)
    p.closePath()
    p

  protected override def paintComponent(_g: Graphics): Unit =
    val g = _g.create().asInstanceOf[Graphics2D]
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    g.drawImage(buffer, 0, 0, null)
    g.translate(turtle.x, turtle.y)
    g.rotate(turtle.angle * Math.PI / 180)
    g.setPaint(new Color(turtle.color))
    g.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
    if (turtle.penDown)
      g.fill(turtleShape)
    else
      g.draw(turtleShape)
    g.dispose()

  override def getPreferredSize: Dimension =
    Dimension(fieldWidth, fieldHeight)

  private def clearCanvas(): Unit =
    bufferGraphics.setPaint(Color.WHITE)
    bufferGraphics.fillRect(0, 0, fieldWidth, fieldHeight)
    bufferGraphics.setPaint(Color.BLACK)
    bufferGraphics.drawRect(0, 0, fieldWidth, fieldHeight)
    bufferGraphics.setStroke(new BasicStroke(3f))

  private def resetTurtle(): Unit =
    turtle = Turtle(x = fieldWidth / 2, y = fieldHeight / 2)

  def executeCommand(command: Command): Unit =
    import Command._

    command match
      case Forward(distance)        =>
        val newTurtle = turtle.move(distance)
        bufferGraphics.setPaint(new java.awt.Color(turtle.color))
        if (turtle.penDown)
          bufferGraphics.draw(new Line2D.Double(turtle.x, turtle.y, newTurtle.x, newTurtle.y))
        turtle = newTurtle

      // handle other commands...

    Thread.sleep(120)
    repaint()
}
