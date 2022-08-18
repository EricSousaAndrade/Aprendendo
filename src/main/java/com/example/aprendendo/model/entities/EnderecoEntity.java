package com.example.aprendendo.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "seq_endereco", allocationSize = 1)
    @Column(name = "id_endereco", nullable = false)
    private Long idEndereco;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "cep", nullable = false)
    private Long cep;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "enderecoEntity",
            cascade = CascadeType.ALL,targetEntity = PessoaEntity.class)
    private Set<PessoaEntity> pessoaEntities;

}
