package com.idrissabarema.apifreetirage.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
