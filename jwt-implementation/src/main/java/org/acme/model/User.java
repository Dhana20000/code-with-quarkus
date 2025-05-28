package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String country;
    private String dealer;
    private Set<String> roles;
}
