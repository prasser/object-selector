/*
 * ObjectSelector - Object selection library for Java
 * Copyright (C) 2013 - 2016 Fabian Prasser
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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