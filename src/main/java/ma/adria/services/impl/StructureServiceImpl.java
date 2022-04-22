package ma.adria.services.impl;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import ma.adria.repositories.StructureRepository;
import ma.adria.services.StructureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StructureServiceImpl implements StructureService {

    private StructureRepository structureRepository;

    private BatchServiceImpl batchService;

    public StructureServiceImpl(StructureRepository structureRepository,BatchServiceImpl batchService){
        this.structureRepository = structureRepository;
        this.batchService = batchService;
    }
    @Override
    public Structure save(Structure structure,Long batchId) {
        Batch batch = batchService.getBatch(batchId);
        structure.setBatch(batch);
        return structureRepository.save(structure);
    }

    @Override
    public Structure update(Long id, Structure structure) {
        Structure old_structure = structureRepository.findById(id).get();
        structure.setBatch(old_structure.getBatch());
        structure.setId(id);
        return structureRepository.save(structure);
    }

    @Override
    public void delete(Long id) {
        structureRepository.deleteById(id);
    }

    @Override
    public Structure getStructure(Long id) {
        return structureRepository.findById(id).get();
    }

    @Override
    public Page<Structure> getAllStructures(Pageable pageable) {
        return structureRepository.findAll(pageable);
    }

    @Override
    public Page<Structure> getStructuresByBatch(Long batchId,Pageable pageable) {
        Batch batch = batchService.getBatch(batchId);
        if (batch != null)
            return structureRepository.findByBatch(batch,pageable);
        else return null;
    }

    @Override
    public Page<Structure> getByCodeBank(Long batchCode,String codeBank, Pageable pageable) {
        Batch batch = batchService.getBatch(batchCode);
        return structureRepository.findByBatchAndCodeBank(batch,codeBank,pageable);
    }
}
