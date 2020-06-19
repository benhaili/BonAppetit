package org.sid.service;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	@GetMapping(value ="/listProduits")
	public List<Produit> listProduit(){
		return produitRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/listProduits")
	public Produit save(@RequestBody Produit p){
		return produitRepository.save(p);
	}
}
