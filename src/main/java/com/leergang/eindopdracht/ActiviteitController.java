package com.leergang.eindopdracht;

import com.leergang.eindopdracht.models.Activiteit;

import com.leergang.eindopdracht.repositories.ActiviteitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ActiviteitController {

    @Autowired
    private ActiviteitRepository activiteitRepository;

    @GetMapping("/")
    public String foo() {
        return "index";
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
        return activiteitRepository.findAll();
    }

    @GetMapping("/activieit_ophalen_per_categorie/{id}")
    @ResponseBody public  Iterable<Activiteit> getActivities(@PathVariable("id") Integer id){return activiteitRepository.findBycategorieId(id);}
}
