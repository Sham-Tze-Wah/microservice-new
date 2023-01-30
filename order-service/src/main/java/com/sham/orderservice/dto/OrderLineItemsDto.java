package com.sham.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    @Id
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
