package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StructureRepository extends JpaRepository<Structure,Long> {
    Page<Structure> findByBatch(Batch batch,Pageable pageable);D:
    Page<Structure> findByCodeBank(String codeBank, Pageable pageable);
}
