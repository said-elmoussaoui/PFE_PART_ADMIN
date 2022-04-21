package ma.adria.services;

import ma.adria.entities.Batch;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BatchService {
     Batch save(Batch batch);
     Batch update(Long id,Batch batch);
     void delete(Long id);
     Batch getBatch(Long id);
     Page<Batch> getAllBatchs(Pageable pageable);

     Page<Batch> search(int page,int size,String keyword,TypeBatch type,TypeProcess process);
}
