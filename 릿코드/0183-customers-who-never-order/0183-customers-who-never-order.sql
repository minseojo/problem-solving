# Write your MySQL query statement below
select a.name as Customers from 
customers a left outer join  orders b
    on a.id = b.customerId
where b.customerId is null;