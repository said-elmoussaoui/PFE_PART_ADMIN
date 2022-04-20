package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.ColumnStructure;
import ma.adria.entities.Structure;
import ma.adria.enums.ColumnType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnStructureRepository extends JpaRepository<ColumnStructure,Long> {

    Page<ColumnStructure> findByStructure(Structure structure, Pageable pageable);
    Page<ColumnStructure> findByColumnNameContains(String keyWord, Pageable pageable);
    Page<ColumnStructure> findByColumnType(ColumnType columntype, Pageable pageable);
    Page<ColumnStructure> findByIsMandatory(boolean isMandatory, Pageable pageable);
}
