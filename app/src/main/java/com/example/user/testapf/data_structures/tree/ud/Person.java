package com.example.user.testapf.data_structures.tree.ud;

import android.support.annotation.NonNull;

//example of using Comparable for comparation for a tree for example
public class Person implements Comparable<Person>
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NonNull Person person)
    {
        return name.compareTo(person.name);
//        return age - person.getAge();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return name + "-" + age;
    }
}
