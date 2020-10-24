package eu.dbortoluzzi.atms;

import eu.dbortoluzzi.atms.model.AtmIndexable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AtmsRepository extends MongoRepository<AtmIndexable, String> {

    @Query("{'searchTerm': {$regex : ?0, $options: 'i'}})")
    List<AtmIndexable> findByQuery(String query);
}
