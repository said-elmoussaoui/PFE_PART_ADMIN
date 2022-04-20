package ma.adria.services;

import ma.adria.entities.Batch;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import ma.adria.repositories.BatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BatchService {
     Batch save(Batch batch);
     Batch update(Long id,Batch batch);
     void delete(Long id);
     Batch getBatch(Long id);
     List<Batch> getAllBatchs();
     Page<Batch> getByNameContains(String keyWord, Pageable pageable);
     Page<Batch> getByTypeBatch(TypeBatch typeBatch, Pageable pageable);
     Page<Batch> getByTypeProcess(TypeProcess typeProcess, Pageable pageable);
}
