package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant,Long> {

    // INSERTION DE POSTULANT DANS LA BASE DE DONNEE
    @Modifying
    @Transactional
    @Query(value = "insert into postulant(nom_p,prenom_p,email_p,numero_p) values (:nom,:prenom,:email,:numero);", nativeQuery = true)
    public int INSERTPOSTULANT(@Param("nom") String nom, @Param("prenom") String prenom, @Param("email") String email, @Param("numero") String numero);//@param fait reference parametre à afficher



}
