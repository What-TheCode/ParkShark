create table address
(
    id            serial
        constraint address_pkey
            primary key,
    street_name   text,
    street_number integer,
    postal_code   integer,
    region        text not null
);


create table person
(
    id               serial
        constraint person_pkey
            primary key,
    first_name       text,
    last_name        text,
    address_id       integer
        constraint person_address_id_fkey
            references address,
    telephone        text,
    email            text,
    mobile_telephone text
);

create table division
(
    id                serial
        constraint division_pkey
            primary key,
    name              text,
    director_id       integer
        constraint division_director_id_fkey
            references person,
    original_name     text,
    parentdivision_id integer
        constraint division_division_id_fk
            references division
);


insert into address(street_name, street_number, postal_code, region)
values ('bartstraat', 12, 3000, 'Leuven');

insert into person(first_name, last_name, address_id, telephone, email, mobile_telephone)
values ('Bart', 'ward', 1, '0487221388', 'bart.ward@test.com', null);

insert into division(name, director_id, original_name, parentdivision_id)
values ('test', 1, 'original test', null);