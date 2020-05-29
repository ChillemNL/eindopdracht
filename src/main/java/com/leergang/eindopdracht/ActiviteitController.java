package com.leergang.eindopdracht;

import com.leergang.eindopdracht.models.Activiteit;
import com.leergang.eindopdracht.repositories.ActiviteitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

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
        activiteit.setNaamOrganisatie(request.getNaamOrganisatie());
        activiteit.setAdres(request.getAdres());
        activiteit.setPostcode(request.getPostcode());
        activiteit.setPlaats(request.getPlaats());
        activiteit.setTelefoonnummer(request.getTelefoonnummer());
        activiteit.setNaamActiviteit(request.getNaamActiviteit());
        activiteit.setBeschrijvingActiviteit(request.getBeschrijvingActiviteit());
        activiteit.setKosten(request.getKosten());
        activiteit.setLeeftijdscategorie(request.getLeeftijdscategorie());
        activiteit.setSoortActiviteit(request.getSoortActiviteit());
        activiteit.setWebsite(request.getWebsite());
        activiteitRepository.save(activiteit);
        return "resultaat";
    }

    //@GetMapping("/activiteit_aanpassen/{id}")
    //public String aanpassenFormulier(Model model, @PathVariable String id) {
     //   Optional<Activiteit> activiteitRepository.findById(Integer.parseInt(id));
     //   return "activiteit_aanpassen";
    //}

    @PostMapping("activiteit_aanpassen")
    public String activiteitAanpassen(@ModelAttribute ActiviteitRequest request) {
        return"resultaat";
    }
}
