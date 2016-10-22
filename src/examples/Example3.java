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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import de.linearbits.objectselector.Selector;
import de.linearbits.objectselector.SelectorBuilder;
import de.linearbits.objectselector.util.ArrayAccessor;

/**
 * Example with array accessor
 * 
 * @author Fabian Prasser
 */
public class Example3 {

    /**
     * Main entry
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {

        // Create a set of 1000 elements
        List<Integer[]> entries = new ArrayList<Integer[]>();
        for (int i=0; i<1000; i++){
            entries.add(getRandomEntry());
        }

        // Create header
        ArrayAccessor<Integer> accessor = new ArrayAccessor<Integer>(new String[]{"field1", "field2", "field3"});

        // Create a selector with the builder pattern
        Selector<Integer[]> selector = new SelectorBuilder<Integer[]>(accessor).field("field1").leq(20)
                .and()
                .field("field2").leq(20)
                .and()
                .field("field3").leq(20)
                .build();

        // Print selector
        System.out.println(selector.toString());

        // Print, which elements are selected
        for (int i=0; i<1000; i++) {
            if (selector.isSelected(entries.get(i))) {
                System.out.println("Is selected: "+i);
            }
        }

        // Create a selector by parsing a query string
        selector = new SelectorBuilder<Integer[]>(accessor, 
                "'field1'<='20' and 'field2'<='20' and 'field3'<='20'")
                .build();

        // Print selector
        System.out.println(selector.toString());

        // Print, which elements are selected
        for (int i=0; i<1000; i++) {
            if (selector.isSelected(entries.get(i))) {
                System.out.println("Is selected: "+i);
            }
        }
    }

    /**
     * Creates a random entry
     * @return
     */
    private static Integer[] getRandomEntry() {
        Integer[] result = new Integer[3];
        result[0] = (int)(Math.random() * 100d);
        result[1] = (int)(Math.random() * 100d);
        result[2] = (int)(Math.random() * 100d);
        return result;
    }
}
