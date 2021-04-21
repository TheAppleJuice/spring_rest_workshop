package se.lexicon.spring_rest_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.spring_rest_workshop.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository <Student, String> {

    Optional<Student> findStudentByEmailIgnoreCase(String email);

    List<Student> findStudentByFirstNameIgnoreCase(String firstName);
    List<Student> findStudentByLastNameIgnoreCase(String lastName);
    List<Student> findStudentByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);


}
