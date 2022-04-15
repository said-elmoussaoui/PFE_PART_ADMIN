package ma.adria.services;

import ma.adria.entities.ColumnStructure;

import java.util.List;

public interface ColumnStructureService {
    ColumnStructure save(ColumnStructure column,Long structureId);
    ColumnStructure update(Long id,ColumnStructure column);
    void delete(Long id);
    ColumnStructure getColumn(Long id);
    List<ColumnStructure> getColumnByStructure(Long idStructure);
}
