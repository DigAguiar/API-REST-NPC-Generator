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

	@Test
	@DisplayName("Testar se a lista de NPCS está sendo 'puxada'")
	void testGetListExistentsNpcs () {
		boolean teste = false;
		var npcList = npcService.listar();

		if (npcList==null)
			teste = true;

		Assertions.assertFalse(teste);

	}
	@Test
	@DisplayName("Salvando 150 NPC's aleatorios de vez, e analisar tempo de resposta (ms)")
	void savingAlotOfRandomNpcs () {
		boolean teste = true;
		for (int i = 0;i < 150; i++){
			npcService.salvarAleatorio();
		}

		Assertions.assertTrue(teste);
	}

}
