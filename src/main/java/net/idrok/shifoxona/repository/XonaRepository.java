package net.idrok.shifoxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.idrok.shifoxona.entity.Bino;
import net.idrok.shifoxona.entity.Xona;

@Repository
public interface XonaRepository extends JpaRepository<Xona, Long> {
    
}
