create table category (
id identity,
name varchar(255),
image_url varchar(50),
is_active boolean,

constraint pk_category_id primary key (id)
)