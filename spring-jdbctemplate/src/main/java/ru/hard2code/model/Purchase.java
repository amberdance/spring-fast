package ru.hard2code.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private Long id;
    private BigDecimal price;
    private String product;

}
