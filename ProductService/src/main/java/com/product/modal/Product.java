package com.product.modal;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.product.dto.ProductDTO;
import com.product.dto.ProductResponse;

import lombok.*;


@Document(value = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product
{
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
		public Product(ProductResponse productResponse)
		{
			this.name = productResponse.getName();
			this.description = productResponse.getDescription();
			this.price = productResponse.getPrice();
		}
}
