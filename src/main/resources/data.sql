insert into customers(name, surname, age, phone_number)
values ('Ivan', 'Корнеев', 24, '9857851279');
insert into customers(name, surname, age, phone_number)
values ('Alex', 'Захаров', 36, '9857981279');
insert into customers(name, surname, age, phone_number)
values ('Petya', 'Грачев', 18, '9898851279');
insert into customers(name, surname, age, phone_number)
values ('Alex', 'Родионов', 27, '9857851479');
insert into customers(name, surname, age, phone_number)
values ('Olga', 'Алексеева', 74, '9866851285');
insert into customers(name, surname, age, phone_number)
values ('Sveta', 'Васильева', 25, '9851051279');
insert into customers(name, surname, age, phone_number)
values ('Nicolay', 'Шишкин', 15, '9857221479');
insert into customers(name, surname, age, phone_number)
values ('Stas', 'Яковлев', 16, '9857861211');
insert into customers(name, surname, age, phone_number)
values ('Vlad', 'Грачев', 34, '9857852629');
insert into customers(name, surname, age, phone_number)
values ('Igor', 'Козлов', 28, '9857851285');

insert into orders(date, customers_id, product_name, amount)
values ('2023.01.10 10.15.10', 7, 'Молоко', 4);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.10 10.16.10', 5, 'Хлеб', 1);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.11 10.17.15', 4, 'Сыр', 4);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.11 10.18.20', 1, 'Батончик', 10);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.11 10.19.10', 2, 'Сыр', 5);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.12 11.16.10', 8, 'Молоко', 4);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.12 12.17.10', 10, 'Хлеб', 2);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.12 13.54.25', 3, 'Кола', 10);
insert into orders(date, customers_id, product_name, amount)
values ('2023.01.12 13.58.54', 7, 'Кола', -1);

update orders
set date='2023.01.11 10.17.15',
    customers_id=4,
    product_name='Печеньки',
    amount=25
where orders.id = 5;
