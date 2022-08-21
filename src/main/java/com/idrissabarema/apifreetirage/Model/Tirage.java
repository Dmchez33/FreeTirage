package com.idrissabarema.apifreetirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Creation des attributs dans l'entite Tirage
    private long idt;
    private Date datet;
    private String libellel;
    private int nbredemande;

    //tirage entre tirage et la liste
    @ManyToOne
    @JoinColumn(name = "idliste")
    private Liste idliste;
}
