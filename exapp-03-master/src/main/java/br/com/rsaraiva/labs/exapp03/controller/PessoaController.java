package br.com.rsaraiva.labs.exapp03.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.rsaraiva.labs.exapp03.model.Pessoa;
import br.com.rsaraiva.labs.exapp03.service.PessoaService;
import java.util.ArrayList;
import java.util.List;

@Resource
public class PessoaController {
    
    private Result result;
    private PessoaService pessoaService;
    
    private List<Pessoa> pessoas = new ArrayList();

    public PessoaController(Result result, PessoaService pessoaService) {
        
        this.result = result;
        this.pessoaService = pessoaService;
        
        pessoas = pessoaService.listaTudo();
    }
    
    public List<Pessoa> lista() {
        return pessoas;
    }
    
    public void form() {
    }
    
    public void salva(Pessoa pessoa) {
        pessoaService.salva(pessoa);
        result.redirectTo(this).lista();
    }
}
