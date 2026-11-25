
package br.com.streaming.entity;

import br.com.streaming.enums.Plano;
import jakarta.persistence.*;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Plano plano;

    public Conta() {}

    public Conta(Plano plano) {
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
