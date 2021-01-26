package edu.isu.cs.cs2263.javafx;

import java.util.Objects;

public class Course {
    //instance variables
    private int number;
    private String subject;
    private String title;

    //constructor
    public Course(){}
    public Course(int number, String subject, String title){
        this.number=number;
        this.subject=subject;
        this.title=title;
    }
    //getter methods
    public int getNumber(){return number;} //returns number
    public String getSubject() {return subject;} //returns subject
    public String getTitle() {return title;}//returns title
    public String toString(){
        return getSubject()+" "+getNumber()+" "+getTitle();
    }//returns number subject and title in string

    //setter methods
    public void setNumber(int number){this.number=number;}
    public void setSubject(String subject){this.subject=subject;}
    public void setTitle(String title){this.title=title;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getNumber() == course.getNumber() && getSubject().equals(course.getSubject()) && getTitle().equals(course.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getSubject(), getTitle());
    }
}