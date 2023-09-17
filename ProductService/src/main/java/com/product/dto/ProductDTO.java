package com.product.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO 
{
	private String msg;
	private Object obj;
}
