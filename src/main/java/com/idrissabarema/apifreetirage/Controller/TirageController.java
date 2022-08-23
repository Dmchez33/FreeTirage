package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Service.ListeService;
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
    private  final ListeService listeService;

    // DECLARATION DU SERVICE POSTULANT
    final private PostulantService postulantService;

    // DECLARATION DU SERVICE POSTULANT_TRIER
    final private Postulant_TriéService postulantTriéService;

    // METHODE PERMETTANT DE CREER LE POSTULANT DANS LE CONTROLLER
    @PostMapping("/creer_tirage/{libelle}")
    public String CreerTirage(@RequestBody Tirage tirage, Liste liste,@PathVariable("libelle") String libelle){
        Liste l = listeService.findByLibellel(libelle);
        if(tirageService.trouverTirageParLibelle(tirage.getLibellel()) == null) {//verifie si la liste existe
            //APPEL DE LA METHODE CREER TIRAGE POUR CREER TIRAGE
            tirageService.CreerTirage(tirage);


            tirage.setIdliste(l);


            // CREATION D'UN D'UN OBJET RANDOM POUR POUVOIR SELECTIONNER LES ELEMENT DE FACON ALEATOIR
            Random rand = new Random();

            for (int i = 0; i < tirage.getNbredemande(); i++) {
                // LA METHODE NEXTLONG RETOURNE DES VALEUR ALEATOIRE A CHAQUE ITERATION DE LA BOUCLE FOR
                long nbrAleatoire = rand.nextLong(postulantService.NombrePostulant());
                ArrayList<Integer> listeNomrbeAleatoire = new ArrayList<>();

                //BOUCLE PERMETTANT DE VERIFIER SI LE NOMBRE ALEATOIR RETOURNER N'EST PAS EGALE A ZERO CAR NOS ID NE SON JAMAIS ZERO
                while (nbrAleatoire == 0 || listeNomrbeAleatoire.contains(nbrAleatoire)) {
                    nbrAleatoire = rand.nextLong(postulantService.NombrePostulant());
                }
                listeNomrbeAleatoire.add((int) nbrAleatoire);
                // DECLARATION D'UNE VARIABLE CONTENANT LA LISTE DES POSTULANT
                List<Postulant> postulants = postulantService.TrouverPostulantId(nbrAleatoire);

                if (i != 0) {
                    long nbr = nbrAleatoire;
                }

                Boolean l1 = postulants.remove(nbrAleatoire);
                System.out.println(l1);

                //BOUCLE PERMETTANT DE PARCOURUT TOUS ELEMENT DE LA LISTE POSTULANT EN AFFECTTANT LES DONNEES DANS LA TABLE POSTULANT_TRIE
                for (Postulant p : postulants) {

                    postulantTriéService.INSERERPOSTULANT(p.getNomp(), p.getPrenomp(), p.getNumerop(), p.getEmailp(), tirage.getIdt());
                }

            }
            return "BRAVO SUCCES";
        }else{
            return "Cette liste existe déjà";
        }



    }

    // METHODE PERMETTANT DE D'AFFICHER LA LISTE DU TIRAGE
    @GetMapping("afficher")
    public List<Tirage> AfficherTirage(){
        return tirageService.AfficherTirage();
    }

}
