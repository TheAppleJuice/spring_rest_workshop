package se.lexicon.spring_rest_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class StudentTest {

    Student testStudent;

    @BeforeEach
    public void setup(){
        testStudent = new Student();
        testStudent.setFirstName("Sebastian");
        testStudent.setLastName("Bocaciu");
        testStudent.setAge(42);
        testStudent.setGender("Male");
        testStudent.setEmail("test@test.se");
        testStudent.setPhoneNumber("12345678");
        testStudent.setRegisterDate(LocalDate.now());
        testStudent.setStatus(true);
    }

    @Test
    public void create_student(){
        Assertions.assertEquals("Sebastian", testStudent.getFirstName());
        Assertions.assertEquals("Bocaciu", testStudent.getLastName());
        Assertions.assertEquals(42, testStudent.getAge());
        Assertions.assertEquals("Male", testStudent.getGender());
        Assertions.assertEquals("test@test.se", testStudent.getEmail());
        Assertions.assertEquals("12345678", testStudent.getPhoneNumber());
        Assertions.assertEquals(LocalDate.parse("2021-04-20"), testStudent.getRegisterDate());
        Assertions.assertEquals(true, testStudent.isStatus());
    }

    @Test
    public void test_hashCode(){
        Student expected = new Student();
        expected.setFirstName("Sebastian");
        expected.setLastName("Bocaciu");
        expected.setAge(42);
        expected.setGender("Male");
        expected.setEmail("test@test.se");
        expected.setPhoneNumber("12345678");
        expected.setRegisterDate(LocalDate.now());
        expected.setStatus(true);

        Assertions.assertEquals(expected.hashCode(), testStudent.hashCode());
    }

}
