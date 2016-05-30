package com.hibernate.fetchtype;

import com.hibernate.conexao.hibernateDB.ConexaoFactory;
import com.hibernate.fetchtype.entidade.Fornecedor;
import com.hibernate.fetchtype.entidade.NotaFiscal;
import com.hibernate.fetchtype.entidade.Produto;
import com.hibernate.fetchtype.entidade.ProdutoNotaFiscal;

public class NotaFiscalTest extends ConexaoFactory{
    
    public static void main(String[] args) {
        try {
            NotaFiscal notaFiscal = new NotaFiscal();
            Fornecedor fornecedor = fornecedor();
            notaFiscal.setFornecedor(fornecedor);
            
            ProdutoNotaFiscal produtoNotaFiscal = produtoNotaFiscal();
            
            notaFiscal.addProdutoNotaFiscalListener(produtoNotaFiscal);
            
            em.getTransaction().begin();
            em.persist(notaFiscal);
            em.getTransaction().commit();
            
            System.out.println("FIM");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ProdutoNotaFiscal produtoNotaFiscal() {
        ProdutoNotaFiscal produtoNotaFiscal = new ProdutoNotaFiscal();
        Produto produto = new Produto();
        produto.setDescricao("AAAAAAAa");
        produtoNotaFiscal.setProduto(produto);
        return produtoNotaFiscal;
    }

    private static Fornecedor fornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeFantasia("AAAAAA");
        return fornecedor;
    }
    
}
