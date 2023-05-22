package com.project.NpcGenerator.entities;

import jakarta.persistence.*;
import lombok.*;


                    /*  CLASSE ENTIDADE SERVE PARA REPRESENTAR A TABELA DO BANCO DE DADOS SQL  */

@Entity
@Table(name = "npc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NPC {

    public NPC(String nome, int idade, String raca, String profissao, String alinhamento, String atributoAlto, String atributoBaixo, String estiloCombate) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.profissao = profissao;
        this.alinhamento = alinhamento;
        this.atributoAlto = atributoAlto;
        this.atributoBaixo = atributoBaixo;
        this.estiloCombate = estiloCombate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;
    private int idade;
    private String raca;
    @Column(nullable = true)
    private String profissao;
    private String alinhamento;
    private String atributoAlto;
    private String atributoBaixo;
    @Column(nullable = true)
    private String estiloCombate;



}
