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
    private long idpt;
    private String nompt;
    private String prenompt;
    private String numeropt;
    private String emailpt;
    // Jointure entre la table postulant_trie et Tirage
    @ManyToOne
    @JoinColumn(name = "idtirage")
    private Tirage idtirage;
}
