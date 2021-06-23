package br.com.mongodb.dto;

import br.com.mongodb.entities.Doctor;
import br.com.mongodb.entities.Patient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "turns")
public class RequestDTO {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;
}
