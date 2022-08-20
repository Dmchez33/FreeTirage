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

    @PostMapping("/ajoute_postulant/{libelle_l}")
    String AjouterPostulant(@Param("file")MultipartFile file, Liste liste, String libelle_l){

       //PostulantServiceImplement importer= new PostulantServiceImplement();
        //IMPLEMENTATION DE LA METHODE DANS LE CONTROLLER
       ArrayList<Postulant> importer= postulantService.INSERPostulant(file);
       liste.setDate_l(new Date());
       Liste l = listeService.CreerListe(liste);

       for (Postulant p: importer)
       {
         p.setIdliste(l);
         postulantService.creerPostulant(p);
       }

       return "import avec succes";
    }
    @GetMapping("/afficher-postulant")
    public Iterable<Object[]> Afficher_Postulant(){
        return postulantService.Afficher_Postulant();
    }

}
