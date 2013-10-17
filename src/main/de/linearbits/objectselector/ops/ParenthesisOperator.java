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

package de.linearbits.objectselector.ops;

import de.linearbits.objectselector.IAccessor;

/**
 * Class for parentheses
 * @author Fabian Prasser
 */
public class ParenthesisOperator<T> extends AbstractOperator<T>{
    
	/** Open or close parentheses*/
	protected final boolean begin;
    
	/**
	 * Constructor
	 * @param begin
	 */
	public ParenthesisOperator(IAccessor<T> accessor, boolean begin) {
        super(accessor, 0);
        this.begin = begin;
    }
    
    @Override
    public boolean eval(T object) {
        throw new UnsupportedOperationException("Parentheses cannot be evaluated");
    }
    
    /** Open or close parentheses*/
    public boolean isBegin() {
    	return begin;
    }

	@Override
	public void toString(StringBuffer buffer, String prefix) {
		if (begin) {
			buffer.append(prefix).append("(");
		} else {
			buffer.append(prefix).append(")");			
		}
	}
}