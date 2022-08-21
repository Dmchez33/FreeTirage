package com.idrissabarema.apifreetirage.Controller;


import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Service.ListeService;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import com.idrissabarema.apifreetirage.Service.PostulantServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/postulant")
public class PostulantController {

    @Autowired
    final private PostulantService postulantService;

    private  final ListeService listeService;

    // METHODE PERMETTANT DE CREER UN POSTULANT DANS LE CONTROLLER
    @PostMapping("/ajoute_postulant/{libellel}")
    String AjouterPostulant(@Param("file") MultipartFile file, Liste liste, String libellel){


        //IMPLEMENTATION DE LA METHODE DANS LE CONTROLLER
       ArrayList<Postulant> importer = postulantService.INSERPostulant(file);

       // AFFECTATION DE LA DATE A LA LISTE
       liste.setDatel(new Date());

       // CREATION D'UNE LISTE
       Liste l = listeService.CreerListe(liste);

       //BOUCLE PERMETTANT DE PARCOURUT LES POSTULANT DANS LE FICHIER ET AFFECTER L'ID DE LA LISTE
       for (Postulant p: importer)
       {
         p.setIdliste(l);
         postulantService.creerPostulant(p);
       }

       return "import avec succes";
    }

    // METHODE PERMETTANT D AFFICHER LES POSTULANT DANS LE
    @GetMapping("/afficher-postulant")
    public List<Postulant> Afficher_Postulant(){

        return postulantService.Afficher_Postulant();

    }

}
