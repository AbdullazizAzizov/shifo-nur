package net.idrok.shifoxona.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.idrok.shifoxona.entity.Bino;
import net.idrok.shifoxona.repository.BinoRepository;

@Service
public class BinoService {
   
    BinoRepository binoRepository;
    
    public BinoService(BinoRepository binoRepository){
        this.binoRepository = binoRepository;
    }


    public Page<Bino> getAll(String key, Pageable pageable){
        return binoRepository.getAllWithKey(key, pageable);
    }
    public Bino create(Bino bino){
        if(bino.getId() == null){
       
            return binoRepository.save(bino);
        }
        throw new RuntimeException("bino id bo'lishi shart");
    }
    public Bino update(Bino bino){
        if(bino.getId() != null){
            return binoRepository.save(bino);
        }
        throw new RuntimeException("bino id bo'lishi shart");
    }

    public void deleteById(Long id){
        binoRepository.deleteById(id);
    }
    

}
