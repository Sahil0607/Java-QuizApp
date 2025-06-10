package com.project.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data  // Lombok's @Data annotation generates getters, setters, toString, equals, and hashCode methods
@RequiredArgsConstructor //Lombok's @RequiredArgsConstructor generates a constructor with required arguments (final fields)
public class SubmitResponse {
    private Integer id;
    private String response;
}
