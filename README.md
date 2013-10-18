ObjectSelector - Object selection library
====

Introduction
------
ObjectSelector is a small, general purpose Java library for selecting objects from 
sets of objects. To this end, it enables users to specify simple selection predicates. It 
supports multiple features, including: 

1. Converting between different data types

2. Transparent handling of sets of objects via reflection

3. Transparent handling of sets of arrays of different types

4. Creating selection predicates using the builder pattern 

5. Creating selection predicates by parsing query strings

The library is extensible and is also suitable for building user interfaces with
syntax highlighting. It has no dependencies.

Examples
------
```Java
public class Element {
	public boolean bool;
	public int integer;
	public double numeric;
}
```

```Java
Selector<Element> selector 
		= new SelectorBuilder<Element>(new ObjectAccessor<Element>(Element.class))
			                .begin()
			                    .field("bool").equals(true)
			                    .and()
			                    .field("integer").geq(50)
			                .end()
			                .or()
			                .field("numeric").leq(30d)
			                .build();
```

```Java
Selector<Element> selector 
		= new SelectorBuilder<Element>(new ObjectAccessor<Element>(Element.class),
                             "('bool'='true' and 'integer'>='50') or 'numeric'<='30'")
                             .build();
```

```Java
for (Element element : list){
	if (selector.isSelected(element)) {
          // It's selected
    }
}
```

![Image](https://raw.github.com/prasser/object-selector/master/doc/example.png)

Documentation
------
More examples are available in the [repository](https://github.com/prasser/object-selector/tree/master/src/examples).

Javadoc documentation for the whole repository can be found
[here](https://rawgithub.com/prasser/object-selector/master/doc/index.html).

Downloads
------
[Library (Version 0.1)](https://raw.github.com/prasser/object-selector/master/jars/objectselector-0.1-lib.jar)

[API documentation (Version 0.1)](https://raw.github.com/prasser/object-selector/master/jars/objectselector-0.1-api-doc.jar)

[Source (Version 0.1)](https://raw.github.com/prasser/object-selector/master/jars/objectselector-0.1-src.jar)

[Developer documentation (Version 0.1)](https://raw.github.com/prasser/object-selector/master/jars/objectselector-0.1-dev-doc.jar)