package com.my.web_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.my.web_api.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT e FROM USER e JOIN FETCH e.roles WHERE e.id_user = (:id_user)")
    public Usuario findByUsername(@Param("id_user") String id_user);
}
