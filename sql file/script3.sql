alter table dv_film add constraint positive_length check (length > 0);

alter table mg_customers alter column address_id set default 0;

alter table dv_address alter column address set not null;
