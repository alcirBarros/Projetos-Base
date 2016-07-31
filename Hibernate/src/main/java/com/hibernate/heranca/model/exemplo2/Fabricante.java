package com.hibernate.heranca.model.exemplo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "fbr_fabricante", catalog = "hibernateDB")
@PrimaryKeyJoinColumn(name="ins_id")
public class Fabricante extends Instituicao{
    
    private static final long serialVersionUID = -3184937568338739850L;
    
    @Column(name = "fabricante", nullable = false)
    private String fabricante;

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
    
    
}
