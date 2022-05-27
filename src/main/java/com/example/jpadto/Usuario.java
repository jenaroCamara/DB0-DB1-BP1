package com.example.jpadto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    int id;
    @NotNull
    String usuario;//not null max-length: 10 min-length: 6]
    @NotNull
    String name;

    Usuario(){}
    Usuario(int id, String usuario, String name){
     this.id=id; this.usuario=usuario;this.name=name;
    }

    //@NotNull
    //String password;
    /*@NotNull
    String surname;
    @NotNull
    String company_email;
    @NotNull
    String personal_email;
    @NotNull
    String city;
    @NotNull
    boolean active;
    @NotNull
    Date created_date;
    @NotNull
    String imagen_url;
    Date termination_date;*/

   /* public Usuario(){}
    public Usuario(int id, String usuario, String password, String name,String surname,
                   String company_email, String personal_email, String city,
                   boolean active, Date created_date, String imagen_url, Date termination_date) {

    }*/
}
