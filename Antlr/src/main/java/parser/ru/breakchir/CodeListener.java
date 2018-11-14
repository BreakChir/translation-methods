// Generated from ru\breakchir\Code.g4 by ANTLR 4.7.1

    package ru.breakchir;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodeParser}.
 */
public interface CodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodeParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CodeParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CodeParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void enterSet_expr(CodeParser.Set_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void exitSet_expr(CodeParser.Set_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CodeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CodeParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exprElse}.
	 * @param ctx the parse tree
	 */
	void enterExprElse(CodeParser.ExprElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exprElse}.
	 * @param ctx the parse tree
	 */
	void exitExprElse(CodeParser.ExprElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(CodeParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(CodeParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#bool_cond}.
	 * @param ctx the parse tree
	 */
	void enterBool_cond(CodeParser.Bool_condContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#bool_cond}.
	 * @param ctx the parse tree
	 */
	void exitBool_cond(CodeParser.Bool_condContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(CodeParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(CodeParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#bool_cmp}.
	 * @param ctx the parse tree
	 */
	void enterBool_cmp(CodeParser.Bool_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#bool_cmp}.
	 * @param ctx the parse tree
	 */
	void exitBool_cmp(CodeParser.Bool_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#int_cmp}.
	 * @param ctx the parse tree
	 */
	void enterInt_cmp(CodeParser.Int_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#int_cmp}.
	 * @param ctx the parse tree
	 */
	void exitInt_cmp(CodeParser.Int_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#int_op}.
	 * @param ctx the parse tree
	 */
	void enterInt_op(CodeParser.Int_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#int_op}.
	 * @param ctx the parse tree
	 */
	void exitInt_op(CodeParser.Int_opContext ctx);
}