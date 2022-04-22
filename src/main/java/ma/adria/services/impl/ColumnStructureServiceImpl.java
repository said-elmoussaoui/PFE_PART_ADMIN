package ma.adria.services.impl;

import ma.adria.entities.ColumnStructure;
import ma.adria.entities.Structure;
import ma.adria.enums.ColumnType;
import ma.adria.repositories.ColumnStructureRepository;
import ma.adria.services.ColumnStructureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
        ColumnStructure old_column = columnStructureRepository.findById(id).get();
        column.setStructure(old_column.getStructure());
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
    public Page<ColumnStructure> getColumnByStructure(Long idStructure, Pageable pageable) {
        Structure structure = structureService.getStructure(idStructure);
        if(structure != null)
            return columnStructureRepository.findByStructure(structure,pageable);
        else return null;
    }

    @Override
    public Page<ColumnStructure> search(int page,int size,Long structureCode,String keyword, ColumnType columnType, boolean isMandatory) {
        Structure structure = structureService.getStructure(structureCode);
        if(keyword == null) keyword="";
        if(columnType==null)
            return columnStructureRepository.findByStructureAndColumnNameContainsAndIsMandatory(structure,keyword,isMandatory, PageRequest.of(page,size));
        else  return columnStructureRepository.findByStructureAndColumnNameContainsAndColumnTypeAndIsMandatory(structure,keyword,columnType,isMandatory,PageRequest.of(page,size));
    }
}
