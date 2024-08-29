package com.product.jwt;
/*
 * @author NaveenWodeyar
 * @date 29-08-2024
 */

import com.product.modal.UserPrinciple;
import com.product.modal.Users;
import com.product.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUserName(username);

        if (user == null) {
            System.out.println("User not found,"+username);
            throw new UsernameNotFoundException("User not found in the table,");
        }
        return new UserPrinciple(user);

    }
}
