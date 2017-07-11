package com.labs.java8.model;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created by rachid on 08/07/17.
 */
public class Developer {

    private String name;
    private BigDecimal salary;
    private int age;

public Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    private static Comparator<String> nullSafeStringComparator = Comparator
            .nullsFirst(String::compareToIgnoreCase);

    private static Comparator<Integer> nullSafeIntegerComparator = Comparator
            .nullsFirst(Integer::compareTo);

    private static Comparator<Developer> developerComparator = Comparator
            .comparing(Developer::getName, nullSafeStringComparator)
            .thenComparing(Developer::getAge, nullSafeIntegerComparator);

    private static Comparator<Developer> developerAgeComparator = Comparator.comparing(Developer::getAge, nullSafeIntegerComparator);

    public int compareTo(Developer that) {
        return developerComparator.compare(this, that);
    }

    public int compareAge(Developer that) {
        return developerAgeComparator.compare(this, that);
    }
}
