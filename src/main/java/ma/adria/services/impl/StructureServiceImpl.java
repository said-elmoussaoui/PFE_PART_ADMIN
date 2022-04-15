package ma.adria.services.impl;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import ma.adria.repositories.StructureRepository;
import ma.adria.services.StructureService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Structure> getAllStructures() {
        return structureRepository.findAll();
    }

    @Override
    public List<Structure> getStructuresByBatch(Long batchId) {
        Batch batch = batchService.getBatch(batchId);
        if (batch != null)
            return structureRepository.findByBatch(batch);
        else return null;
    }
}
