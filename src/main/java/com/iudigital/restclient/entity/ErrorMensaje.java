/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iudigital.restclient.entity;

/**
 *
 * @author LenovoZ470
 */
public class ErrorMensaje {
    
    String timestamp;
    String message;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMensaje{" + "timestamp=" + timestamp + ", message=" + message + '}';
    }
    
    
    
}
