package com.soft1851.spring.ioc.entity;

import java.util.Map;

public class Teacher {
    private String name;
    private Map<String,String> other;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOther() {
        return other;
    }

    public void setOther(Map<String, String> other) {
        this.other = other;
    }

    public Teacher(String name, Map<String, String> other) {
        this.name = name;
        this.other = other;
    }

    public Teacher(){

    }



    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", other=" + other +
                '}';
    }
}
