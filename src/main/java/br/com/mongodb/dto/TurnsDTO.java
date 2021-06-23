package br.com.mongodb.dto;

import br.com.mongodb.entities.Doctor;
import br.com.mongodb.entities.Patient;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TurnsDTO {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;
}
