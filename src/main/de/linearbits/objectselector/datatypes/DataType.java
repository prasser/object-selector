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
 * A base class for data types
 * @author Fabian Prasser
 */
public abstract class DataType<T> {

    /** String*/
    public static final DString  STRING  = new DString();
    /** Numeric*/
    public static final DDouble  NUMERIC  = new DDouble();
    /** Date with format "yyyy-MM-dd"*/
    public static final DDate    DATE    = new DDate("yyyy-MM-dd");
    /** Boolean*/
    public static final DBoolean BOOLEAN = new DBoolean();
    /** Date with given format*/
    public static final DDate    DATE(String format) { return new DDate(format); }

    /**
     * Converts an object
     * @param object
     * @return
     */
    public abstract T fromObject(Object object);

    /**
     * Converts a string
     * @param string
     * @return
     */
    public abstract T fromString(String string);
}
