
package br.com.streaming.entity;

import br.com.streaming.enums.Perfil;
import br.com.streaming.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Usuario() {}

    public Usuario(String nome, String email, String senha,
                   Perfil perfil, TipoUsuario tipo, Conta conta) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.tipo = tipo;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public Conta getConta() {
        return conta;
    }
}
