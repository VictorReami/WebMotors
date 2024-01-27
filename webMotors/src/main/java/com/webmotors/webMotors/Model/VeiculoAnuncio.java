package com.webmotors.webMotors.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculo_anuncio", uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class VeiculoAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "veiculo_anuncio_item",
            joinColumns =  @JoinColumn(name = "id_veiculo_anuncio"),
            inverseJoinColumns = @JoinColumn(name = "id_opcional")
    )
    private List<Opcional> opcional;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "usado")
    private Boolean usado;

    @Column(name = "status")
    private String status;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "quilometro")
    private Float quilometro;

    @Column(name = "cor")
    private String cor;
}
