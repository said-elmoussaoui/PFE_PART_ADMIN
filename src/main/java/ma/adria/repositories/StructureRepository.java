package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StructureRepository extends JpaRepository<Structure,Long> {
    Page<Structure> findByBatch(Batch batch,Pageable pageable);
    Page<Structure> findByCodeBank(String codeBank, Pageable pageable);

    Page<Structure> findByBatchAndCodeBank(Batch batch,String codeBank,Pageable pageable);
}
