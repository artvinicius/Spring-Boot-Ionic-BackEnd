package com.arthurvinicius.cursomc.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"), 
    QUITADO(2, "Quiteado"), 
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento(final int cod, final String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnumCliente(final Integer cod) {
        if (cod == null) {
            return null;

        }

        for (final EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("id inválido" + cod);

    }

}
