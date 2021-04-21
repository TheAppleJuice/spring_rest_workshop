package se.lexicon.spring_rest_workshop.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.spring_rest_workshop.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentRepositoryTest {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    Student testStudent;


    @BeforeEach
    public void setStudent() {
        testStudent = new Student();
        testStudent.setFirstName("Sebastian");
        testStudent.setLastName("Bocaciu");
        testStudent.setAge(42);
        testStudent.setGender("Male");
        testStudent.setEmail("test@test.se");
        testStudent.setPhoneNumber("12345678");
        testStudent.setRegisterDate(LocalDate.now());
        testStudent.setStatus(true);

        studentRepository.save(testStudent);
    }

    @Test
    public void test_findAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        Assertions.assertEquals("Sebastian", studentList.get(0).getFirstName());

    }

    @Test
    public void test_find_by_id() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        String expectedId = studentList.get(0).getId();
        Optional<Student> actualId = studentRepository.findById(expectedId);

        Assertions.assertEquals("Sebastian", actualId.get().getFirstName());

    }

    @Test
    public void test_save_student() {

    }

    @Test
    public void test_delete_student(){
        List <Student> actualResult = new ArrayList<>();
        List<Student> emptyArray = new ArrayList<>();
        studentRepository.delete(testStudent);
        studentRepository.findAll().iterator().forEachRemaining(actualResult::add);
        Assertions.assertEquals(emptyArray, actualResult);

    }

    @Test
    public void test_find_by_firstName(){
        Assertions.assertEquals(42, studentRepository.findStudentByFirstNameIgnoreCase("sebastian").get(0).getAge());

    }

    @Test
    public void test_find_by_lastName(){
        Assertions.assertEquals(42, studentRepository.findStudentByLastNameIgnoreCase("bocaciu").get(0).getAge());
    }
    @Test
    public void test_find_by_fistName_lastName(){
        Assertions.assertEquals(42, studentRepository.findStudentByFirstNameAndLastNameIgnoreCase("sebastian", "bocaciu").get(0).getAge());

    }

    @Test
    public void test_find_by_email(){
        Assertions.assertEquals(42, studentRepository.findStudentByEmailIgnoreCase("test@test.se").get().getAge());
    }

}
