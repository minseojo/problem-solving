-- 코드를 작성해주세요
select SCORE, a.EMP_NO, EMP_NAME, POSITION, EMAIL
from (select emp_no, sum(score) as SCORE
    from HR_GRADE
    group by (emp_no)
) a left join HR_EMPLOYEES b
on a.emp_no = b.emp_no
order by score desc
limit 1