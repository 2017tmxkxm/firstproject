package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PizzaDto {
    private Long id;
    private String name;
    private String price;

    public static PizzaDto createPizzaDto(Pizza created) {
        return new PizzaDto(
                created.getId()
                , created.getName()
                , created.getPrice()
        );
    }
}
