create schema if not exists homework4;
#
# create table if not exists homework2.CUSTOMERS
# (
#     id           int auto_increment primary key,
#     name         char(20) not null check ( name != ''),
#     surname      char(20) not null check ( surname != ''),
#     age          smallint check ( age > 0),
#     phone_number char(10) check ( phone_number != '')
# );
#
#
# create table if not exists homework2.ORDERS
# (
#     id           int auto_increment primary key,
#     date         timestamp not null,
#     customers_id int,
#     product_name char(100) check ( product_name != ''),
#     amount       smallint check ( amount > 0),
#
#     foreign key (customers_id) references homework2.CUSTOMERS (id)
# );
#
#
#
#
#
