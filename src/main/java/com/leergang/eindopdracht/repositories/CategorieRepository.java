package com.leergang.eindopdracht.repositories;

import com.leergang.eindopdracht.models.Activiteit;
import com.leergang.eindopdracht.models.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
    @Query(value="SELECT id, naam_categorie, beschrijving_categorie FROM categorie ORDER BY naam_categorie ASC",nativeQuery=true)
    List<Categorie> findAllOrderByNaamCategorieAsc();
}
