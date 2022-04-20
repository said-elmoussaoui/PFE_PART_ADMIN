package ma.adria.services;

import ma.adria.entities.ColumnStructure;
import ma.adria.enums.ColumnType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColumnStructureService {
    ColumnStructure save(ColumnStructure column,Long structureId);
    ColumnStructure update(Long id,ColumnStructure column);
    void delete(Long id);
    ColumnStructure getColumn(Long id);
    List<ColumnStructure> getColumnByStructure(Long idStructure);
    Page<ColumnStructure> getByColumnNameContains(String keyWord, Pageable pageable);
    Page<ColumnStructure> getByColumnType(ColumnType columntype, Pageable pageable);
    Page<ColumnStructure> getByIsMandatory(boolean isMandatory, Pageable pageable);
}
