package net.idrok.shifoxona.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.idrok.shifoxona.entity.Bino;

@Repository
public interface BinoRepository extends JpaRepository<Bino, Long> {

   
    Page<Bino> findAll(Pageable pageable); 

    List<Bino> findAllByNomContainingIgnoreCaseOrInfoContainingIgnoreCaseOrderById(String key, String key2);
    List<Bino> findAllByNomContaining(String nom);
  

    @Query("FROM Bino b WHERE UPPER(b.nom) like '%' || UPPER(:key) || '%' or UPPER(b.info) like '%' || UPPER(:key) || '%'")
    Page<Bino> getAllWithKey(@Param("key") String key, Pageable pageable);


}
