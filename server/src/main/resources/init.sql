insert into roles values(1,"STANDARD_USER");
insert into roles values(2,"USER_MANAGER");
insert into roles values(3,"EVENT_MANAGER");
insert into roles values(4,"ADMIN");

insert into users values(1,'mt.nakielski@gmail.com', null, 'Mateusz', 'razdwa', '608 618 673', 'Nakielski', 3, 'mnaki', null);

insert into users_roles values(1,1);
insert into users_roles values(1,2);
insert into users_roles values(1,3);
insert into users_roles values(1,4);