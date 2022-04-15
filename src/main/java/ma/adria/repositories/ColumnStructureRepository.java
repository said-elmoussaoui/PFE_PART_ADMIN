package ma.adria.repositories;

import ma.adria.entities.ColumnStructure;
import ma.adria.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnStructureRepository extends JpaRepository<ColumnStructure,Long> {

    List<ColumnStructure> findByStructure(Structure structure);
}
