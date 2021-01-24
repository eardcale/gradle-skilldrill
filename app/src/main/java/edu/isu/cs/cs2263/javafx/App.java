/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs.cs2263.javafx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Course View");
        //Student List
        Label studentLabel = new Label("Students");
        ObservableList<Student> students = FXCollections.observableArrayList(new Student("Caleb", "Eardley", new ArrayList<Course>()));
        ListView<Student> studentList = new ListView<Student>(students);
        VBox studentVbox = new VBox(studentLabel,studentList);

        //Course List
        Label courseLabel = new Label("Courses");
        ObservableList<Course> courses = FXCollections.observableArrayList(students.get(0).getCourses());
        ListView<Course> courseList= new ListView<Course>(courses);
        VBox courseVbox = new VBox(courseLabel, courseList);

        //button
        Button button = new Button("Load Data");
        button.setOnAction(value->{

        });

        //Label
        Label isTaking = new Label("is taking");
        isTaking.setPadding(new Insets(150,10,10,10));

        //Structure
        HBox hbox = new HBox(studentVbox,isTaking,courseVbox);
        VBox main = new VBox(hbox, button);
        main.setAlignment(Pos.CENTER_RIGHT);



        Scene scene = new Scene(main, 600, 300);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
