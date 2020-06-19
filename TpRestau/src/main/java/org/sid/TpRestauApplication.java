package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpRestauApplication implements CommandLineRunner {
	@Autowired
	 private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpRestauApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	produitRepository.save(new Produit("produit 1","produit1.png",1,245));
		produitRepository.save(new Produit("produit 2","produit2.png",1,755));
		produitRepository.save(new Produit("produit 3","produit3.png",1,879));
		produitRepository.save(new Produit("produit 4","produit4.png",1,321));
		produitRepository.findAll().forEach(produit -> {
		System.out.println(produit.toString());
		});
		*/
	}

}

