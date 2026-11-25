
package br.com.streaming.entity;

import br.com.streaming.enums.Perfil;
import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Perfil classificacao;

    private int nivelPlano;

    public Filme() {}

    public Filme(String titulo, Perfil classificacao, int nivelPlano) {

        this.titulo = titulo;
        this.classificacao = classificacao;
        this.nivelPlano = nivelPlano;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Perfil getClassificacao() {
        return classificacao;
    }

    public int getNivelPlano() {
        return nivelPlano;
    }
}
