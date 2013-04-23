SORT JAVA MAP BY KEYS AND VALUES
--------------------------------

* "Key,Value" order in Java HashMap is not guaranteed.
* Sorting a Map type class by "keys" is given by TreeMap, just TreeMap.putAll(map) will return sorted map by keys.
* Sorting a Map by "values" needs one more step, we need to define a Comparator that compares values to each other.

