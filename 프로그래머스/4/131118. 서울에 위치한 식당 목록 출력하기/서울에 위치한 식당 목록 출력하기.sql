select a.rest_id, a.rest_name, food_type, a.favorites, ADDRESS, round(avg(b.review_score), 2) SCORE
from (select *
    from REST_INFO
    where substring(address, 1, 2) = '서울'
) as a join rest_review as b
using (rest_id)
group by (rest_id)
order by score desc, favorites desc
