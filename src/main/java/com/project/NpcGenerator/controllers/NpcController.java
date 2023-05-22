package com.project.NpcGenerator.controllers;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.repositories.NpcRepository;
import com.project.NpcGenerator.services.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/npcGenerator")
public class NpcController {


    @Autowired
    private NpcService npcService;

    @PostMapping
    public ResponseEntity<Object> salvar() {
        try {
            npcService.salvar();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nome invalido");
        }

        return ResponseEntity.ok("Deu certo!");

    }

    @GetMapping
    public List<NPC> listar() {
        List<NPC> npcList = npcService.listar();

        return npcList;
    }

    @DeleteMapping("/delete={id}")
    @Transactional
    public ResponseEntity<Object> apagar(@PathVariable Integer id) {
        String msg = npcService.apagar(id);

        return ResponseEntity.ok(msg);
    }



    @PutMapping("/edit={id}")
    @Transactional
    public ResponseEntity<Object> editar(@PathVariable Integer id) {
        String msg = npcService.editar(id);

        return ResponseEntity.ok(msg);

    }
}
