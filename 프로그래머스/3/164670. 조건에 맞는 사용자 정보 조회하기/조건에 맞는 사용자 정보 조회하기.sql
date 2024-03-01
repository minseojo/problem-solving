-- 코드를 입력하세요
select user_id, nickname, concat_ws(' ', city, street_address1, street_address2) 전체주소, 
    concat_ws('-', left(tlno, 3), substring(tlno, 4, 4), right(tlno, 4)) TLNO
from USED_GOODS_USER 
where user_id in (
    select writer_id
    from USED_GOODS_BOARD
    group by writer_id
    having count(*) >= 3
)
order by user_id desc