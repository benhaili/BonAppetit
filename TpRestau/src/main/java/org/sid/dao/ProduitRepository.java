package org.sid.dao;

import org.sid.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RepositoryRestResource

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
