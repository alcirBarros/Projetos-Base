package br.movimentacaoproduto.model;


public enum TipoMovimento {
    ENTRADA("ENTRADA", "Entrada"),
    SAIDA("SAIDA", "Saída");
    
    private final String value;
    private final String descricao;

    private TipoMovimento(String value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }
}
