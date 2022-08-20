package com.idrissabarema.apifreetirage.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Postulant
    private int id_p;
    private String nom_p;
    private String prenom_p;
    private String numero_p;
    private String email_p;

    //Jointure entre la table postulant et la table liste
    @ManyToOne
    @JoinColumn(name = "idlist")
    private Liste idliste;

}
