package com.caitxj.entity;

/**
 * Created by caitxj on 4/10/2017.
 */
public class User {

    private int id;

    private String name;

    public  int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String intro(){

        return id+":"+name+":"+age;
    }
}
