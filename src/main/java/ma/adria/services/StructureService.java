package ma.adria.services;


import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StructureService {
    Structure save(Structure structure,Long batchId);
    Structure update(Long id,Structure structure);
    void delete(Long id);
    Structure getStructure(Long id);
    List<Structure> getAllStructures();

    List<Structure> getStructuresByBatch(Long batchId);
    Page<Structure> getByCodeBank(String codeBank, Pageable pageable);
}
