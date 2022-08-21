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
    private long idp;
    private String nomp;
    private String prenomp;
    private String numerop;
    private String emailp;

    //Jointure entre la table postulant et la table liste
    @ManyToOne
    @JoinColumn(name = "idlist")
    private Liste idliste;

}
