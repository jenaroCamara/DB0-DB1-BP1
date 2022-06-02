package com.example.jpadto.infraestructure.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class DTOusuario {
    int id;
    @NotBlank(message = "usuario No puede estar vacio")
    String usuario;
    @NotBlank(message = "name No puede estar vacio")
    String name;
    @NotBlank(message = "password No puede estar vacio")
    String password;
    @NotBlank(message = "surname No puede estar vacio")
    String surname;
    @NotBlank(message = "company-email No puede estar vacio")
    String company_email;
    @NotBlank(message = "personal_email No puede estar vacio")
    String personal_email;
    @NotBlank(message = "city No puede estar vacio")
    String city;
    @NotBlank(message = "active No puede estar vacio")
    boolean active;
    Date created_date;
    @NotBlank(message = "imagen-url No puede estar vacio")
    String imagen_url;
    Date termination_date;
}
