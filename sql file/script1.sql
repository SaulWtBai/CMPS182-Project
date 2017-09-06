alter table mg_customers add constraint mg_customers_key primary key(customer_id);

alter table dv_address add constraint dv_address_key primary key(address_id);

alter table dv_film add constraint dv_film_key primary key(film_id);

alter table cb_books add constraint cb_books_key primary key(title, author_id);

alter table cb_authors add constraint cb_authors_key primary key(author_id);
