    package com.labs.java8;

    import com.labs.java8.model.Developer;

    import javax.swing.*;
    import java.math.BigDecimal;
    import java.util.*;

    import static java.util.stream.Collectors.toList;

    public class Main {

        public static void main(String[] args) {

            List<String> noNullNames = getDevelopers().stream().filter(e->Objects.nonNull(e.getName()))
                    .map(e->e.getName().toUpperCase()).collect(toList());

            getDevelopers().stream().filter(e->Objects.nonNull(e.getName()))
                    .map(e->e.getName().toUpperCase()).collect(toList()).forEach(System.out::println);

            //noNullNames.forEach(System.out::println);

            // write your code here
            System.out.println("Java 8");
            System.out.println("Before sort");

            List<Developer> developers = getDevelopers();
            for (Developer developer: developers){
                System.out.println(developer);
            }

            Collections.sort(developers, new Comparator<Developer>() {
                @Override
                public int compare(Developer o1, Developer o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
            // After sort

            System.out.println("After sort");

            for (Developer developer: developers){
                System.out.println(developer);
            }
            // sorting with lambda
            /*developers.sort(new Comparator<Developer>() {
                @Override
                public int compare(Developer o1, Developer o2) {
                    return o1.getAge() - o2.getAge();
                }
            });

            System.out.println("After sort");
            for (Developer developer: developers){
                System.out.println(developer);
            }*/

            System.out.println("#### - After sort by name and age");
            Comparator<Developer> devNameComparator = Comparator
                    .comparing(Developer::getName, Comparator
                            .nullsLast(String::compareToIgnoreCase))
                    .thenComparing(Developer::getAge, Comparator
                            .nullsFirst(Integer::compareTo));

            getDevelopers().stream().sorted(devNameComparator.reversed()).forEach(System.out::println);

            System.out.println("#### - After sort by age");
            getDevelopers().stream().sorted(Developer::compareAge).filter(d -> 20 < d.getAge()).forEach(System.out::println);

            /*
            mapIteration();

            listIteration();
            */
        }



        public static void mapIteration() {

            Map<String, Integer> items = new HashMap();

            items.put("A", 10);
            items.put("B", 20);
            items.put("C", 30);
            items.put("D", 40);
            items.put("E", 50);
            items.put("F", 60);
            items.put("G", 70);

            System.out.println("Iterate map");

            for (Map.Entry<String, Integer> entry: items.entrySet()) {
                System.out.printf("Item: %s - count: %s\r\n", entry.getKey(), entry.getValue());
            }

            System.out.println("Iterate map with lambdas");

            items.forEach((k,v)-> System.out.printf("Item: %s - count: %s\r\n", k,v));

            System.out.println("Iterate map with lambdas - annoymous function");

            items.forEach((k,v)->{
                System.out.printf("Item: %s - count: %s\r\n", k,v);
                if("E".equals(k)){
                    System.out.println("Hello E!");
                }
            });
        }

        public static void listIteration(){
            List<String> items = new ArrayList();

            items.add("A");
            items.add("B");
            items.add("C");
            items.add("D");
            items.add("E");
            items.add("F");
            items.add("G");
            items.add("H");
            items.add("Z");
            items.add("I");

            System.out.println("List iteration with lambdas");
            items.forEach(e-> System.out.println(e));

            System.out.println("#### subList and sort iteration with lambdas");
            items.subList(items.size()-3,items.size()).stream().sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            }).forEach(System.out::println);

            items.stream().sorted().forEach(System.out::println);

            System.out.println("List iteration with lambdas");
            items.stream().filter(e->e.equalsIgnoreCase("c")).forEach(System.out::println);

            List<String> developersName = getDevelopers().stream().map(Developer::getName).collect(toList());

            developersName.forEach(System.out::println);



        }

        public static List<Developer> getDevelopers(){

            List<Developer> developers = new ArrayList<>();

            developers.add(new Developer("etienne", new BigDecimal(7000), 37));
            developers.add(new Developer("manu", new BigDecimal(6000), 37));
            developers.add(new Developer("mathias", new BigDecimal(7900), 47));
            developers.add(new Developer("rachid", new BigDecimal(1800), 18));
            developers.add(new Developer("rachid", new BigDecimal(1500), 17));
            developers.add(new Developer(null, new BigDecimal(0000), 00));

            return developers;
        }
    }
