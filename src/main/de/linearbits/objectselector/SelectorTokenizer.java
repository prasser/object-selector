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


/**
 * A Tokenizer for queries
 * 
 * @author Fabian Prasser
 */
public class SelectorTokenizer<T> {
	
	/** The callback*/
    private ICallback          callback = null;

    /**
     * Creates a new tokenizer 
     * @param selector
     */
    public SelectorTokenizer(ICallback callback) {
        this.callback = callback;
    }

    /**
     * Starts the tokenization process
     * @param query
     */
    public void tokenize(String query){

        int quote = -1;
        boolean first = true;
        char[] data = query.toCharArray();
        for (int i=0; i<data.length; i++){
            if (data[i]=='\\'){
                // Skip next
                i++; 
            } else if (data[i]=='\''){
                // Start quote
                if (quote == -1){
                    quote = i; 
                    // End quote
                } else {
                    if (first) {
                        callback.field(quote, i-quote+1);
                    } else {
                    	callback.value(quote, i-quote+1);
                    }
                    quote = -1;
                    first = !first;
                }
            } else if (quote == -1 && data[i]=='(') {
            	callback.begin(i);
            } else if (quote == -1 && data[i]==')') {
            	callback.end(i);
            } else if (quote == -1 && i<data.length-2 && data[i]=='a' && data[i+1]=='n' && data[i+2]=='d') {
            	callback.and(i, 3);
                i+=2;
            } else if (quote == -1 && i<data.length-1 && data[i]=='o' && data[i+1]=='r') {
            	callback.or(i, 2);
                i++;
            } else if ((quote == -1 && i<data.length-1 && data[i]=='<' && data[i+1]=='=')) {
            	callback.leq(i, 2);
                i++;
            } else if ((quote == -1 && i<data.length-1 && data[i]=='>' && data[i+1]=='=')) {
            	callback.geq(i, 2);
                i++;
            } else if (quote == -1 && data[i]=='=') {
            	callback.equals(i);
            } else if (quote == -1 && data[i]=='<') {
            	callback.less(i);
            } else if (quote == -1 && data[i]=='>') {
            	callback.greater(i);
            } else if (quote == -1 && (data[i]!=' ' && data[i]!='\t' && data[i]!='\n')){
            	callback.invalid(i);
            }

            if (i>=data.length) break;
        }
    }

}
