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

package de.linearbits.objectselector.util;

import de.linearbits.objectselector.datatypes.DataType;

/**
 * An accessor arrays of doubles
 * 
 * @author Fabian Prasser
 */
public class DoubleArrayAccessor extends PrimitiveArrayAccessor<double[]>{

    /**
     * Constructor without data types. Everything is treated as a string
     * 
     * @param header
     */
    public DoubleArrayAccessor(String[] header) {
        super(header, DataType.NUMERIC);
    }

    /**
     * Constructor with data types
     * 
     * @param header
     * @param datatypes
     */
    public DoubleArrayAccessor(String[] header, DataType<?>[] datatypes) {
        super(header, datatypes);
    }

    @Override
    public Object getValue(double[] object, String context) {
        return object[super.map.get(context)];
    }

}
