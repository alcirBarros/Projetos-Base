package com.estoque.movimentacao;

import com.cadastro.Cliente;
import com.cadastro.Vendedor;
import com.estoque.movimentacao.ProdutoMovimentacao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-26T18:27:28")
@StaticMetamodel(MovimentacaoProduto.class)
public class MovimentacaoProduto_ { 

    public static volatile SingularAttribute<MovimentacaoProduto, Cliente> cliente;
    public static volatile SingularAttribute<MovimentacaoProduto, Vendedor> vendedor;
    public static volatile SingularAttribute<MovimentacaoProduto, Integer> id;
    public static volatile ListAttribute<MovimentacaoProduto, ProdutoMovimentacao> produtoMovimentacaoList;
    public static volatile SingularAttribute<MovimentacaoProduto, Date> dataCadastro;
    public static volatile SingularAttribute<MovimentacaoProduto, String> numeroNota;

}