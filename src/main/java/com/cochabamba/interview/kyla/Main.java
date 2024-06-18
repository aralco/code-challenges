package com.cochabamba.interview.kyla;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Person {//implements Comparable<Person>{
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

//        public int compareTo(Person person)  {
//            int personCompare = name.compareTo(person.name);
//            if(personCompare!=0)  {
//                return personCompare;
//            }
//            return Integer.compare(id, person.id);
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"),
            new Person(1, "Harry"),
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    /*
        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

Please write code which will return unique sorted structure by name and id with number of record in group with the same name
        **************************************************

        5 - Amelia (1)
        6 - Amelia (2)
        7 - Amelia (3)
        8 - Amelia (4)
        3 - Emily (1)
        0 - Harry (1)
        1 - Harry (2)
        2 - Harry (3)
        4 - Jack (1)
     */
    public static void main(String[] args) {
        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        List<Person> unsortedPersons = Arrays.asList(RAW_DATA);
        //Eliminating duplicates
        Set<Person> personsSet = new HashSet<>(unsortedPersons);
        //sorting persons by name,id
        List<Person> sortedPersons = new ArrayList<>(personsSet);
        //using comparator approach 2
//        Comparator<Person> personComparator = (Comparator.comparing(Person::getName)
//                .thenComparing(Person::getId));
//        sortedPersons.sort(personComparator);
        //using comparable approach 1
        //Collections.sort(sortedPersons);
//        for (Person person : sortedPersons) {
//            System.out.println(person.id + " - " + person.name);
//        }

        //using streams and sorted() method
        List<Person> sortedPersons2 = sortedPersons.stream()
                .sorted(Comparator
                        .comparing(Person::getName)
                        .thenComparing(Person::getId))
                .collect(Collectors.toList());

        for (Person person : sortedPersons2) {
            System.out.println(person.id + " - " + person.name);
        }
    }
}
