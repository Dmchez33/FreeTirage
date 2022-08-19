package com.idrissabarema.apifreetirage.Repository;

import com.idrissabarema.apifreetirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepository extends JpaRepository<Tirage, Long> {
}
