package se.lexicon.spring_rest_workshop.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue (generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    @Column (nullable = false, unique = true)
    private String email;
    private String phoneNumber;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDate registerDate;
    private boolean status;
}
