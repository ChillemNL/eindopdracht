package com.leergang.eindopdracht;

import com.leergang.eindopdracht.models.Categorie;
import com.leergang.eindopdracht.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categorie_toevoegen")
    public String categorieFormulier(Model model) {
        model.addAttribute("categorie", new CategorieRequest());
        return "categorie_toevoegen";
    }

    @PostMapping("categorie_toevoegen")
    public String categorieToevoegen(@ModelAttribute CategorieRequest request) {
        Categorie categorie = new Categorie();
        categorie.setNaamCategorie(request.getNaamCategorie());
        categorie.setBeschrijvingCategorie(request.getBeschrijvingCategorie());
        categorieRepository.save(categorie);
        return "categorie_resultaat";
    }

    @GetMapping(path = "/categories")
    public @ResponseBody Iterable<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }


}
