package com.hibernate.fetchtype.service;

import com.hibernate.fetchtype.dao.NotaFiscalDAO;
import com.hibernate.fetchtype.model.NotaFiscal;

public class NotaFiscalService extends NotaFiscalDAO<NotaFiscal>{

    private static final long serialVersionUID = 6625712538513444443L;
    

    @Override
    public void salvar(NotaFiscal notaFiscal) {
        super.salvar(notaFiscal); 
    }    
}
