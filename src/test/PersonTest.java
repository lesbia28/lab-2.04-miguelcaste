package test;

import model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1;
    Person p2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Person("Miguel Castelló",30,"Developer");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void checkAge() {
        assertTrue(p1.checkAge(20));

        assertEquals(30,p1.getAge());
        assertThrows(IllegalArgumentException.class,() ->{p1.setAge(-1);});
        assertEquals(30,p1.getAge());
        p1.setAge(20);
        assertEquals(20,p1.getAge());
    }

    @Test
    void checkName() {
        assertTrue(p1.checkName("Miguel Castelló"));

        assertEquals("Miguel Castelló",p1.getName());
        assertThrows(IllegalArgumentException.class,() ->{p1.setName("Miguel Castelló Sosa");});
        assertEquals("Miguel Castelló",p1.getName());
        p1.setName("Libertad Hernández");
        assertEquals("Libertad Hernández",p1.getName());
    }

    @Test
    void testClone() {
        p2=p1.clone();
        assertEquals(p1,p2);
        assertEquals(p1.getId()+1,p2.getId());
        assertEquals(p1.getName(),p2.getName());
        assertEquals(p1.getAge(),p2.getAge());
        assertEquals(p1.getOccupation(),p2.getOccupation());

    }

    @Test
    void personToAFile() {
        assertTrue(p1.PersonToAFile(p1));
    }
}