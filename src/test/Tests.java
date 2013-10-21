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

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;

import de.linearbits.objectselector.Selector;
import de.linearbits.objectselector.SelectorBuilder;
import de.linearbits.objectselector.util.IntArrayAccessor;
import de.linearbits.objectselector.util.ObjectAccessor;

public class Tests extends TestCase {

    @Test
    public void test1() throws IllegalArgumentException, IOException, ParseException {

        // Create a set of 1000 elements
    	Random random = new Random(0xDEADBEEF);
    	List<Element> elements = new ArrayList<Element>();
        for (int i=0; i<1000; i++){
            elements.add(Element.getRandomElement(random));
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

        // Select
        List<Integer> list1 = select(selector, elements);

        // Create a selector by parsing a query string
        selector = new SelectorBuilder<Element>(new ElementAccessor(), 
                                                "('bool'='true' and 'integer'>='50') or 'numeric'<='30'")
                                                .build();
    	
        // Select
        List<Integer> list2 = select(selector, elements);
        
        // Test
        assertTrue(list1.equals(list2));
    }

    @Test
    public void test2() throws IllegalArgumentException, IOException, ParseException {

        // Create a set of 1000 elements
    	Random random = new Random(0xDEADBEEF);
        List<Element> elements = new ArrayList<Element>();
        for (int i=0; i<1000; i++){
            elements.add(Element.getRandomElement(random));
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
    	

        // Select
        List<Integer> list1 = select(selector, elements);

        // Create a selector by parsing a query string
        selector = new SelectorBuilder<Element>(new ObjectAccessor<Element>(Element.class),
                                              "('bool'='true' and 'integer'>='50') or 'numeric'<='30'")
                                              .build();
    	
        // Select
        List<Integer> list2 = select(selector, elements);
        
        // Test
        assertTrue(list1.equals(list2));
    }

    @Test
    public void test3() throws IllegalArgumentException, IOException, ParseException {

		// Create a set of 1000 elements
		Random random = new Random(0xDEADBEEF);
		List<int[]> elements = new ArrayList<int[]>();
		for (int i=0; i<1000; i++){
			elements.add(Element.getRandomIntArray(random));
		}
		
		// Create header
		IntArrayAccessor accessor = new IntArrayAccessor(new String[]{"field1", "field2", "field3"});

		// Create a selector with the builder pattern
		Selector<int[]> selector = new SelectorBuilder<int[]>(accessor).field("field1").leq(20)
                                                                       .and()
                                                                       .field("field2").leq(20)
                                                                       .and()
                                                                       .field("field3").leq(20)
                                                                       .build();

        // Select
        List<Integer> list1 = select(selector, elements);

		// Create a selector by parsing a query string
		selector = new SelectorBuilder<int[]>(accessor, 
		                                      "'field1'<='20' and 'field2'<='20' and 'field3'<='20'")
		                                      .build();

        // Select
        List<Integer> list2 = select(selector, elements);
        
        // Test
        assertTrue(list1.equals(list2));
    }
    
    /**
     * Selection process
     * @param selector
     * @param list
     * @return
     */
    private<T> List<Integer> select(Selector<T> selector, List<T> list){
    	List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<list.size(); i++) {
            final T entry = list.get(i);
            if (selector.isSelected(entry)) {
            	result.add(i);
            }
        }
        return result;
    }
}
