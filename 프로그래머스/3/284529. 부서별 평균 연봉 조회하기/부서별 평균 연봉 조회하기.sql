-- 코드를 작성해주세요
select dept_id, dept_name_en, round(avg(sal), 0) avg_sal
from HR_DEPARTMENT join HR_EMPLOYEES
using (dept_id)
group by (dept_id)
order by avg_sal desc