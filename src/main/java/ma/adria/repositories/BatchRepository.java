package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch,Long> {
     Page<Batch> findByNameContains(String keyWord, Pageable pageable);
     Page<Batch> findByTypeBatch(TypeBatch typeBatch, Pageable pageable);
     Page<Batch> findByTypeProcess(TypeProcess typeProcess, Pageable pageable);
}
