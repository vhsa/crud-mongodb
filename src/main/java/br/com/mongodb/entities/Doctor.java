package br.com.mongodb.entities;

import lombok.Data;

@Data
public class Doctor {
    private String firstName;
    private String lastName;
    private String specialty;
}
