create table orders (id serial primary key, date timestamp);

create table order_Info (order_Id int,
		constraint orders_superOrderID_FK foreign key (order_ID) references orders (id) on delete cascade,
		client_Id int,
 		constraint orders_superClientID_FK foreign key (client_ID) references client (id) on delete cascade,
		product_Id int,
		constraint orders_superProductID3_FK foreign key (product_ID) references product (id) on delete cascade,
		
		constraint orders_orderID2_PK primary key (order_Id,client_ID,product_ID),
		quantity int);