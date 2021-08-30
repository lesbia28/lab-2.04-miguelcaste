package model;

//2. Create a PersonsList class that holds a List of Person objects.
//        Create a findByName method. The method should take in a String name and return the Person
//        with a name that matches exactly. The Person name property and the method name parameter
//        should be formatted as "firstName lastName".
//        Throw an exception if the name parameter is not properly formatted. Include all tests.

import java.util.ArrayList;

public class PersonsList {
    private ArrayList<Person> people;

    public PersonsList() {
        people=new ArrayList<>();
    }

    public void add(Person person){
        people.add(person);
    }

    public Person findByName(String name){
        Person p1=new Person();
        if(p1.checkName(name)){
            for (Person p:this.people
                 ) {
                if(name==p.getName()){
                    return p;
                }
            }
        }
        return null;
    }

}
