package edu.westminsteru.cmpt300f.turtle

case class Turtle(x: Double = 0,
                   y: Double = 0,
                   angle: Double = -90,
                   color: Int = 0x000000,
                   penDown: Boolean = true
                 ):

  def move(distance: Double): Turtle =
    val radians = angle * Math.PI / 180
    copy(
      x = x + distance * Math.cos(radians),
      y = y + distance * Math.sin(radians)
    )

  def turn(turnAngle: Double): Turtle =
    copy(angle = angle + turnAngle)

  def setPenColor(newColor: Int): Turtle =
    copy(color = newColor)

  def setPenDown(newPenDown: Boolean): Turtle =
    copy(penDown = newPenDown)
