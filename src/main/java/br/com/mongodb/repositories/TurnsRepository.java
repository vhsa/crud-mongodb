package br.com.mongodb.repositories;

import br.com.mongodb.dto.RequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnsRepository extends MongoRepository<RequestDTO, String> {}
