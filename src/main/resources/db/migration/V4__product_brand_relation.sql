alter table product 
add constraint product_brand_FK foreign key (brand_id) references brand (id) on delete cascade;
