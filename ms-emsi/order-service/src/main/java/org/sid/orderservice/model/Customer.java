package org.sid.orderservice.model;

import lombok.Data;

import java.util.PrimitiveIterator;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;

}
