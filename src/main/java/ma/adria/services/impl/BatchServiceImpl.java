package ma.adria.services.impl;

import ma.adria.entities.Batch;
import ma.adria.repositories.BatchRepository;
import ma.adria.services.BatchService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Batch> getAllBatchs() {
        return batchRepository.findAll();
    }
}
