alter table colors
rename to product_color;

create table colors (id serial primary key, color varchar);

alter table product_color 
RENAME COLUMN id TO color_id;

alter table product_color 
drop COLUMN color;

alter table product_color 
add constraint color_ID_FK foreign key (color_id) references colors(id);