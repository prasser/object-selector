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

package de.linearbits.objectselector.datatypes;

/**
 * Double data type
 * @author Fabian Prasser
 */
public class DDouble extends DataType<Double>{

    protected DDouble(){
        // Empty by design
    }

    @Override
    public Double fromObject(Object object) {
    	if (object instanceof Double) return (Double)object;
    	else if (object instanceof Character) return Double.valueOf((Character)object);
    	else if (object instanceof Short) return Double.valueOf((Short)object);
    	else if (object instanceof Integer) return Double.valueOf((Integer)object);
    	else if (object instanceof Float) return Double.valueOf((Float)object);
        return fromString(String.valueOf(object));
    }

    @Override
    public Double fromString(String value) {
        return Double.valueOf(value);
    }
}
