create table if not exists book
(
    id integer not null
        constraint book_pk
            primary key,
    title varchar,
    author varchar,
    publication_date timestamp
);

alter table book
    owner to postgres;

alter table book owner to postgres;

-- Creating a sequence for the id in the book table
create sequence book_id_seq;
alter table book alter column id set default nextval('book_id_seq');
alter sequence book_id_seq owner to postgres;

