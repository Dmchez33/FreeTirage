package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import com.idrissabarema.apifreetirage.Service.Postulant_TriéService;
import com.idrissabarema.apifreetirage.Service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
@RequestMapping("/tirage")
public class TirageController {

    // DECLARATION DU SERVICE TIRAGE
    @Autowired
    final private TirageService tirageService;

    // DECLARATION DU SERVICE POSTULANT
    final private PostulantService postulantService;

    // DECLARATION DU SERVICE POSTULANT_TRIER
    final private Postulant_TriéService postulantTriéService;

    // METHODE PERMETTANT DE CREER LE POSTULANT DANS LE CONTROLLER
    @PostMapping("/creer_tirage")
    public String CreerTirage(@RequestBody Tirage tirage){

        //APPEL DE LA METHODE CREER TIRAGE POUR CREER TIRAGE
        tirageService.CreerTirage(tirage);

        // CREATION D'UN D'UN OBJET RANDOM POUR POUVOIR SELECTIONNER LES ELEMENT DE FACON ALEATOIR
        Random rand = new Random();

        for (int i=0; i<tirage.getNbredemande(); i++){
            // LA METHODE NEXTLONG RETOURNE DES VALEUR ALEATOIRE A CHAQUE ITERATION DE LA BOUCLE FOR
            long nbrAleatoire = rand.nextLong(postulantService.NombrePostulant());

            //BOUCLE PERMETTANT DE VERIFIER SI LE NOMBRE ALEATOIR RETOURNER N'EST PAS EGALE A ZERO CAR NOS ID NE SON JAMAIS ZERO
            while (nbrAleatoire == 0)
            {
                nbrAleatoire = rand.nextLong(postulantService.NombrePostulant());
            }

            // DECLARATION D'UNE VARIABLE CONTENANT LA LISTE DES POSTULANT
            List<Postulant> postulants = postulantService.TrouverPostulantId(nbrAleatoire);

            //BOUCLE PERMETTANT DE PARCOURUT TOUS ELEMENT DE LA LISTE POSTULANT EN AFFECTTANT LES DONNEES DANS LA TABLE POSTULANT_TRIE
            for (Postulant p : postulants){

                postulantTriéService.INSERERPOSTULANT(p.getNomp(),p.getPrenomp(),p.getNumerop(),p.getEmailp(),tirage.getIdt());
            }
            if (i !=  0)
            {
                long nbr = nbrAleatoire;
            }

            Boolean l =  postulants.remove(nbrAleatoire);
            System.out.println(l);
        }
        return "BRAVO SUCCES";


    }

    // METHODE PERMETTANT DE D'AFFICHER LA LISTE DU TIRAGE
    @GetMapping("afficher")
    public List<Tirage> AfficherTirage(){
        return tirageService.AfficherTirage();
    }

}
