package com.hmkcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hmkcode.vo.Person;

public class ListApp 
{

    public static void main( String[] args )
    {

        // ( 1 ) List

        // A. Initiate
        List<Person> arrayList = new ArrayList<Person>();
        List<Person> linkedList = new LinkedList<Person>();

        // B. Populate
        for(Person person:getPersons()){
        	arrayList.add(person);
        	linkedList.add(person);
        }

        // --> print
        System.out.println("--------- Print All -------------");

        System.out.println("ArrayList: "+arrayList);
        System.out.println("LinkedList: "+linkedList);

        // C. Iterate
        System.out.println("--------- Print Iterate by index -------------");

        for(int i = 0; i < linkedList.size(); i++){
        	System.out.println("LinkedList[ "+i+" ]"+linkedList.get(i));        	
        }

        System.out.println("--------- Print Iterate by for each -------------");

        //this is an efficient way to iterate
        for(Person person:linkedList){
        	System.out.println("LinkedList: "+person);
        }

        // D. Sort
        Collections.sort(linkedList);

        // --> print
        System.out.println("--------- Print Sorted List -------------");

        System.out.println("Sorted LinkedList: "+linkedList);
    }

    private static Person[] getPersons(){
    	Person[] persons = new Person[5];

    	persons[0] = new Person("Brit", 29);
    	persons[1] = new Person("John", 32);
    	persons[2] = new Person("Jack", 27);
    	persons[3] = new Person("Jenifer", 24);
    	persons[4] = new Person("Brit", 37);

    	return persons;
    }
}