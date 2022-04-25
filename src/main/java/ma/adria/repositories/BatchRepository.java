package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BatchRepository extends JpaRepository<Batch,Long> {
     Page<Batch> findByNameContains(String keyWord, Pageable pageable);
     Page<Batch> findByNameContainsAndTypeBatch(String keyword,TypeBatch typeBatch, Pageable pageable);
     Page<Batch> findByNameContainsAndTypeProcess(String keyword,TypeProcess typeProcess, Pageable pageable);
     Page<Batch> findByNameContainsAndTypeBatchAndTypeProcess(String keyword,TypeBatch typeBatch,TypeProcess typeProcess,Pageable pageable);
     Batch findByName(String name);
}
