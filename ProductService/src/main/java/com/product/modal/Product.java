package com.product.modal;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.product.dto.ProductDTO;

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
	
		public Product(ProductDTO productDTO)
		{
			this.name = productDTO.getName();
			this.description = productDTO.getDescription();
			this.price = productDTO.getPrice();
		}
}
