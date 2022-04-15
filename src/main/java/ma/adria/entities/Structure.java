package ma.adria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "STRUCTURE_TABLE")
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STRUCTURE")
    private Long id;
    @Column(name = "CODE_BANK")
    private String codeBank;
    @Column(name = "STRUCTURE_NAME")
    private String structureName;
    @ManyToOne
    @JoinColumn(name="CODE_BATCH")
    private Batch batch;
    @JsonIgnore
    @OneToMany(mappedBy="structure",fetch=FetchType.LAZY)
    private Collection<ColumnStructure> itemStructures;
}
