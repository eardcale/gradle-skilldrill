package edu.isu.cs.cs2263.javafx;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;


public class IOManager {


    public static void main(String args[]){

        ArrayList<Course> calebList = Lists.newArrayList(
                new Course(101, "CS", "Intro to computer science"),
                new Course(203,"ENGL","Writing"),
                new Course(321, "MATH", "Calculus"),
                new Course(253,"COMM","Speech"),
                new Course(313, "ART", "Sculpting"),
                new Course(294,"CS","Data Structures")
        );
        Student Caleb = new Student("Caleb", "Eardley",calebList);

        ArrayList<Course> karenList = Lists.newArrayList(
                new Course(223, "MATH", "Trigonometry"),
                new Course(325,"BS","Intro to Business"),
                new Course(423, "ART", "Digital Art"),
                new Course(112,"ENG","French Literature"),
                new Course(116, "HIST", "US History"),
                new Course(202,"ANTH","Ancient Egyptian Culture")
        );
        Student Karen = new Student("Karen", "Hoag",karenList);

        ArrayList<Course> octavioList = Lists.newArrayList(
                new Course(116, "HIST", "US History"),
                new Course(325,"BS","Intro to Business"),
                new Course(112,"ENG","French Literature"),
                new Course(313, "ART", "Sculpting"),
                new Course(202,"ANTH","Ancient Egyptian Culture"),
                new Course(101,"ENGL","Writing")
        );
        Student Octavio = new Student("Octavio", "Mancilla",octavioList);

        ArrayList<Course> kimList = Lists.newArrayList(
                new Course(313, "ART", "Sculpting"),
                new Course(321, "MATH", "Calculus"),
                new Course(101, "CS", "Intro to computer science"),
                new Course(223, "MATH", "Trigonometry"),
                new Course(294,"CS","Data Structures"),
                new Course(101,"ENGL","Writing")
        );
        Student Kim = new Student("Kim", "Kay",kimList);

        List<Student> list2 = Lists.newArrayList(Caleb,Karen,Octavio,Kim);
        writeData(list2);
        System.out.println(readData().get(0).getCourses().get(1));
    }
    public static void writeData(List<Student> students){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(students);
        try{
            Files.writeString(Paths.get("./students.json"),json);

        }
        catch(IOException ex) {ex.printStackTrace(); }
    }
    public static List<Student> readData(){
        String json = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            json =Files.readString(Paths.get("./students.json"));

        }catch(IOException ex){ex.printStackTrace();}
        Type listType = new TypeToken<ArrayList<Student>>(){}.getType();
        List<Student> students = gson.fromJson(json, listType);
        return students;
    }
}
