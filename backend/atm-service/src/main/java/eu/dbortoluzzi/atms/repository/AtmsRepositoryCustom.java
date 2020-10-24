package eu.dbortoluzzi.atms.repository;

import eu.dbortoluzzi.atms.model.AtmIndexable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AtmsRepositoryCustom {
    public Page<AtmIndexable> search(String querySearch, Pageable pageable);
}
