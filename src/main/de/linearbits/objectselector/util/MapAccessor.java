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

import java.util.HashMap;
import java.util.Map;

import de.linearbits.objectselector.IAccessor;
import de.linearbits.objectselector.datatypes.DataType;

/**
 * An accessor for map data elements
 * 
 * @author Fabian Prasser
 * 
 * @param <T>
 */
public class MapAccessor<T> implements IAccessor<Map<String, T>> {

    /** The datatypes */
    private Map<String, DataType<?>> map = new HashMap<String, DataType<?>>();

    /**
     * Constructor without data types. Everything is treated as a string
     */
    public MapAccessor() {
        // Empty by design
    }

    /**
     * Constructor with data types
     * 
     * @param map
     */
    public MapAccessor(Map<String, DataType<?>> map) {
        this.map = map;
    }

    @Override
    public boolean exists(String context) {
        return map.containsKey(context);
    }

    @Override
    public DataType<?> getType(String context) {
        return map.get(context);
    }

    @Override
    public Object getValue(Map<String, T> object, String context) {
        return object.get(context);
    }

    @Override
    public boolean isDataTypesSupported() {
        return !map.isEmpty();
    }

    @Override
    public boolean isExistanceSupported() {
        return !map.isEmpty();
    }
}
