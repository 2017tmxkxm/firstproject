package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/api/pizza")
    public List<Pizza> index() {
        return pizzaService.index();
    }

    @GetMapping("/api/pizza/{id}")
    public Pizza show(@PathVariable Long id) {
        return pizzaService.show(id);
    }

    @PostMapping("/api/pizza")
    public ResponseEntity<PizzaDto> create(@RequestBody PizzaDto dto) {
        PizzaDto createDto = pizzaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDto);
    }

    @PatchMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDto> update(@RequestBody PizzaDto dto, @PathVariable Long id) {
        PizzaDto updated = pizzaService.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long id) {
        PizzaDto deleted = pizzaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

}
