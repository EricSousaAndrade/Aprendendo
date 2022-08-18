package com.example.aprendendo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "pessoa")
@Table(indexes = {
        @Index(name = "idx_pessoaentity_id_endereco", columnList = "id_endereco")
})
@Getter
@Setter
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "seq_pessoa", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private EnderecoEntity enderecoEntity;

    @Column(name = "id_endereco",  updatable = false, insertable = false)
    private Long idEndereco;

}
