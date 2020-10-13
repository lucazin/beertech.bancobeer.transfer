package br.com.beertech.fusion.domain.accounts;

public enum ContaType {

    CORRENTE(1),
    POUPANCA(2);

    public int ID;

    ContaType(int value) {
        ID = value;
    }

    public static ContaType getById(int id) {
        if (id == 1) {
            return CORRENTE;
        } else {
            return POUPANCA;
        }
    }
}
