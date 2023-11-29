package com.project.NpcGenerator.services;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.entities.RandomNPC;
import com.project.NpcGenerator.repositories.NpcRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NpcService {
    @Autowired
    NpcRepository npcRepository;


    public NPC salvar(NPC newNPC) throws Exception {
        npcRepository.save(newNPC);
        return newNPC;
    }

    public RandomNPC salvarAleatorio() {
        RandomNPC rNPC = new RandomNPC();
        rNPC.statusNPC();

        npcRepository.save(new NPC(rNPC));
        return rNPC;
    }

    public List<NPC> listar() {
        List<NPC> npcList = npcRepository.findAll();
        return npcList;
    }

    public void apagar(Integer id) throws Exception {
        NPC npc = npcRepository.getReferenceById(id);
        npcRepository.delete(npc);
    }

    public void editar(Integer idNPC, NPC dados) throws Exception {
        NPC npc = npcRepository.getById(idNPC);

        if (dados.getNome() != null)
            npc.setNome(dados.getNome());
        if (dados.getIdade() != 0)
            npc.setIdade(dados.getIdade());
        if (dados.getRaca() != null)
            npc.setRaca(dados.getRaca());
        if (dados.getProfissao() != null)
            npc.setProfissao(dados.getProfissao());
        if (dados.getAlinhamento() != null)
            npc.setAlinhamento(dados.getAlinhamento());
        if (dados.getAtributoAlto() != null)
            npc.setAtributoAlto(dados.getAtributoAlto());
        if (dados.getAtributoBaixo() != null)
            npc.setAtributoBaixo(dados.getAtributoBaixo());
        if (dados.getEstiloCombate() != null)
            npc.setEstiloCombate(dados.getEstiloCombate());
        salvar(npc);

    }

}
