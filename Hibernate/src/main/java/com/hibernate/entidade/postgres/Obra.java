package com.hibernate.entidade.postgres;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_obra")
@SequenceGenerator(name = "pk_sequence_obra", sequenceName = "t_obra_cd_obra_seq", allocationSize = 1)
public class Obra implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "cd_obra")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_sequence_obra")
    private Integer cd_obra;

    @Column(name = "ds_sinopse")
    private String dsSinopse;

    @Column(name = "tp_obra")
    private String tp_obra;

//    @OneToOne(mappedBy = "Obra")
//    private ImagemObra ImagemObra;
}
