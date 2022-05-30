package com.example.jpadto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class DTOusuario {
    int id;
    String usuario;
    //String password;
    String name;

    DTOusuario(){}

    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
