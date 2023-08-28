package com.product.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse 
{
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
