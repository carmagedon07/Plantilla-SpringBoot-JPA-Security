package com.api.page;

import com.api.page.DTO.UsuarioDTO1;
import com.api.page.Repository.Usuario.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PageApplicationTests {

	@Autowired
	private UsuarioRepository usRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {

		String pasword;
		String passworEncry;

		UsuarioDTO1 usDTO1 = new UsuarioDTO1();


		usDTO1.setUsername("manteca2");
		passworEncry =encoder.encode("786");
		usDTO1.setPassword(passworEncry);
		usDTO1.setIdPersona(2);
		usRepo.guardarUsauarioNo(4,usDTO1.getPassword(),usDTO1.getUsername());

		String contraSa = usRepo.contraseñaPorId(4);
		String controIn=usDTO1.getPassword();
		Assertions.assertTrue(contraSa.equals(controIn));


	}

	@Test
	void contraseña() {
		String con="789";
		String contraSa = usRepo.contraseñaPorId(2);
		Assertions.assertTrue(contraSa.equals(contraSa));
	}
}
