package br.util;

public enum TipoConexaoEnum {

    MYSQL("persistence_unit_mysql"), 
    POSTGRES("persistence_unit_postgres");

    private final String persistenceUnit;

    private TipoConexaoEnum(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    public String getPersistenceUnit() {
        return persistenceUnit;
    }
}
