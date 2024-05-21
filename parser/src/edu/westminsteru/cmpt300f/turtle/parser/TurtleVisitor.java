// Generated from /home/kathy/IdeaProjects/2024may_cmpt300f_activity3/parser/Turtle.g4 by ANTLR 4.13.1
package edu.westminsteru.cmpt300f.turtle.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TurtleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TurtleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TurtleParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(TurtleParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TurtleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#forward}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForward(TurtleParser.ForwardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#backward}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackward(TurtleParser.BackwardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#left}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft(TurtleParser.LeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight(TurtleParser.RightContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#penUp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenUp(TurtleParser.PenUpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#penDown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenDown(TurtleParser.PenDownContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(TurtleParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#resetTurtle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetTurtle(TurtleParser.ResetTurtleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#clear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClear(TurtleParser.ClearContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(TurtleParser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#nl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNl(TurtleParser.NlContext ctx);
}