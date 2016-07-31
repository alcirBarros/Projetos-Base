//package com.hibernate.persistencia.entidade;
//
//import java.io.Serializable;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="usr_usuario", catalog = "persistenciaDB")
//public class Usuario implements Serializable{
//
//    private static final long serialVersionUID = -3877350523894313143L;
//    
//    @Id
//    @Column(name="usu_id")
//    private Integer id;
//    
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name="pss_id", referencedColumnName="pss_id")
//    private Pessoa pessoa;
//        
//    public Usuario(){
//       pessoa = new Pessoa();
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//    
//    
//
//}
