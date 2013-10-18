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