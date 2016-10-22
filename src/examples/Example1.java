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
import java.util.Random;

import de.linearbits.objectselector.Selector;
import de.linearbits.objectselector.SelectorBuilder;

/**
 * Example with custom accessor
 * 
 * @author Fabian Prasser
 */
public class Example1 {

    /**
     * Main entry
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
        Selector<Element> selector = new SelectorBuilder<Element>(new ElementAccessor())
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
        for (int i=0; i<1000; i++) {
            final Element entry = entries.get(i);
            if (selector.isSelected(entry)) {
                System.out.println("Is selected: "+i);
            }
        }

        // Create a selector by parsing a query string
        selector = new SelectorBuilder<Element>(new ElementAccessor(), 
                "('bool'='true' and 'integer'>='50') or 'numeric'<='30'")
                .build();

        // Print selector
        System.out.println(selector.toString());

        // Print, which elements are selected
        for (int i=0; i<1000; i++) {
            final Element entry = entries.get(i);
            if (selector.isSelected(entry)) {
                System.out.println("Is selected: "+i);
            }
        }
    }
}
