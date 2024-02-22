-- 코드를 작성해주세요
select id, email, first_name, last_name
from DEVELOPER_INFOS
where skill_1 = 'Python' || skill_2 = 'Python' || skill_3 = 'Python'
order by id