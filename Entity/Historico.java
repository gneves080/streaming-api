
package br.com.streaming.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historicos")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @Column(nullable = false)
    private LocalDateTime dataAssistido;

    public Historico() {}

    public Historico(Usuario usuario, Filme filme) {

        this.usuario = usuario;
        this.filme = filme;
        this.dataAssistido = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public LocalDateTime getDataAssistido() {
        return dataAssistido;
    }
}
