package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public void patch(Coffee coffeeEntity) {
        if(coffeeEntity.name != null) {
            this.name = coffeeEntity.name;
        }
        if(coffeeEntity.price != null) {
            this.price = coffeeEntity.price;
        }
    }
}
