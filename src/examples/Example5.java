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
public class Example5 {

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
                "'field1'<='\\'\\\\a' and 'field2'<='20' and 'field3'<='20'")
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
