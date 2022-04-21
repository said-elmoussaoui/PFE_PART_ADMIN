package ma.adria.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.adria.enums.ColumnType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "COLUMN_STRUCTURE")
public class ColumnStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLUMN")
    private Long id;
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name="COLUMN_SIZE")
    private int columnSize;
    @Enumerated(EnumType.STRING)
    @Column(name = "COLUMN_TYPE")
    private ColumnType columnType;
    @Column(name = "IS_MANDATORY")
    private boolean isMandatory;
    @Column(name = "COLUMN_TABLE")
    private String columnTable;
    @Column(name = "NAME_TABLE")
    private String nameTable;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="CODE_STRUCTURE")
    private Structure structure;
}
