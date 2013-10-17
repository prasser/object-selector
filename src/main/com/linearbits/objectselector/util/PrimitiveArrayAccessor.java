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

package com.linearbits.objectselector.util;

import java.util.HashMap;
import java.util.Map;

import com.linearbits.objectselector.IAccessor;
import com.linearbits.objectselector.datatypes.DataType;

/**
 * An accessor arrays of primitives
 * 
 * @author Fabian Prasser
 * 
 * @param <T>
 */
public abstract class PrimitiveArrayAccessor<T> implements IAccessor<T> {

    /** Indexes */
    protected Map<String, Integer>     map = new HashMap<String, Integer>();

    /** Datatypes */
    protected Map<String, DataType<?>> dt  = new HashMap<String, DataType<?>>();

    /**
     * Constructor without data types. Everything is treated as a string
     * 
     * @param header
     */
    public PrimitiveArrayAccessor(String[] header, DataType<?> type) {
        for (int i = 0; i < header.length; i++) {
            map.put(header[i], i);
            dt.put(header[i], type);
        }
    }

    /**
     * Constructor with data types
     * 
     * @param header
     * @param datatypes
     */
    public PrimitiveArrayAccessor(String[] header, DataType<?>[] datatypes) {
        for (int i = 0; i < header.length; i++) {
            map.put(header[i], i);
            dt.put(header[i], datatypes[i]);
        }
    }

    @Override
    public boolean exists(String context) {
        return map.containsKey(context);
    }

    @Override
    public DataType<?> getType(String context) {
        return dt.get(context);
    }

    @Override
    public boolean isDataTypesSupported() {
        return !dt.isEmpty();
    }

    @Override
    public boolean isExistanceSupported() {
        return true;
    }
}
