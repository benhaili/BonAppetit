package org.sid.service;

import java.util.List;

import org.sid.dao.CommandeRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Commande;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	
	@GetMapping(value ="/listCommandes")
	public List<Commande> listCommande(){
		return commandeRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/listCommandes")
	public Commande save(@RequestBody Commande cmd){
		return commandeRepository.save(cmd);
	}

}
