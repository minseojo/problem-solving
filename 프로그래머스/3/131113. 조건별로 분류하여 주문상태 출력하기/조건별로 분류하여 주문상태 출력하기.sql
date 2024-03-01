select ORDER_ID, PRODUCT_ID, DATE_FORMAT(out_date, '%Y-%m-%d') OUT_DATE, 
    case
        when out_date is null then '출고미정'
        when datediff(out_date, '2022-05-01') <= 0 then '출고완료'
        WHEN datediff(out_date, '2022-05-01') > 0 then '출고대기'
        end '출고여부'
from food_order
order by order_id