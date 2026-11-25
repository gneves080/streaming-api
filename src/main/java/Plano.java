
package br.com.streaming.enums;

public enum Plano {

    BASICO(1, 1),
    PADRAO(3, 2),
    PREMIUM(5, 3);

    private final int limiteUsuarios;
    private final int nivelConteudo;

    Plano(int limiteUsuarios, int nivelConteudo) {
        this.limiteUsuarios = limiteUsuarios;
        this.nivelConteudo = nivelConteudo;
    }

    public int getLimiteUsuarios() {
        return limiteUsuarios;
    }

    public int getNivelConteudo() {
        return nivelConteudo;
    }
}
