-- 코드를 작성해주세요
with front_end_skill as (
    select *
    from skillcodes
    where category = 'Front End'
)

select distinct(id), email, first_name, last_name
from developers as d
join front_end_skill as fk
on d.skill_code & fk.code
order by id