package com.product.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO 
{
	private String name;
	private String description;
	private BigDecimal price;
}
