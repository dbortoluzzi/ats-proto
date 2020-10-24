package eu.dbortoluzzi.atms.repository;

import eu.dbortoluzzi.atms.model.AtmIndexable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtmsRepository extends MongoRepository<AtmIndexable, String> {

}
