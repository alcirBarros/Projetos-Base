package com.hibernate.fetchtype;

import com.hibernate.fetchtype.model.Fornecedor;
import com.hibernate.fetchtype.model.NotaFiscal;
import com.hibernate.fetchtype.model.Produto;
import com.hibernate.fetchtype.model.ProdutoNotaFiscal;
import com.hibernate.fetchtype.service.NotaFiscalService;

public class NotaFiscalTest {

    private static NotaFiscalService notaFiscalService;

    //Injector de dependencias
    static {
        notaFiscalService = new NotaFiscalService();
    }

    public static void main(String[] args) {
        try {
            NotaFiscal geraNotaFiscal = geraNotaFiscal();
            notaFiscalService.salvar(geraNotaFiscal);
            System.out.println("FIM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static NotaFiscal geraNotaFiscal() {
        NotaFiscal notaFiscal = new NotaFiscal();
        Fornecedor fornecedor = fornecedor();
        notaFiscal.setFornecedor(fornecedor);
        ProdutoNotaFiscal produtoNotaFiscal = produtoNotaFiscal();
        notaFiscal.addProdutoNotaFiscalListener(produtoNotaFiscal);
        return notaFiscal;
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
