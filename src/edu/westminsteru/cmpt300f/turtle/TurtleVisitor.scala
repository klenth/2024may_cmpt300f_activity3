package edu.westminsteru.cmpt300f.turtle

import edu.westminsteru.cmpt300f.turtle.parser.{TurtleBaseVisitor, TurtleParser}
import org.antlr.v4.runtime.ParserRuleContext
import Command.*

// Allows us to write ".asScala" on a Java collection to wrap it in a Scala
// equivalent
import scala.jdk.CollectionConverters._

object TurtleVisitor extends TurtleBaseVisitor[Command] {

  override def visitForward(ctx: TurtleParser.ForwardContext): Command =
    Forward(ctx.NUMBER().getText.toDouble)

  override def visitBackward(ctx: TurtleParser.BackwardContext): Command =
    Backward(ctx.NUMBER().getText.toDouble)

  override def visitLeft(ctx: TurtleParser.LeftContext): Command =
    Left(ctx.NUMBER().getText.toDouble)

  override def visitRight(ctx: TurtleParser.RightContext): Command =
    Right(ctx.NUMBER().getText.toDouble)

  override def visitPenUp(ctx: TurtleParser.PenUpContext): Command =
    PenUp

  override def visitPenDown(ctx: TurtleParser.PenDownContext): Command =
    PenDown

  override def visitColor(ctx: TurtleParser.ColorContext): Command =
    (ctx.COLOR_NAME(), ctx.COLOR_HEX()) match {
      case (name, null) => name.getText match {
        case "black"    => Color(0x000000)
        case "red"      => Color(0xa00000)
        case "green"    => Color(0x00a000)
        case "blue"     => Color(0x0000a0)
        case "yellow"   => Color(0xa0a000)
        case "magenta"  => Color(0xa000a0)
        case "cyan"     => Color(0x00a0a0)
        case "white"    => Color(0xffffff)
      }

      case (null, hex)  => Color(java.lang.Integer.parseInt(hex.getText.substring(1), 16))
    }

  override def visitResetTurtle(ctx: TurtleParser.ResetTurtleContext): Command =
    Reset

  override def visitClear(ctx: TurtleParser.ClearContext): Command =
    Clear

  override def visitRepeat(ctx: TurtleParser.RepeatContext): Command =
    Repeat(
      ctx.count.getText.toDouble.toInt,
      ctx.block().commands.asScala.map(visitCommand).toSeq
    )
}
