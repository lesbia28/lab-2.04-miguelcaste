package test;

import model.Person;
import model.PersonsList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    Person p1;
    Person p2;
    Person p3;
    PersonsList personsList;

    @BeforeEach
    void setUp() {
        p1=new Person("Victor Cardozo",25,"professor");
        p2= new Person("Gema Segarra",23, "student");
        p3=new Person("Dinis Oliveira", 30, "Manager");
        personsList=new PersonsList();
        personsList.add(p1);
        personsList.add(p2);
        //personsList.add(p3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        personsList.add(p3);
        assertEquals(p3.getName(),(personsList.findByName(p3.getName())).getName());
    }

    @Test
    void findByName() {
        assertEquals(p1.getName(),(personsList.findByName(p1.getName())).getName());
        assertThrows(IllegalArgumentException.class,() ->{personsList.findByName("Miguel Castelló Sosa");});
    }
}