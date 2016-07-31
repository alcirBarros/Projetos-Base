package com.estoque.movimentacao;

import com.cadastro.Laboratorio;
import com.cadastro.Produto;
import com.estoque.movimentacao.MovimentacaoProduto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-26T09:20:09")
@StaticMetamodel(ProdutoMovimentacao.class)
public class ProdutoMovimentacao_ { 

    public static volatile SingularAttribute<ProdutoMovimentacao, Produto> produto;
    public static volatile SingularAttribute<ProdutoMovimentacao, BigDecimal> valorUitario;
    public static volatile SingularAttribute<ProdutoMovimentacao, BigDecimal> valorTotal;
    public static volatile SingularAttribute<ProdutoMovimentacao, Integer> id;
    public static volatile SingularAttribute<ProdutoMovimentacao, Laboratorio> laboratorio;
    public static volatile SingularAttribute<ProdutoMovimentacao, MovimentacaoProduto> movimentacaoProduto;
    public static volatile SingularAttribute<ProdutoMovimentacao, BigInteger> quantidade;

}