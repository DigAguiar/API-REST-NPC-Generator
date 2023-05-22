package com.project.NpcGenerator;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.repositories.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NpcGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpcGeneratorApplication.class, args);

	}

}
