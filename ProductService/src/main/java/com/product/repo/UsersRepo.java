package com.product.repo;
/*
 * @author NaveenWodeyar
 * @date 29-08-2024
 */

import com.product.modal.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends MongoRepository<Users,String> {
    Users findByUserName(String userName);
}
