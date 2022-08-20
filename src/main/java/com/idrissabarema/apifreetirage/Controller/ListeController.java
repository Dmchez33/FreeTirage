package com.idrissabarema.apifreetirage.Controller;


import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Service.ListeService;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
