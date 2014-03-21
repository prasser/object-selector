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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date data type
 * @author Fabian Prasser
 */
public class DDate extends DataType<Date> {

    /** The formatter*/
    private final SimpleDateFormat formatter;

    /**
     * Create a date with a format string. Format strings must be valid formats
     * for <code>SimpleDateFormat</code>.
     * @param format
     * @see <a href="http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html">SimpleDateFormat</a>
     */
    protected DDate(String format){
        formatter = new SimpleDateFormat(format);
    }

    @Override
    public Date fromObject(Object object) {
        if (object instanceof Date) return (Date)object;
        return fromString(String.valueOf(object));
    }


    @Override
    public Date fromString(String value) {
        try {
            return formatter.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
