alter table mg_customers add foreign key (address_id) references dv_address(address_id);

alter table cb_books add foreign key (author_id) references cb_authors(author_id);
