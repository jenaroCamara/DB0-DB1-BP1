package com.example.jpadto.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    int id;
    @NotBlank(message = "No puede estar vacio")
    String usuario;//not null max-length: 10 min-length: 6]
    @NotBlank(message = "No puede estar vacio")
    String name;
    @NotBlank(message = "No puede estar vacio")
    String password;
    @NotBlank(message = "No puede estar vacio")
    String surname;
    @NotBlank(message = "No puede estar vacio")
    String company_email;
    @NotBlank(message = "No puede estar vacio")
    String personal_email;
    @NotBlank(message = "No puede estar vacio")
    String city;
    boolean active;
    Date created_date;
    @NotBlank(message = "No puede estar vacio")
    String imagen_url;
    Date termination_date;
}
