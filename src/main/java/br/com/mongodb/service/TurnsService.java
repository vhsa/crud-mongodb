package br.com.mongodb.service;

import br.com.mongodb.dto.RequestDTO;
import br.com.mongodb.dto.TurnsDTO;
import br.com.mongodb.dto.UpdateStatusDTO;
import br.com.mongodb.exception.TurnNotFoundException;
import br.com.mongodb.repositories.TurnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnsService {

    @Autowired
    TurnsRepository turnsRepository;

    public TurnsDTO store (RequestDTO r) {

        r.setDate(LocalDate.now());

        RequestDTO turnSaved = turnsRepository.save(r);

        return TurnsDTO.builder()
                .id(turnSaved.getId())
                .patient(turnSaved.getPatient())
                .doctor(turnSaved.getDoctor())
                .date(turnSaved.getDate())
                .status(turnSaved.getStatus())
                .build();

    }

    public List<TurnsDTO> listAll() {
        return turnsRepository.findAll().stream()
                .map( t -> {
                    TurnsDTO turnsDTO = new TurnsDTO();

                    turnsDTO.setId(t.getId());
                    turnsDTO.setPatient(t.getPatient());
                    turnsDTO.setDoctor(t.getDoctor());
                    turnsDTO.setDate(t.getDate());
                    turnsDTO.setStatus(t.getStatus());

                    return turnsDTO;
                }).collect(Collectors.toList());
    }

    public TurnsDTO findById(String id) {
        RequestDTO turn_not_found = turnsRepository.findById(id).orElseThrow(() -> new TurnNotFoundException("Turn not found"));

        return TurnsDTO.builder()
                .id(turn_not_found.getId())
                .patient(turn_not_found.getPatient())
                .doctor(turn_not_found.getDoctor())
                .date(turn_not_found.getDate())
                .status(turn_not_found.getStatus())
                .build();
    }

    public void deleteById (String id) {
        turnsRepository.deleteById(id);
    }

    public TurnsDTO updateStatusById(String id, UpdateStatusDTO status) {

        TurnsDTO turns = this.findById(id);

        RequestDTO r = new RequestDTO();

        r.setId(turns.getId());
        r.setPatient(turns.getPatient());
        r.setDoctor(turns.getDoctor());
        r.setDate(turns.getDate());
        r.setStatus(status.getStatus());

        RequestDTO save = turnsRepository.save(r);

        return TurnsDTO.builder()
                .id(save.getId())
                .patient(save.getPatient())
                .doctor(save.getDoctor())
                .date(save.getDate())
                .status(save.getStatus())
                .build();
    }

    public TurnsDTO update(String id, RequestDTO r) {

        this.findById(id);

        r.setId(id);

        RequestDTO updated = turnsRepository.save(r);

        return TurnsDTO.builder()
                .id(updated.getId())
                .patient(updated.getPatient())
                .doctor(updated.getDoctor())
                .date(updated.getDate())
                .status(updated.getStatus())
                .build();
    }
}
