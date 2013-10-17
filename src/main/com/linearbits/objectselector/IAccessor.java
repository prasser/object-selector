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

import com.linearbits.objectselector.datatypes.DataType;

/**
 * An interface for accessing data elements
 * 
 * @author Fabian Prasser
 * @param <T>
 */
public interface IAccessor<T> {

    /**
     * Returns whether the given context exists
     * 
     * @param context
     * @return
     */
    public boolean exists(String context);

    /**
     * Returns the datatype of the given context
     * 
     * @param context
     * @return
     */
    public DataType<?> getType(String context);

    /**
     * Return the value
     * 
     * @param context
     * @return
     */
    public Object getValue(T object, String context);

    /**
     * Is the getType() method implemented?
     * 
     * @return
     */
    public boolean isDataTypesSupported();

    /**
     * Is the exists() method implemented?
     * 
     * @return
     */
    public boolean isExistanceSupported();
}
