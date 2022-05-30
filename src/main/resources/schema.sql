table Persona{
id_persona int [pk, increment],
usuario string [not null max-length: 10 min-length: 6],
password string [not null],
name string [not null],
surname string,
company_email string [not null ],
personal_email string [not null],
city string [not null],
created_date date [not null],
imagen_url string,
termination_date date
}