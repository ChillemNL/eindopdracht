package com.leergang.eindopdracht.repositories;

import com.leergang.eindopdracht.models.Activiteit;
import com.leergang.eindopdracht.models.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
    @Query(value="SELECT id, naam_categorie, beschrijving_categorie FROM categorie ORDER BY naam_categorie ASC",nativeQuery=true)
    List<Categorie> findAllOrderByNaamCategorieAsc();

    boolean existsByNaamCategorie(String naam_categorie);

    @Query(value="SELECT id, naam_categorie, beschrijving_categorie FROM categorie WHERE naam_categorie = :categorie",nativeQuery=true)
    List<Categorie> findByName(@Param("categorie")String naam_categorie);

}
