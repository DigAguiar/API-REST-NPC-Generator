package com.project.NpcGenerator;

import com.project.NpcGenerator.entities.NPC;
import com.project.NpcGenerator.services.NpcService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NpcGeneratorApplicationTests {

	@Autowired
	NpcService npcService;

	@Test
	@DisplayName("Testar se o NPC realmente só recebe informações aleatórias")
	void testRandomizedInfoFromNewNPC() throws Exception {
//		NPC newNpc = new NPC(1,"Dig",14,"humano","lenhador","do bem","Força","Sabedoria","Labia");
//		var rNpc = npcService.salvar(newNpc);

		var rNpc = npcService.salvarAleatorio();
		boolean teste = false;

		if (rNpc.getNome() == null && rNpc.getProfissao() == null) {
			teste = true;
		}
		Assertions.assertTrue(teste);


	}

}
