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

    public NPC (NPC newNPC) {
        this.nome = newNPC.getNome();
        this.idade = newNPC.getIdade();
        this.raca = newNPC.getRaca();
        this.profissao = newNPC.getProfissao();
        this.alinhamento = newNPC.getAlinhamento();
        this.atributoAlto = newNPC.getAtributoAlto();
        this.atributoBaixo = newNPC.getAtributoBaixo();
        this.estiloCombate = newNPC.getEstiloCombate();

    }
    public NPC (RandomNPC rNPC) {
        this.nome = rNPC.getNome();
        this.idade = rNPC.getIdade();
        this.raca = rNPC.getRaca();
        this.profissao = rNPC.getProfissao();
        this.alinhamento = rNPC.getAlinhamento();
        this.atributoAlto = rNPC.getAtributoAlto();
        this.atributoBaixo = rNPC.getAtributoBaixo();
        this.estiloCombate = rNPC.getEstiloCombate();
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
