
select author_id, author_name, category, sum(total_sales) total_sales
from (select author_id, author_name, category, price * sum(sales) total_sales
        from (
            select *
            from book join author
            using (author_id)
        ) as a 
        join (
            select *
            from BOOK_SALES 
            where SALES_DATE like '2022-01-%'
        ) as b
        using (book_id)
        group by author_id, book_id) as c
group by author_id, category
order by author_id, category desc