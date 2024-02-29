-- 코드를 작성해주세요
select emp_no, emp_name,
    case
        when a.score >= 96 then 'S'
        when a.score >= 90 then 'A'
        when a.score >= 80 then 'B'
        else 'C'
        end as grade
    ,
    case
        when a.score >= 96 then sal * 0.2
        when a.score >= 90 then sal * 0.15
        when a.score >= 80 then sal * 0.1
        else 0
        end as bonus
from (
    select emp_no, sum(score) / 2 as score
    from HR_GRADE
    group by (emp_no)
) as a join HR_EMPLOYEES as b
using (emp_no)