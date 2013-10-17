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

/**
 * A callback for the tokenizer
 * @author Fabian Prasser
 */
public interface ICallback {

	/** 
	 * Logical and
	 * 
	 * @param start
	 * @param length
	 */
    void and(int start, int length);
    
    /**
     * Open parenthesis
     * @param start
     */
    void begin(int start);
    
    /**
     * Closing parenthesis
     * @param start
     */
    void end(int start);
    
    /**
     * Equals
     * @param start
     */
    void equals(int start);
    
    /**
     * Field
     * @param start
     * @param length
     */
    void field(int start, int length);
    
    /**
     * Greater than or equals
     * @param start
     * @param length
     */
    void geq(int start, int length);
    
    /**
     * Greater than
     * @param start
     */
    void greater(int start);
    
    /**
     * Invalid expression
     * @param start
     */
    void invalid(int start);
    
    /**
     * Less than or equals
     * @param start
     * @param length
     */
    void leq(int start, int length);
    
    /**
     * Less than
     * @param start
     */
    void less(int start);
    
    /**
     * Logical or
     * @param start
     * @param length
     */
    void or(int start, int length);
    
    /**
     * Value
     * @param start
     * @param length
     */
    void value(int start, int length);
}

