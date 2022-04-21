package ma.adria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import javax.persistence.Column;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "BATCH_TABLE")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BATCH")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_BATCH")
    private TypeBatch typeBatch;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_PROCESS")
    private TypeProcess typeProcess;
    @JsonIgnore
    @OneToMany(mappedBy="batch",fetch=FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Collection<Structure> structures;
}
