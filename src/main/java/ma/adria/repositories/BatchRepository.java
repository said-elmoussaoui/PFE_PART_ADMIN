package ma.adria.repositories;

import ma.adria.entities.Batch;
import ma.adria.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch,Long> {

}
