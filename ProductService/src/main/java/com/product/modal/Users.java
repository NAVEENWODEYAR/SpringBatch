package com.product.modal;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @author NaveenWodeyar
 * @date 29-08-2024
 */
@Tag(name = "User_Table",description = "Table to store user information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "USERS")
public class Users {

    @Id
    private String userId;

    private String userName;

    private String userPassword;
}
