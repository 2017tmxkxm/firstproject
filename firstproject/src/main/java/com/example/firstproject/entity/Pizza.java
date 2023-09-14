package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public static Pizza createPizza(PizzaDto dto) {
        if(dto.getId() != null) {
            throw new IllegalArgumentException("피자 생성 실패, id가 있으면 안됩니다.");
        }
        return new Pizza(
                dto.getId()
                , dto.getName()
                , dto.getPrice()
        );
    }

    public void patch(PizzaDto dto) {
        if(this.id != dto.getId()) {
            throw  new IllegalArgumentException("수정 실패, id가 동일하지 않습니다.");
        }
        if(dto.getName() != null) {
            this.name = dto.getName();
        }
        if(dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}
