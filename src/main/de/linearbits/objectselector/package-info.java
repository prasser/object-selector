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

/**
 * This package provides the public API for Object Selector.
 * <p>
 * <ul>
 * <li>The interface {@link IAccessor} can be implemented to enable selection of objects.</li>
 * <li>The interface {@link ICallback} can be implemented and passed to a {@link SelectorTokenizer}.</li>
 * <li>The class {@link Parser} parses expressions created with the builder.</li>
 * <li>The class {@link Selector}represents the actual selector.</li>
 * <li>The class {@link SelectorBuilder} implements a builder for selectors</li>
 * <li>The class {@link SelectorBuilderCallback} is a callback used by the builder when parsing query strings</li>
 * <li>The class {@link SelectorTokenizer} is a tokenizer for query strings</li>
 * </ul>
 * 
 * @author Fabian Prasser
 */
package de.linearbits.objectselector;

