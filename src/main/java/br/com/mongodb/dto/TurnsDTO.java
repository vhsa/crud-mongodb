package br.com.mongodb.dto;

import br.com.mongodb.entities.Doctor;
import br.com.mongodb.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnsDTO {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;
}
