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
@CrossOrigin("http://localhost:4200")
@RequestMapping("/tirage")
public class TirageController {
    // DECLARATION DU SERVICE TIRAGE
    @Autowired
    final private TirageService tirageService;
    private final ListeService listeService;
    final private PostulantRepository postulantRepository;

    // DECLARATION DU SERVICE POSTULANT
    final private PostulantService postulantService;

    // DECLARATION DU SERVICE POSTULANT_TRIER
    final private Postulant_TriéService postulantTriéService;

    // METHODE PERMETTANT DE CREER LE POSTULANT DANS LE CONTROLLER

    @PostMapping("/creer_tirage/{libelle}")
    public String CreerTirage(@RequestBody Tirage tirage, Liste liste, @PathVariable("libelle") String libelle) {
        Liste l = listeService.findByLibellel(libelle);
        Long idList = l.getIdl();
        if (tirageService.trouverTirageParLibelle(tirage.getLibellel()) == null) {//verifie si la liste existe
            //APPEL DE LA METHODE CREER TIRAGE POUR CREER TIRAGE
            tirageService.CreerTirage(tirage);


            tirage.setIdliste(l);
            tirage.setDatet(new Date());


            // CREATION D'UN D'UN OBJET RANDOM POUR POUVOIR SELECTIONNER LES ELEMENT DE FACON ALEATOIR
            Random rand = new Random();
            List<Long> list = new ArrayList<>();

            //  for (int i = 0; i < tirage.getNbredemande(); i++) {
            // LA METHODE NEXTLONG RETOURNE DES VALEUR ALEATOIRE A CHAQUE ITERATION DE LA BOUCLE FOR

            List<Postulant> postl = postulantService.TrouverListPostParIdList(idList);
            for (Postulant p : postl) {
                list.add(p.getIdp());
            }
            System.out.println(list);

            Collections.shuffle(list);
            System.out.println(list);
            // long nbrAleatoire = rand.nextLong(postl.size());
            List<Postulant> listpostulant = new ArrayList<>();

            //cette variable va contenir les index choisi par random aleatoirement
            // List<Long> index = listeNomrbeAleatoire.add(index);

            for (int j = 1; j <= tirage.getNbredemande(); j++) {


                Long k = list.get(j);
                System.out.println(k);
                listpostulant.add(postulantService.TrouverPostulantId(k));
                postl.remove(postulantService.TrouverPostulantId(k));
            }
            //listpostulant.add(postulantService.TrouverPostulantId(k));



                    /*l'ajout de la valeur de l'index choisit aleatoirement
                    list.add(postl.get(index));
                    //suppression de la valeur choisi dans la liste à trier
                    postl.remove(postl.get(index));
                }*/

              /*  if (i != 0) {
                    long nbr = nbrAleatoire;
                }

                Boolean l1 = postulants.remove(nbrAleatoire);
                System.out.println(l1);*/

            //BOUCLE PERMETTANT DE PARCOURUT TOUS ELEMENT DE LA LISTE POSTULANT EN AFFECTTANT LES DONNEES DANS LA TABLE POSTULANT_TRIE
            for (Postulant p : listpostulant) {

                postulantTriéService.INSERERPOSTULANT(p.getNomp(), p.getPrenomp(), p.getNumerop(), p.getEmailp(), tirage.getIdt());

            }

            return "BRAVO SUCCES";
        } else {
            return "Cette liste existe déjà ";
        }
    }

    // METHODE PERMETTANT DE D'AFFICHER LA LISTE DU TIRAGE
    @GetMapping("/afficher")
    public List<Tirage> AfficherTirage() {
        return tirageService.AfficherTirage();
    }

    @GetMapping("/afficher/{id}")
    public List<Tirage> AfficherTirageParId(@PathVariable("id") long id) {
        return tirageService.trouverTirageParId(id);
    }

    @GetMapping("/afficherliste/{libelleliste}")
    public List<Tirage> AfficherTiragePar(@PathVariable("libelleliste") String libelleliste) {
        Liste liste = listeService.findByLibellel(libelleliste);
        return tirageService.trouverTirageParListeId(liste);
    }

    @GetMapping("/afficherNombreTirage/{id}")
    public int AfficherNombreTirage(@PathVariable("id") long id){
        return tirageService.trouverNombreTirageParId(id);
    }

    @GetMapping("/nombreDeTirageTotal")
    public int TrouverNombreTirage(){
        return tirageService.trouverDeNombreTirageTotal();
    }

    @GetMapping("/nombreTotalDeListeTire")
    public int TrouverNombreTotalDeListeTire(){
        return tirageService.trouverDeNombreTotalListeTire();
    }

    @GetMapping("/trouverTirageParLibelle/{Libelle}")
    public Tirage trouverTirageParLibellel(@PathVariable("Libelle") String libelle){
        return tirageService.trouverTirageParLibelle(libelle);
    }

    @GetMapping("/nombreTirageParListe")
    public List<Object> nombreTirageParListe(){
        return tirageService.trouverTirageParListe();
    }
    /*
    @GetMapping("/trouverTirageParLibelle/{libelle}")
    public Tirage trouverTirageParLibelle(@PathVariable("libelle") String libelle){
        return tirageService.trouverTirageParLibelle(libelle);
    }*/


}
