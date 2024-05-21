package edu.westminsteru.cmpt300f.turtle

enum Command:
  case Forward(distance: Double)
  case Backward(distance: Double)
  case Left(angle: Double)
  case Right(angle: Double)
  case PenUp
  case PenDown
  
  case Color(val rgb: Int)

  case Reset
  case Clear
  
  case Repeat(count: Int, commands: Seq[Command])
