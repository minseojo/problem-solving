select a.id, 
        count(case when b.id is null then null else b.id end) as 'CHILD_COUNT'
from ECOLI_DATA a
left join ECOLI_DATA b
on a.id = b.parent_id
group by a.id
order by a.id