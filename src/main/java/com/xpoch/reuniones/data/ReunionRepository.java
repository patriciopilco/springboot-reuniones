package com.xpoch.reuniones.data;

import com.xpoch.reuniones.models.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reuniones")
public interface ReunionRepository extends JpaRepository<Reunion, Long> {

}
