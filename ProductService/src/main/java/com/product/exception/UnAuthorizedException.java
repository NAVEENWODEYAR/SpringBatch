package com.product.exception;
/*
 * @author NaveenWodeyar
 * @date 29-08-2024
 */

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String msg) {
        super(msg);
    }
}
