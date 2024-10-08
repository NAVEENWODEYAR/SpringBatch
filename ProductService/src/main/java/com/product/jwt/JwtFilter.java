package com.product.jwt;
/*
 * @author NaveenWodeyar
 * @date 29-08-2024
 */

import com.product.exception.UnAuthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Service
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        try {
            if (header != null && header.startsWith("Bearer")){
                token = header.substring(7);
                userName = jwtService.extractUserName(token);
            }

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){

                UserDetails userDetails = applicationContext.getBean(MyUserDetailService.class).loadUserByUsername(userName);

                if (jwtService.validateToken(token, userDetails)){

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,null,userDetails.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }else {
                    throw new UnAuthorizedException("Invalid JWT token");
                }

            }
        }catch (Exception e) {
            throw e;
        }

        filterChain.doFilter(request,response);
    }
}
