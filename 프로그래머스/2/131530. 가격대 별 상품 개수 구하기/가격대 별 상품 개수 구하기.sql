select price PRICE_GROUP, count(*) PRODUCTS
from (
    select price div 10000 * 10000 price
    from product
) as a
group by price
order by PRICE_GROUP