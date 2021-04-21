package se.lexicon.spring_rest_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.spring_rest_workshop.entity.Student;
import se.lexicon.spring_rest_workshop.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(/api/v1/student)
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(studentList::add);
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Student> getById (@PathVariable("id") String id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(studentOptional.get());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        Optional <Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PostMapping("/")
    public ResponseEntity<Student> save (@RequestBody Student student){
        Student result = studentRepository.save(student);
        if (result.isStatus()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student student){
        Student result = studentRepository.save(student);
        if (result.isStatus()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
