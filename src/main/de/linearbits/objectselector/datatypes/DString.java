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

package de.linearbits.objectselector.datatypes;

/**
 * String data type
 * @author Fabian Prasser
 */
public class DString extends DataType<String>{

    /**
     * Creates a new string data type
     */
    protected DString(){
        // Empty by design
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof DString;
    }


    @Override
    public String fromObject(Object object) {
        if (object instanceof String) return (String)object;
        return String.valueOf(object);
    }

    @Override
    public String fromString(String value) {
        return value;
    }

    @Override
    public int hashCode() {
        return DString.class.hashCode();
    }
}
