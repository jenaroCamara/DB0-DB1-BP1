package com.example.jpadto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DTOusuario {
    int id;
    String usuario;
    //String password;
    String name;

    DTOusuario(){}
    DTOusuario(int id, String usuario, String name){
        this.id=id; this.usuario=usuario;this.name=name;
    }

    /*String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;*/
}
