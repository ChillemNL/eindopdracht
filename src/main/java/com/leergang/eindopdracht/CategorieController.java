package com.leergang.eindopdracht;

import com.leergang.eindopdracht.models.Categorie;
import com.leergang.eindopdracht.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping(path="categorie")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/toevoegen")
    public String categorieFormulier(Model model) {
        model.addAttribute("categorie", new CategorieRequest());
        return "categorie_toevoegen";
    }

    @PostMapping("toevoegen")
    @ResponseStatus(value = HttpStatus.OK)
    public void categorieToevoegen(@ModelAttribute CategorieRequest request) {
        Categorie categorie = new Categorie();
        categorie.setNaamCategorie(request.getNaamCategorie());
        categorie.setBeschrijvingCategorie(request.getBeschrijvingCategorie());
        categorieRepository.save(categorie);
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Categorie> getAllCategories() {
        return categorieRepository.findAllOrderByNaamCategorieAsc();
    }

    @GetMapping(path = "/controle/{naam}")
    public @ResponseBody boolean checkCategorie(@PathVariable("naam") String naam){
        return categorieRepository.existsByNaamCategorie(naam);
    }

}
