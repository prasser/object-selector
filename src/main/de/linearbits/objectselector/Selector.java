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

package de.linearbits.objectselector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.linearbits.objectselector.ops.AbstractOperator;

/**
 * The object selector
 * @author Fabian Prasser
 *
 * @param <T>
 */
public class Selector<T> {

    /** Root op */
    private AbstractOperator<T> root = null;

    /**
     * Creates a new selector
     * 
     * @param root
     * @param element
     * @param schema
     */
    protected Selector(AbstractOperator<T> root) {
        this.root = root;
    }

    /**
     * Call this for each element you want to check
     * 
     * @param element
     * @return
     */
    public boolean isSelected(T element) {
        return root.eval(element);
    }

    /**
     * Removes all selected elements. Returns a new collection.
     * 
     * @param input
     * @return
     */
    public Collection<T> remove(Collection<T> input) {
        List<T> result = new ArrayList<T>();
        for (T t : input){
            if (!isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Removes all selected elements. Returns a new list.
     * 
     * @param input
     * @return
     */
    public List<T> remove(List<T> input) {
        List<T> result = new ArrayList<T>();
        for (T t : input){
            if (!isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Removes all selected elements. Returns a new set.
     * 
     * @param input
     * @return
     */
    public Set<T> remove(Set<T> input) {
        Set<T> result = new HashSet<T>();
        for (T t : input){
            if (!isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Removes all selected elements. Returns a new array.
     * 
     * @param input
     * @return
     */
    public T[] remove(T[] input) {
        List<T> list = remove(Arrays.asList(input));
        T[] result = input.clone();
        for (int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return Arrays.copyOf(result, list.size());
    }

    /**
     * Returns the subset of all selected elements. Returns a new collection.
     * 
     * @param input
     * @return
     */
    public Collection<T> retain(Collection<T> input) {
        List<T> result = new ArrayList<T>();
        for (T t : input){
            if (isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Returns the subset of all selected elements. Returns a new list.
     * 
     * @param input
     * @return
     */
    public List<T> retain(List<T> input) {
        List<T> result = new ArrayList<T>();
        for (T t : input){
            if (isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Returns the subset of all selected elements. Returns a new set.
     * 
     * @param input
     * @return
     */
    public Set<T> retain(Set<T> input) {
        Set<T> result = new HashSet<T>();
        for (T t : input){
            if (isSelected(t)) result.add(t);
        }
        return result;
    }

    /**
     * Returns the subset of all selected elements. Returns a new array.
     * 
     * @param input
     * @return
     */
    public T[] retain(T[] input) {
        List<T> list = retain(Arrays.asList(input));
        T[] result = input.clone();
        for (int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return Arrays.copyOf(result, list.size());
    }
    
    /**
     * Returns a string representation of the operator tree
     */
    public String toString() {
    	StringBuffer b = new StringBuffer();
    	root.toString(b, "");
    	return b.toString();
    }
}
