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

import java.util.Random;

/**
 * A class representing elements that can be selected
 * 
 * @author Fabian Prasser
 */

public class Element {

	/**
     * Creates a random element
     * @return
     */
    public static Element getRandomElement(Random random) {
        Element e = new Element();
        e.bool = random.nextBoolean();
        e.integer = random.nextInt(100);
        e.numeric = random.nextDouble() * 100d;
        return e;
    }
	/**
	 * Creates a random entry
	 * @return
	 */
	public static int[] getRandomIntArray(Random random) {
	    int[] result = new int[3];
		result[0] = random.nextInt(100);
		result[1] = random.nextInt(100);
		result[2] = random.nextInt(100);
		return result;
	}
	public boolean bool;
	

    public int integer;
    

	public double numeric;
}