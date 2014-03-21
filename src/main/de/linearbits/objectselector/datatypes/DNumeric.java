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

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Double data type
 * @author Fabian Prasser
 */
public class DNumeric extends DataType<Double>{

	/** Format, if any*/
	private String string;
	/** Format, if any*/
	private DecimalFormat format;
	
    /**
     * Creates a new numeric data type
     */
    protected DNumeric(){
    	this.string = null;
    	this.format = null;
    }
    
    /**
     * Create a numeric with a format string. Format strings must be valid formats
     * for <code>DecimalFormat</code>.
     * @param format
     * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html">DecimalFormat</a>
     */
    protected DNumeric(String format){
    	if (format == null){
    		this.string = null;
    		this.format = null;	
    	} else {
    		this.string = format;
    		this.format = new DecimalFormat(string);
    	}
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
        try {
			return format == null ? Double.valueOf(value) : format.parse(value).doubleValue();
		} catch (NumberFormatException | ParseException e) {
			throw new RuntimeException(e);
		}
    }
}
