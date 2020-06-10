package com.leergang.eindopdracht;

import com.leergang.eindopdracht.models.Activiteit;

import com.leergang.eindopdracht.repositories.ActiviteitRepository;
import com.leergang.eindopdracht.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.leergang.eindopdracht.models.Categorie;

import java.util.Optional;

import java.util.List;

@Controller
public class ActiviteitController {

    @Autowired
    private ActiviteitRepository activiteitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/beheer_portaal")
    public String beheerPortaal(){
        return "beheer_portaal";
    }

    @GetMapping("/activiteit_toevoegen")
    public String activiteitFormulier(Model model) {
        model.addAttribute("activiteit", new ActiviteitRequest());
        return "activiteit_toevoegen";
    }

    @PostMapping("activiteit_toevoegen")
    public String activiteitToevoegen(@ModelAttribute ActiviteitRequest request) {
        Activiteit activiteit = new Activiteit();
        activiteit.setCategorieId(request.getCategorieId());
        activiteit.setNaamOrganisatie(request.getNaamOrganisatie());
        activiteit.setPlaats(request.getPlaats());
        activiteit.setRegio(request.getRegio());
        activiteit.setNaamActiviteit(request.getNaamActiviteit());
        activiteit.setBeschrijvingActiviteit(request.getBeschrijvingActiviteit());
        activiteit.setKosten(request.getKosten());
        activiteit.setLeeftijdscategorie(request.getLeeftijdscategorie());
        activiteit.setSoortActiviteit(request.getSoortActiviteit());
        activiteit.setWebsite(request.getWebsite());
        activiteitRepository.save(activiteit);
        return "resultaat";
    }

    @GetMapping("/activiteit_ophalen")
    public @ResponseBody Iterable<Activiteit> getAllActivities() {
        return activiteitRepository.findAllNaamActiviteitSortAsc();
    }

    @GetMapping("/activieit_ophalen_per_categorie/{id}")
    @ResponseBody public  Iterable<Activiteit> getActivities(@PathVariable("id") Integer id){return activiteitRepository.findBycategorieId(id);}

    @GetMapping("activiteit_aanpassen/{id}")
    public String aanpassenFormulier(Model model, @PathVariable String id) {
        Iterable<Categorie> categories = categorieRepository.findAll();
        model.addAttribute("categories", categories);

        Optional<Activiteit> query = activiteitRepository.findById(Integer.parseInt(id));
        if (query.isPresent()){
            Activiteit activiteit = query.get();
            model.addAttribute("activiteit", activiteit);
            return "activiteit_aanpassen";
        }
        return "resultaat";
    }

    @PostMapping("activiteit_aanpassen/{id}")
    public String activiteitAanpassen(@ModelAttribute ActiviteitRequest request, @PathVariable String id) {
        Optional<Activiteit> query = activiteitRepository.findById(Integer.parseInt(id));
       if (query.isPresent()) {
           Activiteit activiteit = query.get();
           activiteit.setCategorieId(request.getCategorieId());
           activiteit.setNaamOrganisatie(request.getNaamOrganisatie());
           activiteit.setPlaats(request.getPlaats());
           activiteit.setRegio(request.getRegio());
           activiteit.setNaamActiviteit(request.getNaamActiviteit());
           activiteit.setBeschrijvingActiviteit(request.getBeschrijvingActiviteit());
           activiteit.setKosten(request.getKosten());
           activiteit.setLeeftijdscategorie(request.getLeeftijdscategorie());
           activiteit.setSoortActiviteit(request.getSoortActiviteit());
           activiteit.setWebsite(request.getWebsite());
           activiteitRepository.save(activiteit);
       }
        return "resultaat";
    }

    @DeleteMapping(value="activiteit_verwijderen/{id}")
    public ResponseEntity<Void> deleteActiviteit(@PathVariable("id") Integer id){
        activiteitRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}


