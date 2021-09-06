create table colors (id serial , product_id int , color varchar, 
constraint color_superproduct_FK foreign key (product_id) REFERENCES product(id) on delete cascade,
constraint color_colorkey_PK primary key (id,product_id ));

