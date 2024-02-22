-- 코드를 작성해주세요

with front_end_skill as (
    select *
    from skillcodes
    where category = 'Front End'
)

#exists 활용
select distinct(id), email, first_name, last_name
from developers as d
where exists (
    select *
    from front_end_skill fk
    where d.skill_code & fk.code
)
order by id

# # join 활용
# select distinct(id), email, first_name, last_name
# from developers as d
# cross join front_end_skill fk
# where d.skill_code & fk.code && fk.category = 'Front End'
# order by id;