package br.com.mongodb.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Patient {
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
}
