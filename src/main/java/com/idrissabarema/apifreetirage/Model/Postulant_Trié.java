package com.idrissabarema.apifreetirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Postulant_Trié {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Postulant
    private int id_pt;
    private String nom_pt;
    private String prenom_pt;
    private String numero_pt;
    private String email_pt;
    // Jointure entre la table postulant_trie et Tirage
    @ManyToOne
    @JoinColumn(name = "idtirage")
    private Tirage idtirage;
}
