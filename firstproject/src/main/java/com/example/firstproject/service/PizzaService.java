package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("피자 출력 불가, id가 없습니다."));
        return target;
    }

    public PizzaDto create(PizzaDto dto) {
        Pizza pizza = Pizza.createPizza(dto);
        Pizza created = pizzaRepository.save(pizza);
        return PizzaDto.createPizzaDto(created);
    }

    public PizzaDto update(PizzaDto dto, Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("피자 출력 불가, 해당 피자가 없습니다."));
        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);
        return PizzaDto.createPizzaDto(updated);
    }

    public PizzaDto delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제 출가, 해당 피자가 없습니다."));
        pizzaRepository.delete(target);
        return PizzaDto.createPizzaDto(target);
    }
}
