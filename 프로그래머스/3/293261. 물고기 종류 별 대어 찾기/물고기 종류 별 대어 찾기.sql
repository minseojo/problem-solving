-- 코드를 작성해주세요
select id, fish_name, length
from fish_info a join (
    select fish_type, max(length) length
    from (
        select *, rank() over (partition by fish_type order by length desc)
        from fish_info
    ) a 
    group by (fish_type)
) b
using (fish_type, length) 
join fish_name_info using (fish_type)
order by id


# select id, fish_name, length
# from (
#     select fish_type, max(length) length
#     from fish_info
#     group by(fish_type)
# ) a join fish_name_info b using (fish_type) 
# join fish_info using (fish_type, length)