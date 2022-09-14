package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Postulant_Trié;
import com.idrissabarema.apifreetirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface Postulant_TriéRepository extends JpaRepository<Postulant_Trié,Long> {

    //REQUETTE PERMETTANT DE REMPLIR LA TABLE POSTULANT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_trié(nompt,prenompt,numeropt,emailpt, idtirage) values(:nom,:prenom,:numero,:email, :idtirage);",nativeQuery = true)
    int INSERTPOSTULANTTRIE(String nom, String prenom, String numero, String email, long idtirage);

    List<Postulant_Trié> findByIdtirage(Tirage tirage);
}
