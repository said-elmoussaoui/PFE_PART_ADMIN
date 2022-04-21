package ma.adria.services.impl;

import ma.adria.entities.Batch;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import ma.adria.repositories.BatchRepository;
import ma.adria.services.BatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    private BatchRepository batchRepository;
    public BatchServiceImpl(BatchRepository batchRepository){
        this.batchRepository = batchRepository;
    }
    @Override
    public Batch save(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Batch update(Long id, Batch batch) {
        batch.setId(id);
        return batchRepository.save(batch);
    }

    @Override
    public void delete(Long id) {
        batchRepository.deleteById(id);
    }

    @Override
    public Batch getBatch(Long id) {
        return batchRepository.findById(id).get();
    }

    @Override
    public Page<Batch> getAllBatchs(Pageable pageable) {
        return batchRepository.findAll(pageable);
    }

    @Override
    public Page<Batch> search(int page,int size,String keyword, TypeBatch type, TypeProcess process) {
        if (keyword == null) keyword = "";
        if (type != null && process != null)
            return batchRepository.findByNameContainsAndTypeBatchAndTypeProcess(keyword, type, process, PageRequest.of(page, size));
        else if (type != null)
            return batchRepository.findByNameContainsAndTypeBatch(keyword, type, PageRequest.of(page, size));
        else if (process != null)
            return batchRepository.findByNameContainsAndTypeProcess(keyword, process, PageRequest.of(page, size));
        else
            return batchRepository.findByNameContains(keyword, PageRequest.of(page, size));
    }
}
