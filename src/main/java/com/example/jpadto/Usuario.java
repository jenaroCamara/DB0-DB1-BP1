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
    @NotNull
    String password;
    @NotNull
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
    Date termination_date;
}
