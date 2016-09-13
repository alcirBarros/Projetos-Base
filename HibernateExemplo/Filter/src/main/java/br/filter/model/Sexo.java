package br.filter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sxo_sexo", catalog = "hibernateDB")
public class Sexo implements Serializable {

    private static final long serialVersionUID = 2274210870062409057L;
   
   @Id
   @GeneratedValue
   @Column(name = "sxo_id")
   private Integer Id;
   
   @Column(name = "sxo_descricao")
   private String descricao;

   public Integer getId() {
      return Id;
   }

   public void setId(Integer Id) {
      this.Id = Id;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
}