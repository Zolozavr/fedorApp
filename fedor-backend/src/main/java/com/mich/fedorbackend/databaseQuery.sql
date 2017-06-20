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



create table Category ( 
id int not null auto_increment,
categoryName VARCHAR(50),
image_url  varchar(30),
is_active BOOLEAN,
description BLOB,
CONSTRAINT pk_category_id PRIMARY KEY (id)
);



create table Books ( 
id int not null auto_increment,
bookName VARCHAR(50),
author VARCHAR(50),
yearOfPrint  varchar(5),
unit_price DECIMAL(10,2),
img_url varchar(25),
views int default 0,
is_active BOOLEAN,
category_id int,
users_id int,
description BLOB,
CONSTRAINT pk_book_id PRIMARY KEY (id),
CONSTRAINT fk_book_category_id foreign key (category_id) references Category (id),
constraint fk_book_users_id foreign key (users_id) references Users (id)
);



