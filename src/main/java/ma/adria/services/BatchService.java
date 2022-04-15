package ma.adria.services;

import ma.adria.entities.Batch;
import ma.adria.repositories.BatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BatchService {
     Batch save(Batch batch);
     Batch update(Long id,Batch batch);
     void delete(Long id);
     Batch getBatch(Long id);
     List<Batch> getAllBatchs();
}
