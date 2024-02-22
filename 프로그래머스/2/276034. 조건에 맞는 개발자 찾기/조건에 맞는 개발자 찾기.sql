-- 코드를 작성해주세요
select distinct(id), email, first_name, last_name
from developers as d 
join (
    select *
    from skillcodes
    where name = 'Python' or name = 'C#'
) as s
on (d.skill_code & s.code) = s.code
order by id