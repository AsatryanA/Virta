create table companies
(
    id                 bigserial    not null,
    created_date       timestamp(6) not null,
    last_modified_date timestamp(6) not null,
    name               varchar(255) not null,
    parent_company_id  bigint,
    primary key (id)
);
create table stations
(
    id                 bigserial    not null,
    created_date       timestamp(6) not null,
    last_modified_date timestamp(6) not null,
    latitude           float(53)    not null,
    longitude          float(53)    not null,
    name               varchar(255) not null,
    company_id         bigint       not null,
    primary key (id)
);
alter table if exists companies
    add constraint UK_50ygfritln653mnfhxucoy8up unique (name);
alter table if exists companies
    add constraint FKskxybvd3bqx3dfyyy7p1ilehx foreign key (parent_company_id) references companies;
alter table if exists stations
    add constraint FK2jt4b24ut0w2dpbxlggckg0t4 foreign key (company_id) references companies;

insert into companies (created_date, last_modified_date, name, parent_company_id)
VALUES ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'Tesla', null),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'BMW', null),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'Mercedes', null),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'Audi', null),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'Lexus', null),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'tesla1', 1),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'tesla2', 6),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'bmw1', 2),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'mercedes1', 3),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'mercedes2', 3),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'mercedes3', 10),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 'Toyota', null);

insert into stations (created_date, last_modified_date, latitude, longitude, name, company_id)
values ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.179188, 44.499104, 'Yerevan', 1),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.808450, 44.510545, 'Vanadzor', 1),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.590199, 44.370794, 'Aparan', 2),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.792904, 43.846497, 'Gyumri', 2),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 39.694953, 45.454038, 'Vayq', 3),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 39.835654, 45.672732, 'Jermuk', 3),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 39.530973, 46.022710, 'Sisian', 4),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 39.502145, 46.345054, 'Goris', 5),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.353044, 45.129945, 'Gavar', 6),
       ('2022-12-11 13:11:17.492738', '2022-12-11 13:11:17.492738', 40.406405, 44.692358, 'Abovyan', 7);
