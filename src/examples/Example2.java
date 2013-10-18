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
import java.util.Random;

import de.linearbits.objectselector.Selector;
import de.linearbits.objectselector.SelectorBuilder;
import de.linearbits.objectselector.util.ObjectAccessor;

/**
 * Example with custom standard object accessor
 * 
 * @author Fabian Prasser
 */
public class Example2 {

    /**
     * Main entry
     * 
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {

        // Create a set of 1000 elements
        Random random = new Random();
        List<Element> entries = new ArrayList<Element>();
        for (int i=0; i<1000; i++){
            entries.add(Element.getRandomElement(random));
        }

        // Create a selector with the builder pattern
        Selector<Element> selector = new SelectorBuilder<Element>(new ObjectAccessor<Element>(Element.class))
                .begin()
                .field("bool").equals(true)
                .and()
                .field("integer").geq(50)
                .end()
                .or()
                .field("numeric").leq(30d)
                .build();

        // Print selector
        System.out.println(selector.toString());

        // Print, which elements are selected
        for (int i = 0; i < 1000; i++) {

            // Check
            if (selector.isSelected(entries.get(i))) {
                System.out.println("Is selected: " + i);
            }
        }

        // Create a selector by parsing a query string
        selector = new SelectorBuilder<Element>(new ObjectAccessor<Element>(Element.class),
                "('bool'='true' and 'integer'>='50') or 'numeric'<='30'")
                .build();

        // Print selector
        System.out.println(selector.toString());

        // Print, which elements are selected
        for (int i = 0; i < 1000; i++) {

            // Check
            if (selector.isSelected(entries.get(i))) {
                System.out.println("Is selected: " + i);
            }
        }
    }
}
