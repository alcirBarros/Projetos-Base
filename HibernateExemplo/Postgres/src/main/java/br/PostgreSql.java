package br;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
//@SequenceGenerator(name = "SEQ_RECEBIMENTO", sequenceName = "S_RECEBIMENTO", allocationSize = 1)
@Table(name = "T_RECEBIMENTO")
public class PostgreSql implements Serializable {

    private static final long serialVersionUID = -5564268200989050349L;

    @TableGenerator(name="DOG_GENERATOR",
            table="GENERATED_KEYS",
            pkColumnName="PK_COLUMN",
            valueColumnName="VALUE_COLUMN",
            pkColumnValue="DOG_ID",
            allocationSize=1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECEBIMENTO")
    @Column(name = "isn_recebimento")
    private Integer id;

}
