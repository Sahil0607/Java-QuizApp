package com.project.quizapp.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto-incremented ID
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

    // Default constructor required by JPA
    public Quiz() {}


}
