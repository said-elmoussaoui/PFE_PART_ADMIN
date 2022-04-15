package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StructureRepository extends JpaRepository<Structure,Long> {
    List<Structure> findByBatch(Batch batch);
}
