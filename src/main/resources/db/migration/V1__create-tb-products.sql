create table tb_products(

    id bigint not null auto_increment,
    name varchar(100) not null,
    description varchar(200) not null,
    price decimal(10,2) not null,

    primary key(id)
);