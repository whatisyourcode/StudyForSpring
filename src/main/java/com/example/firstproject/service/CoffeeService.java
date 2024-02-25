package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Iterable<Coffee> index(){
        return coffeeRepository.findAll();
    }
    public Coffee show(Long id){
        return coffeeRepository.findById(id).orElse(null);
    }
    public Coffee create(CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        log.info("check: {} ", coffee.toString());
        if (coffee.getId() != null){
            return null;
        }
        Coffee created = coffeeRepository.save(coffee);
        return created;
    }
    public Coffee update(Long id, CoffeeForm dto) {
        Coffee coffee = dto.toEntity();     // 수정할 내용
        log.info("id: {}, coffee: {} ", id,coffee.toString());
        Coffee target = coffeeRepository.findById(id).orElse(null); // 기존 내용
        if(target == null || id != coffee.getId()){  // 기존 내용이 null 인경우 || 요청한 Url id와 json id가 다른 경우
            return null;
        }
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return updated;
    }
    public Coffee delete(Long id){
        Coffee target = coffeeRepository.
                findById(id).
                orElse(null);
        if(target == null){
            return null;
        }
        coffeeRepository.delete(target);
        return target;
    }
    @Transactional
    public List<Coffee> createArticles(List<CoffeeForm> dtos) {
        // 1. dto 묶음을 엔티티로 변환하기
        List<Coffee> coffeeList = dtos.stream().
                map(dto -> dto.toEntity()).
                collect(Collectors.toList());
        // 2. 엔티티 묶음을 DB에 저장하기
        coffeeList.stream().
                forEach( coffee -> coffeeRepository.save(coffee));
        // 3. 강제 예외 발생시키기
        coffeeRepository.findById(-1L).
                orElseThrow(() -> new IllegalArgumentException("결제 실패"));
        // 4. 결과 값 반환하기
        return coffeeList;
    }
}
