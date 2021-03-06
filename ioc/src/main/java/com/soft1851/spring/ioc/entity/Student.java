package com.soft1851.spring.ioc.entity;

import java.util.List;
import java.util.Set;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Student
 * @Description TODO
 * @date 2020-03-17 12:55
 **/
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", subjects=" + subjects +
                '}';
    }

    private Integer id;
    private String name;
    private List<String> hobbies;
    private Set<String> subjects;
    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Student() {
    }

    public Student(Integer id, String name, List<String> hobbies ,Set<String> subjects) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.subjects=subjects;
    }
}
