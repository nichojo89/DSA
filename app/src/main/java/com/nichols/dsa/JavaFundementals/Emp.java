package com.nichols.dsa.JavaFundementals;

import java.util.Comparator;

public class Emp implements Comparable<Emp> {
    public Integer id;
    public String name;

    @Override
    public int compareTo(Emp emp) {
        return this.id  - emp.id;
    }

    public static Comparator<Emp> NameCompare = new Comparator<Emp>() {
        @Override
        public int compare(Emp emp, Emp t1) {
            return emp.name.compareTo(t1.name);
        }
    };
}
