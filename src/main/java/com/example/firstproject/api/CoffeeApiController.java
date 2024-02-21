package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;
    // GET
    @GetMapping("/api/coffees")
    public Iterable<Coffee> index(){
        return coffeeRepository.findAll();
    }
    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id){
        Coffee coffee = coffeeRepository.findById(id).orElse(null);
        return ( coffee == null) ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null) :
                ResponseEntity.status(HttpStatus.OK).body(coffee);
    }
    // POST
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        log.info("check: {} ", coffee.toString());
        if (coffee.getId() != null){ // id값을 포함하여 json 파일로 request하면 에러남.
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST).
                    body(null);
        }
        Coffee created = coffeeRepository.save(coffee);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(created);
    }
    // PATCH
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto){
        Coffee coffee = dto.toEntity();     // 수정할 내용
        log.info("id: {}, coffee: {} ", id,coffee.toString());
        Coffee target = coffeeRepository.findById(id).orElse(null); // 기존 내용
        if(target == null || id != coffee.getId()){  // 기존 내용이 null 인경우 || 요청한 Url id와 json id가 다른 경우
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST).
                    body(null);
        }
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(updated);
    }
    // DELETE
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id){
        Coffee target = coffeeRepository.
                findById(id).
                orElse(null);
        if(target == null){
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST).
                    body(null);
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).
                build();
    }

}
