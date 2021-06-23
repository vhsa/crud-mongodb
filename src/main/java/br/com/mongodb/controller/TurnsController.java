package br.com.mongodb.controller;

import br.com.mongodb.dto.RequestDTO;
import br.com.mongodb.dto.TurnsDTO;
import br.com.mongodb.dto.UpdateStatusDTO;
import br.com.mongodb.service.TurnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TurnsController {

    @Autowired
    TurnsService turnsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurnsDTO store (@RequestBody RequestDTO r ) {
        return turnsService.store(r);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TurnsDTO update (@PathVariable String id, @RequestBody RequestDTO r ) {
        return turnsService.update(id, r);
    }

    @GetMapping
    public List<TurnsDTO> listAll () {
        return turnsService.listAll();
    }

    @GetMapping("/{id}")
    public TurnsDTO findById (@PathVariable String id) {
        return turnsService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable String id) {
        turnsService.deleteById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TurnsDTO updateStatus (@PathVariable String id, @RequestBody UpdateStatusDTO status) {
        return turnsService.updateStatusById(id, status);
    }
}
