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

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.linearbits.objectselector.IAccessor;
import de.linearbits.objectselector.datatypes.DataType;

/**
 * An accessor for object data elements
 * 
 * @author Fabian Prasser
 * 
 * @param <T>
 */
public class ObjectAccessor<T> implements IAccessor<T> {

    /** The data types */
    private Map<String, DataType<?>> dt = new HashMap<String, DataType<?>>();

    /**
     * Constructor
     * 
     * @param clazz
     */
    public ObjectAccessor(Class<T> clazz) {

        for (Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            Class<?> type = field.getType();
            if (type.equals(Integer.class)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Float.class)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Short.class)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Character.class)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Double.class)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(String.class)) {
                dt.put(name, DataType.STRING);
            } else if (type.equals(Boolean.class)) {
                dt.put(name, DataType.BOOLEAN);
            } else if (type.equals(Date.class)) {
                dt.put(name, DataType.DATE);
            } else if (type.equals(Integer.TYPE)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Float.TYPE)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Short.TYPE)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Character.TYPE)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Double.TYPE)) {
                dt.put(name, DataType.NUMERIC);
            } else if (type.equals(Boolean.TYPE)) {
                dt.put(name, DataType.BOOLEAN);
            }
        }
    }

    @Override
    public boolean exists(String context) {
        return dt.containsKey(context);
    }

    @Override
    public DataType<?> getType(String context) {
        return dt.get(context);
    }

    @Override
    public Object getValue(T object, String context) {
        try {
            return object.getClass().getDeclaredField(context).get(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDataTypesSupported() {
        return true;
    }

    @Override
    public boolean isExistanceSupported() {
        return true;
    }
}
