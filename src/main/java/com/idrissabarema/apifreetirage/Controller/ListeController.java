package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Service.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/liste")
@AllArgsConstructor
public class ListeController {
    //DECLARATION D'UN SERVICE
    /*@Autowired
    final private ListeService listeService;

    // Methode permettant de sauvegarder les donnees
    @PostMapping("ajouter_liste")
    Liste CreerListe(Liste liste){
        return listeService.CreerListe(liste);
    }

    @GetMapping("afficher_liste")
    List<Liste> AfficherListe(){
        return listeService.AfficherListe();
    }*/
}
