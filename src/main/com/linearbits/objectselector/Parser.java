/*
 * ObjectSelector - Object selection library for Java
 * Copyright (C) 2013 Fabian Prasser
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.linearbits.objectselector;

import java.text.ParseException;
import java.util.List;

import com.linearbits.objectselector.ops.AbstractOperator;
import com.linearbits.objectselector.ops.BinaryOperator;
import com.linearbits.objectselector.ops.ParenthesisOperator;
import com.linearbits.objectselector.ops.UnaryOperator;

/**
 * Parser for expressions created with the builder pattern
 * 
 * @author Fabian Prasser
 */
public class Parser<T> {

    /** The list of defined operators */
    private List<AbstractOperator<T>> operators;

    /** The resulting root operator */
    private AbstractOperator<T>       root;

    /**
     * Creates a new parser
     * 
     * @param operators
     */
    protected Parser(List<AbstractOperator<T>> operators) {
        this.operators = operators;
    }

    /**
     * Parses the list of operators within the given range
     * 
     * @param ops
     * @param offset
     * @param length
     * @return
     * @throws ParseException 
     */
    private AbstractOperator<T> compile(List<AbstractOperator<T>> ops, int offset, int length) throws ParseException {

        int lLength = find(ops, offset, length);

        if (lLength == length) {

            // Case 1: EXPR
            if (length == 1) {

                // Return single operator
                return ops.get(offset);

            } else if ((ops.get(offset) instanceof ParenthesisOperator) &&
                       (ops.get(offset + length - 1) instanceof ParenthesisOperator)) {

                // Remove brackets
                return compile(ops, offset + 1, length - 2);

            } else {
                throw new ParseException("Invalid expression", offset);
            }

        } else {

            // Case 2: EXPR <OP> EXPR
            if (!(ops.get(offset + lLength) instanceof BinaryOperator)) {

                // Invalid
                throw new ParseException("Expecting EXPR <OP> EXPR", offset + lLength);
            } else {
                // Binary operator
                BinaryOperator<T> bop = (BinaryOperator<T>) ops.get(offset + lLength);
                bop.setLeft(compile(ops, offset, lLength));
                bop.setRight(compile(ops, offset + lLength + 1, length - lLength - 1));
                return bop;
            }
        }
    }

    /**
     * Finds an expression within the given range
     * 
     * @param ops
     * @param offset
     * @param length
     * @return
     * @throws ParseException 
     */
    private int find(List<AbstractOperator<T>> ops, int offset, int length) throws ParseException {

        if (offset >= ops.size()) { throw new ParseException("Missing expression", offset); }

        AbstractOperator<T> op = ops.get(offset);
        if (op instanceof BinaryOperator) {

            // Invalid
            throw new ParseException("Expression must not start with binary operator", offset);
        } else if (op instanceof UnaryOperator) {

            // Just a unary operator
            return 1;

        } else if (op instanceof ParenthesisOperator) {

            ParenthesisOperator<T> pop = (ParenthesisOperator<T>) op;

            if (!pop.isBegin()) {

                // Invalid
                throw new ParseException("Invalid parenthesis", offset);

            } else {

                // Find closing bracket
                int open = 1;
                for (int i = offset + 1; i < offset + length; i++) {
                    if (ops.get(i) instanceof ParenthesisOperator) {
                        pop = (ParenthesisOperator<T>) ops.get(i);
                        if (pop.isBegin()) open++;
                        else open--;
                        if (open == 0) { return i - offset + 1; }
                    } else {
                    }
                }
                // Invalid
                throw new ParseException("Missing closing parentheses (" + open + ")", length);
            }
        } else {

            // Invalid
            throw new ParseException("Unknown operator", offset);
        }
    }

    /**
     * Starts the compilation process
     */
    protected void parse() throws ParseException {
        if (operators.isEmpty()) { throw new ParseException("Empty expression", 0); }
        this.root = compile(operators, 0, operators.size());
        if (this.root == null) { throw new ParseException("Cannot parse expression", 0); }
    }

    /**
     * Returns the root operator
     * 
     * @return
     */
    protected AbstractOperator<T> getRoot() {
        return root;
    }

}
