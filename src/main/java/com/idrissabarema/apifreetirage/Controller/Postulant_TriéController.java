package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Service.Postulant_TriéService;
import com.idrissabarema.apifreetirage.Service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/postulant_trie")
public class Postulant_TriéController {

    @Autowired
    final private Postulant_TriéService postulantTriéService;
    final private TirageService tirageService;

    //METHODE PERMETTANT D'AFFICHER LE POSTULANTTRIE
    @GetMapping("/afficher_postulant_trie")
    public List<Postulant_Trié> AfficherPostulantTrie(){
        return postulantTriéService.AfficherPostulant_Trié();
    }

    //METTODE PERMETTANT DE TROUVER LES POSTULANT TIRE PAR TIRAGE
    @GetMapping("/afficherPostulantTireParTirage/{libelletirage}")
    public List<Postulant_Trié> AfficherPostulantTireParId(@PathVariable("libelletirage") String libelletirage){

        Tirage tirage =  this.tirageService.trouverTirageParLibelle(libelletirage);
        return postulantTriéService.trouverPostulantTireParId(tirage);
    }


}
