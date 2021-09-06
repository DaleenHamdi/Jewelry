create table product_collection (collection_ID int , product_ID int, 
primary key(collection_ID,product_ID),
constraint brandCollection_superCollectionID_FK foreign key (collection_ID) references collection (id),
constraint brandCollection_superproductID2_FK foreign key (product_ID) references product (id)
);
