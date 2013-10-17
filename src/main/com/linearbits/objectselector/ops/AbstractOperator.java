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

package com.linearbits.objectselector.ops;

import com.linearbits.objectselector.IAccessor;

/**
 * Abstract base class for operators
 * @author Fabian Prasser
 */
public abstract class AbstractOperator<T> {
	
	/** Number of operands*/
    protected final int operands;
    protected final IAccessor<T> accessor;
    
    /**
     * Creates a new instance
     * @param accessor
     * @param operands
     */
    protected AbstractOperator(IAccessor<T> accessor, int operands){
        this.operands = operands;
        this.accessor = accessor;
    }
    
    /**
     * Evaluate the given element
     * @param object
     * @return
     */
    public abstract boolean eval(T object);
    
    /**
     * Returns the number of operands
     * @return
     */
    public int getNumOperands(){
    	return this.operands;
    }

    /**
     * Writes a string representation of the operator tree to the buffer
     * @param buffer
     * @param prefix
     */
	public abstract void toString(StringBuffer buffer, String prefix);
}
