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

import de.linearbits.objectselector.IAccessor;
import de.linearbits.objectselector.datatypes.DataType;

/**
 * An accessor for the Element class
 * 
 * @author Fabian Prasser
 */
public class ElementAccessor implements IAccessor<Element> {

    @Override
    public boolean exists(String context) {
        return context.equals("bool") 
                || context.equals("integer")
                || context.equals("numeric");
    }

    @Override
    public DataType<?> getType(String context) {
        if (context.equals("bool")) return DataType.BOOLEAN;
        else if (context.equals("integer")) return DataType.NUMERIC;
        else if (context.equals("numeric")) return DataType.NUMERIC;
        else throw new RuntimeException("Invalid field!");
    }

    @Override
    public Object getValue(Element object, String context) {
        if (context.equals("bool")) return object.bool;
        if (context.equals("numeric")) return object.numeric;
        else if (context.equals("integer")) return object.integer;
        else throw new RuntimeException("Invalid field!");
    }

    @Override
    public boolean isDataTypesSupported() {
        return true;
    }

    @Override
    public boolean isExistanceSupported() {
        return true;
    }
};