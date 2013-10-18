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

import java.util.Date;

import de.linearbits.objectselector.IAccessor;
import de.linearbits.objectselector.datatypes.DataType;

/**
 * Abstract base class for unary operators that check actual data items
 * @author Fabian Prasser
 */
public abstract class UnaryOperator<T> extends AbstractOperator<T>{

    /** The context*/
    protected final String context;

    /** The data type*/
    private final DataType<?> type;

    /** For conversion to string*/
    private final String label;

    /**
     * Constructor
     * @param context
     */
    public UnaryOperator(IAccessor<T> accessor, String context, String label) {
        super(accessor, 1);

        if (context == null){
            throw new IllegalArgumentException("No context specified");
        }

        this.context = context;
        this.label = label;

        if (accessor.isDataTypesSupported()) {
            this.type = accessor.getType(context);
        } else {
            this.type = null;
        }
    }

    /**
     * Returns the data item as a boolean
     * @param element
     * @return
     */
    public Boolean getBoolean(T element) {
        if (type != null && type != DataType.BOOLEAN) {
            throw new RuntimeException("Type mismatch for field '"+context+"'. Cannot convert "+type.getClass().getSimpleName()+" to Boolean");
        } else if (type != null) {
            return (Boolean)type.fromObject(accessor.getValue(element, context));
        } else {
            return Boolean.valueOf(String.valueOf(accessor.getValue(element, context)));
        }
    }

    /**
     * Returns the context
     * @return
     */
    public String getContext(){
        return context;
    }

    /**
     * Returns the data item as a date
     * @param element
     * @return
     */
    public Date getDate(T element) {
        if (type != null && type != DataType.DATE) {
            throw new RuntimeException("Type mismatch for field '"+context+"'. Cannot convert "+type.getClass().getSimpleName()+" to Date");
        } else if (type != null) {
            return (Date)type.fromObject(accessor.getValue(element, context));
        } else {
            return DataType.DATE.fromString(String.valueOf(accessor.getValue(element, context)));
        }
    }

    /**
     * Returns the data item as a double
     * @param element
     * @return
     */
    public double getDouble(T element) {
        if (type != null && type != DataType.NUMERIC) {
            throw new RuntimeException("Type mismatch for field '"+context+"'. Cannot convert "+type.getClass().getSimpleName()+" to Numeric");
        } else if (type != null) {
            return (Double)type.fromObject(accessor.getValue(element, context));
        } else {
            return Double.valueOf(String.valueOf(accessor.getValue(element, context)));
        }
    }

    /**
     * Returns the data item as a string
     * @param element
     * @return
     */
    public String getString(T element) {
        if (type != null && type != DataType.STRING) {
            throw new RuntimeException("Type mismatch for field '"+context+"'. Cannot convert "+type.getClass().getSimpleName()+" to String");
        } else if (type != null) {
            return (String)type.fromObject(accessor.getValue(element, context));
        } else {
            return String.valueOf(accessor.getValue(element, context));
        }
    }

    @Override
    public void toString(StringBuffer buffer, String prefix) {
        buffer.append(prefix).append(context).append(label);	
    }
}