package com.project.NpcGenerator.controllers;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.entities.RandomNPC;
import com.project.NpcGenerator.repositories.NpcRepository;
import com.project.NpcGenerator.services.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/npcGenerator")
public class NpcController {
    @Autowired
    private NpcService npcService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody NPC dados) throws Exception {
        npcService.salvar(dados);
        return ResponseEntity.ok("NPC salvo!");

    }

    @PostMapping("/randomNPC")
    public ResponseEntity<RandomNPC> salvarAleatorio() {
        var obj = npcService.salvarAleatorio();

        return ResponseEntity.ok(obj);
    }


    @GetMapping
    public List<NPC> listar() {
        List<NPC> npcList = npcService.listar();
        return npcList;
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity<Object> apagar(@PathVariable Integer id) throws Exception {
        npcService.apagar(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/edit={id}")
    public ResponseEntity editar(@PathVariable Integer id, @RequestBody NPC dados) throws Exception {
        npcService.editar(id, dados);

        return ResponseEntity.ok("NPC Editado!");

    }
}
