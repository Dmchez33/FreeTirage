package com.idrissabarema.apifreetirage.Controller;

import com.idrissabarema.apifreetirage.Model.Liste;
import com.idrissabarema.apifreetirage.Model.Postulant;
import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import com.idrissabarema.apifreetirage.Repository.PostulantRepository;
import com.idrissabarema.apifreetirage.Service.ListeService;
import com.idrissabarema.apifreetirage.Service.PostulantService;
import com.idrissabarema.apifreetirage.Service.Postulant_TriéService;
import com.idrissabarema.apifreetirage.Service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/tirage")
public class TirageController {

    // DECLARATION DU SERVICE TIRAGE
    @Autowired
    final private TirageService tirageService;
    private  final ListeService listeService;
    final private PostulantRepository postulantRepository;

    // DECLARATION DU SERVICE POSTULANT
    final private PostulantService postulantService;

    // DECLARATION DU SERVICE POSTULANT_TRIER
    final private Postulant_TriéService postulantTriéService;

    // METHODE PERMETTANT DE CREER LE POSTULANT DANS LE CONTROLLER
    @PostMapping("/creer_tirage/{libelle}")
    public String CreerTirage(@RequestBody Tirage tirage, Liste liste,@PathVariable("libelle") String libelle){
        //recuperation de la liste par son libelle
        Liste l = listeService.findByLibellel(libelle);
        //recuperation de l'id du liste recuperer
        Long idList= l.getIdl();
        if(tirageService.trouverTirageParLibelle(tirage.getLibellel()) == null) {//verifie si la liste existe
            //APPEL DE LA METHODE CREER TIRAGE POUR CREER TIRAGE
            tirageService.CreerTirage(tirage);

            tirage.setIdliste(l);
            tirage.setDatet(new Date());

            // UNE VARIABLE LISTE QUI VA CONTENIR L 'ID DES POSTULANT
            List<Long> list = new ArrayList<>();

            // VARIABLE QUI VA CONTENIR LA LISTE DES POSTULANT PAR IDLISTE
            List<Postulant> postl = postulantService.TrouverListPostParIdList(idList);

            // BOUCLE PERMETTANT DE PARCOURUT LES POSTULANTS TROUVES PAR IDLISTE EN STOCKANT LEUR ID LA VARIABLE LISTE
            for (Postulant p: postl){
                list.add(p.getIdp());
            }

            // METHODE PERMETTANT DE MELANGER LES ID QUI SE TROUVE DANS LA VARIABLE LISTE
            Collections.shuffle(list);

            // UNE VARIABLE LISTEPOSTULANT QUI VA CONTENIR LES POSTULANTS TROUVER PAR ID
            List<Postulant> listpostulant = new ArrayList<>();

            // BOUCLE PERMETTANT D'EFFECTUER LE TIRAGE
            for (int j = 1; j <= tirage.getNbredemande(); j++) {

                // VARIABLE CONTENANT L'ID DU POSTULANT QUI SE TROUVE DANS LA LISTE
                Long k = list.get(j);

                // AJOUT DU POSTULANT DANS LA VARIABLE LISTPOSTULANT A CHAQUE ITERATION
                listpostulant.add(postulantService.TrouverPostulantId(k));

            }

            //BOUCLE PERMETTANT DE PARCOURUT TOUS ELEMENT DE LA LISTE POSTULANT EN AFFECTTANT LES DONNEES DANS LA TABLE POSTULANT_TRIE
            for (Postulant p : listpostulant) {

                postulantTriéService.INSERERPOSTULANT(p.getNomp(), p.getPrenomp(), p.getNumerop(), p.getEmailp(), tirage.getIdt());

            }

            return "BRAVO TIRAGE EFFECTUER AVEC SUCCES !";
        }else{
            return "LA LISTE EXISTE DEJA !";
        }



    }

    // METHODE PERMETTANT DE D'AFFICHER LA LISTE DU TIRAGE
    @GetMapping("/afficher")
    public List<Tirage> AfficherTirage(){
        return tirageService.AfficherTirage();
    }

}
