// Generated from ru\breakchir\Grammar.g4 by ANTLR 4.7.1

    package ru.breakchir;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#choose_roole}.
	 * @param ctx the parse tree
	 */
	void enterChoose_roole(GrammarParser.Choose_rooleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#choose_roole}.
	 * @param ctx the parse tree
	 */
	void exitChoose_roole(GrammarParser.Choose_rooleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(GrammarParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(GrammarParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rets}.
	 * @param ctx the parse tree
	 */
	void enterRets(GrammarParser.RetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rets}.
	 * @param ctx the parse tree
	 */
	void exitRets(GrammarParser.RetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(GrammarParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(GrammarParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#partpat}.
	 * @param ctx the parse tree
	 */
	void enterPartpat(GrammarParser.PartpatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#partpat}.
	 * @param ctx the parse tree
	 */
	void exitPartpat(GrammarParser.PartpatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammarParser.ParamContext ctx);
}