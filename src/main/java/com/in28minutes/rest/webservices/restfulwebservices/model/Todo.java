package com.in28minutes.rest.webservices.restfulwebservices.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;
}
