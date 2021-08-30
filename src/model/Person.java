package model;

//1. Create a Person class that has properties id, name, age, and occupation.
//        Throw an error if someone tries to set age to less than 0. Include all tests.

//3. Create a clone method. The clone method should take in a Person object and
//        return a nearly identical object with new id.
//        Override the equals method in the Person class to test for equivalency excluding id. Include all tests.


//4. Create a method that takes a Person object as a parameter and used
//        the toString method to write the Person information to a file. Handle any errors as necessary.


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Person {
    private static int autonumeric=0;
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person() {
    }

    public Person(String name, int age, String occupation) {
        this.id = autonumeric++;
        if(checkName(name)){
            this.name = name;
        }

        if(checkAge(age)){
            this.age = age;
        }
        this.occupation = occupation;
    }


    @Override
    public Person clone(){
        return new Person(this.name,this.age,this.occupation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

    public boolean PersonToAFile(Person p){
        String fileName = "Person.txt";
        File file=new File(fileName);
        FileWriter fileWriter;
        try {
            fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(p.toString());

            bufferedWriter.close();
            System.out.println("File writing completed.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There was a problem writing the file.");
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public boolean checkAge(int age){
        if (age<0){
            throw new IllegalArgumentException("Age cannot be less than zero.");
        }else{
            return true;
        }

    }

    public boolean checkName(String name){
        String[] names=name.split(" "); //Validate a space in the middle
        if(names.length!=2){
            throw new IllegalArgumentException("Name must be formatted as \"firstName lastName\".");
        }
        else{
            return true;
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(checkName(name)){
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(checkAge(age)){
            this.age = age;
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
