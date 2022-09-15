package com.idrissabarema.apifreetirage.Controller;


import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Service.ListeService;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/liste")
public class ListeController {
    @Autowired
    final private ListeService listeService;

    @PostMapping("/creer")
    public Liste CreerListe(@RequestBody Liste liste){
        return listeService.CreerListe(liste);
    }
    @GetMapping("/afficher")
    public Iterable<Object[]>  AfficherListe(){
        return listeService.AfficherListe();
    }
    @GetMapping("/Afficher")
    public List<Liste> afficherListe(){
        return listeService.afficerListe();
    }

    @GetMapping("/recuper_par_id/{id}")
    public List<Liste> afficherListeParId(@PathVariable("id") long id){
        return listeService.afficerListeParId(id);
    }

    @GetMapping("/nombreTotalListe")
    public int trouverNombreTotalListe(){
        return listeService.nombreTotalListe();
    }

    @GetMapping("/trouverListeParLibelle/{libelle}")
    public Liste TrouverListeParLibelle(@PathVariable("libelle") String libelle){
        return listeService.findByLibellel(libelle);
    }

    @GetMapping("/trouverListeParLibelleTirage/{libelle}")
    public List<Object> trouverLibelleListe(@PathVariable("libelle") String libelle)
    {
        return this.listeService.trouverListeParLibelle(libelle);
    }


}
