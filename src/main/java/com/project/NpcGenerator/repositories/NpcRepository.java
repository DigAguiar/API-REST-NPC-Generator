package com.project.NpcGenerator.repositories;

import com.project.NpcGenerator.entities.NPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends JpaRepository<NPC,Integer> {

    public NPC findByNome(String nome);


}
