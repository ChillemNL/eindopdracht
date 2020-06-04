package com.leergang.eindopdracht.repositories;

import com.leergang.eindopdracht.models.Activiteit;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActiviteitRepository extends CrudRepository<Activiteit, Integer> {

    List<Activiteit> findBycategorieId(Integer categorieId);

    @Query(value="SELECT * FROM activiteit ORDER BY naam_activiteit, naam_organisatie",nativeQuery=true)
    List<Activiteit> findAllNaamActiviteitSortAsc();

}
