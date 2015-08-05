package com.lerarquivoxls;

import com.cadastro.Cliente;
import com.cadastro.Laboratorio;
import com.cadastro.Produto;
import com.cadastro.Vendedor;
import com.estoque.movimentacao.MovimentacaoProduto;
import com.estoque.movimentacao.ProdutoMovimentacao;
import com.util.Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;

public class ProcessaPlanilha extends Service{

    private DateFormat dateFormat = new SimpleDateFormat("d-MMM-yy", Locale.ENGLISH);

    private HashMap<String, Cliente> clienteList = new HashMap<>();
    private HashMap<String, Laboratorio> laboratorioList = new HashMap<>();
    private HashMap<String, Produto> produtoList = new HashMap<>();
    private HashMap<String, Vendedor> vendedorList = new HashMap<>();
    
    public void setEm(EntityManager em){
        super.em = em;
    }

    public void processar(List<List> list) {
        em.getTransaction().begin();
        try {
            HashMap<String, MovimentacaoProduto> movimentacaoProdutoList = new HashMap<>();

            List<Registro> registroList = converterToList(list);
            existeCadastro(registroList);

            for (Registro registro : registroList) {

                MovimentacaoProduto movimentacaoProduto = movimentacaoProdutoList.get(registro.numeroNota);
                if (movimentacaoProduto == null) {
                    Vendedor vendedor = vendedorList.get(registro.vendedorNome);
                    Cliente cliente = clienteList.get(registro.clienteCodigo);
                    movimentacaoProduto = new MovimentacaoProduto();
                    movimentacaoProduto.setNumeroNota(registro.numeroNota);
                    movimentacaoProduto.setDataCadastro(registro.dataCadastro);
                    movimentacaoProduto.setVendedor(vendedor);
                    movimentacaoProduto.setCliente(cliente);

                    ProdutoMovimentacao produtoMovimentacao = converterToProdutoMovimentacao(registro);
                    produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
                    movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);
                    movimentacaoProdutoList.put(registro.numeroNota, movimentacaoProduto);
                } else {
                    ProdutoMovimentacao produtoMovimentacao = converterToProdutoMovimentacao(registro);
                    produtoMovimentacao.setMovimentacaoProduto(movimentacaoProduto);
                    movimentacaoProduto.getProdutoMovimentacaoList().add(produtoMovimentacao);
                }
            }
            
            for (MovimentacaoProduto movimentacaoProduto : movimentacaoProdutoList.values()) {
                em.persist(movimentacaoProduto);
            }
            
            em.getTransaction().commit();
            System.out.println("Fim.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ProdutoMovimentacao converterToProdutoMovimentacao(Registro registro) {
        Produto produto = produtoList.get(registro.produtoCodigo);
        Laboratorio laboratorio = laboratorioList.get(registro.laboratorioDescricao);
        BigInteger quantidade = registro.quantidade;
        BigDecimal valorUnitario = registro.valorUnitario;
        
        BigDecimal valorTotal = new BigDecimal(quantidade).multiply(valorUnitario);
        
        ProdutoMovimentacao produtoMovimentacao = new ProdutoMovimentacao();
        produtoMovimentacao.setProduto(produto);
        produtoMovimentacao.setLaboratorio(laboratorio);
        produtoMovimentacao.setQuantidade(quantidade);
        produtoMovimentacao.setValorUitario(valorUnitario);
        produtoMovimentacao.setValorTotal(valorTotal);
        
        return produtoMovimentacao;
    }

    private void existeCadastro(List<Registro> registroList) {
        for (Registro registro : registroList) {
            converterToCliente(registro);
            converterToLaboratirio(registro);
            converterToProduto(registro);
            converterToVendedor(registro);
        }
    }

    private void converterToCliente(Registro registro) {
        Cliente cliente = clienteList.get(registro.clienteCodigo);
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setCodigo(registro.clienteCodigo);
            cliente.setNome(registro.clienteNome);
            em.persist(cliente);
            clienteList.put(registro.clienteCodigo, cliente);
        }
    }

    private void converterToLaboratirio(Registro registro) {
        Laboratorio laboratorio = laboratorioList.get(registro.laboratorioDescricao);
        if (laboratorio == null) {
            laboratorio = new Laboratorio();
            laboratorio.setDescricao(registro.laboratorioDescricao);
            em.persist(laboratorio);
            laboratorioList.put(registro.laboratorioDescricao, laboratorio);
        }
    }

    private void converterToProduto(Registro registro) {
        Produto produto = produtoList.get(registro.produtoCodigo);
        if (produto == null) {
            produto = new Produto();
            produto.setCodigo(registro.produtoCodigo);
            produto.setDescricao(registro.produtoDescricao);
            em.persist(produto);
            produtoList.put(registro.produtoCodigo, produto);
        }
    }

    private void converterToVendedor(Registro registro) {
        Vendedor vendedor = vendedorList.get(registro.vendedorNome);
        if (vendedor == null) {
            vendedor = new Vendedor();
            vendedor.setNome(registro.vendedorNome);
            em.persist(vendedor);
            vendedorList.put(registro.vendedorNome, vendedor);
        }
    }

    private List<Registro> converterToList(List<List> list) throws Exception {
        List<Registro> registroList = new ArrayList<>();
        for (List linha : list) {
            if (!linha.isEmpty()) {
                Registro registro = converterTo(linha);
                registroList.add(registro);
            }
        }
        return registroList;
    }

    private Registro converterTo(List linha) throws Exception {
        try {
            Object dataCadastro = linha.get(0);
            Object numeroNota = linha.get(1);
            Object dataEmissao = linha.get(2);
            Object mes = linha.get(3);
            Object produtoCodigo = linha.get(4);
            Object produtoDescricao = linha.get(5);
            Object laboratorioDescricao = linha.get(6);
            Object vendedorNome = linha.get(7);
            Object quantidade = linha.get(8);
            Object valorUnitario = linha.get(9);
            Object valorTotal = linha.get(10);
            Object clienteCodigo = linha.get(11);
            Object clienteNome = linha.get(12);
            Registro registro = new Registro();
            registro.dataCadastro = dateFormat.parse(dataCadastro.toString());
            registro.numeroNota = numeroNota.toString();
            registro.produtoCodigo = produtoCodigo.toString();
            registro.produtoDescricao = produtoDescricao.toString();
            registro.laboratorioDescricao = laboratorioDescricao.toString();
            registro.vendedorNome = vendedorNome.toString();
            registro.quantidade = new BigDecimal(quantidade.toString()).toBigInteger();
            registro.valorUnitario = new BigDecimal(valorUnitario.toString());
            registro.clienteCodigo = clienteCodigo.toString();
            registro.clienteNome = clienteNome.toString();
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    class Registro {

        Date dataCadastro;
        String numeroNota;
        Date dataEmissao;
        String mes;
        String produtoCodigo;
        String produtoDescricao;
        String laboratorioDescricao;
        String vendedorNome;
        BigInteger quantidade;
        BigDecimal valorUnitario;
        BigDecimal valorTotal;
        String clienteCodigo;
        String clienteNome;
    }

}
