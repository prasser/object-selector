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
 * Abstract base class for binary operators
 * @author Fabian Prasser
 */
public abstract class BinaryOperator<T> extends AbstractOperator<T>{
    
	/** Left child*/
	protected AbstractOperator<T> left;
	/** Right child*/
	protected AbstractOperator<T> right;
	/** For conversion to string*/
	private final String label;

	/**
	 * Constructor
	 */
    public BinaryOperator(IAccessor<T> accessor, String label) {
        super(accessor, 2);
        this.label = label;
    }

    /** Returns the left operator*/
	public AbstractOperator<T> getLeft() {
		return left;
	}

	/** Returns the right operator*/
	public AbstractOperator<T> getRight() {
		return right;
	}

	/** Sets the left operator*/
	public void setLeft(AbstractOperator<T> left) {
		this.left = left;
	}

	/** Sets the right operator*/
	public void setRight(AbstractOperator<T> right) {
		this.right = right;
	}
	
	@Override
	public void toString(StringBuffer buffer, String prefix) {
		buffer.append(prefix);
		buffer.append(label);
		buffer.append("\n");
		left.toString(buffer, prefix + "   ");
		buffer.append("\n");
		right.toString(buffer, prefix + "   ");	
	}
}
