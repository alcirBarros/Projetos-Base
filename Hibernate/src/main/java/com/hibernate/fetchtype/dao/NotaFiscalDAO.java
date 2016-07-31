package com.hibernate.fetchtype.dao;

import com.hibernate.conexao.util.GenericFacade;
import com.hibernate.fetchtype.model.NotaFiscal;

public class NotaFiscalDAO<T> extends GenericFacade<NotaFiscal>{

    private static final long serialVersionUID = -8609161680919430230L;

    public void salvar(NotaFiscal notaFiscal) {
        super.inserir(notaFiscal);
    }

}
