package net.idrok.shifoxona.controller;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.shifoxona.entity.Bino;
import net.idrok.shifoxona.service.BinoService;


@RestController
@RequestMapping("/api/bino")
@CrossOrigin(value = "*", maxAge = 3600)
public class BinoController {
    
   
    BinoService binoService;

    public BinoController(BinoService binoService){
        this.binoService = binoService;
    }

    @GetMapping
    public ResponseEntity<Page<Bino>>getAll(@RequestParam(value = "key", required = false) String key, Pageable pageable,
                                             HttpServletRequest request,
                                             HttpServletResponse response,
                                             @RequestHeader(value = "ism", required = false) String ism 
                                             ){
//        Iterator<String> it = request.getHeaderNames().asIterator();
//        while( it.hasNext()){
//            String k = it.next();
//            System.out.println(k + ": " + request.getHeader(k));
//        }
//        response.setHeader("familya", "Jabborov");


//        Cookie [] mas = request.getCookies();
//        for(Cookie c: mas) {
//
//        }

        //yozish
//        Cookie cookie = new Cookie("ism", "AxadQayum");
//        cookie.setMaxAge(10*1000);
//        response.addCookie(cookie);
//        return BinoService.getAll(key);


         if(key == null) key = "";
        return ResponseEntity.ok(binoService.getAll(key, pageable));
    }

    @PostMapping
    public ResponseEntity<Bino> create(@RequestBody  Bino bino){
        try{
            Bino b = binoService.create(bino);
            return ResponseEntity.created(URI.create("/api/bino/" + b.getId())).body(b);
        } catch(Exception ex){
            return ResponseEntity.badRequest().build();
        }
        
    }
    @PutMapping
    public Bino update(@RequestBody  Bino bino){
        return binoService.update(bino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
       try{
           binoService.deleteById(id);
           return ResponseEntity.noContent().build();
       } catch(Exception ex){
            return ResponseEntity.notFound().header("error", "Bunday id li bino topilmadi").build();
       }
        
    }

}
