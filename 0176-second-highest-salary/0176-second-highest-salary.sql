SELECT IF(COUNT(*) > 0, 
    (
        select salary
        from (
            select id, salary, dense_rank() over (order by salary desc) as 'ranking'
            from employee
        ) as r 
        where r.ranking = 2
        limit 1
    ), NULL
) AS 'SecondHighestSalary'




