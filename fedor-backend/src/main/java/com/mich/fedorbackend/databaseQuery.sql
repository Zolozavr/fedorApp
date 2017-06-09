use fedor;

CREATE TABLE Users (
    id INT NOT NULL AUTO_INCREMENT,
    f_name VARCHAR(50),
    l_name VARCHAR(50),
    role VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL,
    pswd VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    contact_number VARCHAR(15),
    CONSTRAINT pk_users_id PRIMARY KEY (id)
);



insert into Users
(f_name, l_name, role, enabled, pswd, email, contact_number)
values ('Mihail', 'Kuklin', 'ADMIN', true, 'admin', 'zolozavr@gmail.com', '0679020613');

insert into Users
(f_name, l_name, role, enabled, pswd, email, contact_number)
values ('Myth', 'Mocak', 'ADMIN', true, 'admin', 'dimka@gmail.ru', '0679046073');

insert into Users
(f_name, l_name, role, enabled, pswd, email, contact_number)
values ('Evpat', 'Kotovasiy', 'USER', true, 'ogogo', 'evpat@gmail.com', '0982507623');

insert into Users
(f_name, l_name, role, enabled, pswd, email, contact_number)
values ('Saveliy', 'Skotinyaka', 'USER', true, 'ogogo', 'skot@gmail.com', '0982567623');


create table Category ( 
id int not null auto_increment,
categoryName VARCHAR(50),
description VARCHAR(50),
image_url  varchar(30),
is_active BOOLEAN,
CONSTRAINT pk_category_id PRIMARY KEY (id)
);

insert into Category (categoryName, description, image_url, is_active)
values ('Detective', 'Detective novels', 'p_01.png', true);
insert into Category (categoryName, description, image_url, is_active)
values ('Science Fiction', 'Novels about stars and space', 'p_02.png', true);
insert into Category (categoryName, description, image_url, is_active)
values ('Drama', 'Drammatical novels with no happy end', 'p_03.png', true);
insert into Category (categoryName, description, image_url, is_active)
values ('Vacabulary', 'Vocabularys from one language to another', 'p_03.png', true);
insert into Category (categoryName, description, image_url, is_active)
values ('Poetic', 'Poetic books', 'p_04.png', true);

create table Books ( 
id int not null auto_increment,
bookName VARCHAR(50),
author VARCHAR(50),
yearOfPrint  varchar(5),
unit_price DECIMAL(10,2),
img_url varchar(25),
category_id int,
users_id int,
views int default 0,
is_active BOOLEAN,
CONSTRAINT pk_book_id PRIMARY KEY (id),
CONSTRAINT fk_book_category_id foreign key (category_id) references Category (id),
constraint fk_book_users_id foreign key (users_id) references Users (id)
);

insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Skazka o care saltene', 'Pushkin A.S.', '1954', 240.00,'b_001.png', 5, 3, true);

insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Lolita', 'Nabokov', '1999', 100.00, 'b_003.png', 3, 3, true);
insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Stalnaya krisa', 'G. Garrison', '2000', 130.00,'b_004.png', 2, 3, true);
insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Alisa i druzya', 'K. Bulichev', '1990', 340.00,'b_005.png', 1, 4, true);
insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Isskustvo pet', 'Popushkin A.N.', '1973', 134.00,'b_006.png', 5, 4, true);
insert into Books (bookName, author, yearOfPrint, unit_price, img_url, category_id, users_id, is_active)
values ('Bukvar', 'Narodnoe Tv.', '1987', 60.00,'b_007.png', 4, 4, true);