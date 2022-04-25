package ma.adria.repositories;

import ma.adria.entities.ColumnStructure;
import ma.adria.entities.Structure;
import ma.adria.enums.ColumnType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ColumnStructureRepository extends JpaRepository<ColumnStructure,Long> {

    Page<ColumnStructure> findByStructure(Structure structure, Pageable pageable);
    Page<ColumnStructure> findByStructureAndColumnNameContainsAndIsMandatory(Structure structure,String keyword,boolean isMandatory,Pageable pageable);
    Page<ColumnStructure> findByStructureAndColumnNameContainsAndColumnTypeAndIsMandatory(Structure structure,String keyword,ColumnType columnType,boolean isMandatory,Pageable pageable);
    List<ColumnStructure> findByStructure(Structure structure);
}
