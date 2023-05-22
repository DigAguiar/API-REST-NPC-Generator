package com.project.NpcGenerator.services;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.repositories.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NpcService {
    @Autowired
    NpcRepository npcRepository;


    public void salvar() {
        NPC npc = new NPC(
                "Raul",
                28,
                "humano",
                "Computeiro",
                "do bem master",
                "carisma",
                "força",
                "caster");


        try {
            npcRepository.save(npc);
        } catch (Exception e) {
            throw new RuntimeException("Nome existente");
        }

    }

    public List<NPC> listar() {
        List<NPC> npcList = npcRepository.findAll();
        return npcList;
    }

    public String apagar(Integer idNPC) {
        String msg = "ID Inexistente";
        List<NPC> npcList = npcRepository.findAll();

        for (NPC npc : npcList) {
            if (npc.getId() == idNPC)
                msg = npc.getNome() + " APAGADO COM SUCESSO!";
        }

        npcRepository.deleteById(idNPC);


        return msg;
    }

    public String editar(Integer idNPC) {
        String msg = "Editado";
        NPC npc = npcRepository.getById(idNPC);

        npc.setNome("Diogo de Aguiar");
        npc.setIdade(21);
        npc.setRaca("Humano");
        npc.setProfissao("Estudante");
        npc.setAlinhamento("Do bem");
        npc.setAtributoAlto("Força");
        npc.setAtributoBaixo("Sabedoria");
        npc.setEstiloCombate("Combatente");

        return msg;
    }

}
