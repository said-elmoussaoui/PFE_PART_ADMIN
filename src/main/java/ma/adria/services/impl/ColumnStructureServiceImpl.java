package ma.adria.services.impl;

import ma.adria.entities.ColumnStructure;
import ma.adria.entities.Structure;
import ma.adria.enums.ColumnType;
import ma.adria.repositories.ColumnStructureRepository;
import ma.adria.services.ColumnStructureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColumnStructureServiceImpl  implements ColumnStructureService {

    private StructureServiceImpl structureService;
    private ColumnStructureRepository columnStructureRepository;

    public ColumnStructureServiceImpl(StructureServiceImpl structureService,ColumnStructureRepository columnStructureRepository){
        this.columnStructureRepository = columnStructureRepository;
        this.structureService = structureService;
    }
    @Override
    public ColumnStructure save(ColumnStructure column,Long structureId) {
        Structure structure = structureService.getStructure(structureId);
        column.setStructure(structure);
        return columnStructureRepository.save(column);
    }

    @Override
    public ColumnStructure update(Long id, ColumnStructure column) {
        column.setId(id);
        return columnStructureRepository.save(column);
    }

    @Override
    public void delete(Long id) {
        columnStructureRepository.deleteById(id);
    }

    @Override
    public ColumnStructure getColumn(Long id) {
        return columnStructureRepository.findById(id).get();
    }

    @Override
    public List<ColumnStructure> getColumnByStructure(Long idStructure) {
        Structure structure = structureService.getStructure(idStructure);
        if(structure != null)
            return columnStructureRepository.findByStructure(structure);
        else return null;
    }

    @Override
    public Page<ColumnStructure> getByColumnNameContains(String keyWord, Pageable pageable) {
        return columnStructureRepository.findByColumnNameContains(keyWord, pageable);
    }

    @Override
    public Page<ColumnStructure> getByColumnType(ColumnType columntype, Pageable pageable) {
        return columnStructureRepository.findByColumnType(columntype, pageable);
    }

    @Override
    public Page<ColumnStructure> getByIsMandatory(boolean isMandatory, Pageable pageable) {
        return columnStructureRepository.findByIsMandatory(isMandatory, pageable);
    }
}
