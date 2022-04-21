package ma.adria.services;

import ma.adria.entities.ColumnStructure;
import ma.adria.enums.ColumnType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ColumnStructureService {
    ColumnStructure save(ColumnStructure column,Long structureId);
    ColumnStructure update(Long id,ColumnStructure column);
    void delete(Long id);
    ColumnStructure getColumn(Long id);
    Page<ColumnStructure> getColumnByStructure(Long idStructure,Pageable pageable);

    Page<ColumnStructure> search(int page,int size,Long structureCode,String keyword,ColumnType columnType,boolean isMandatory);
}
