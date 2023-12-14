package org.sid.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
public class BillingApplication {
	@Autowired
	private VaultTemplate vaultTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}
	CommandLineRunner commandLineRunner(){
		return args -> {
			vaultTemplate.opsForVersionedKeyValue("secret")
					.put("keypair", Map.of("privKey","5454","pubKey","5434"));
		};
	}
}
