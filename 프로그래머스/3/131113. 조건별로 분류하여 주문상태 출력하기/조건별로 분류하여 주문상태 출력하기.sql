-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'), 
    CASE 
        WHEN MONTH(OUT_DATE) < 5 OR MONTH(OUT_DATE) = 5 
            AND DAY(OUT_DATE) = 1 THEN '출고완료'
        WHEN OUT_DATE IS NULL THEN '출고미정'
        ELSE '출고대기'
        END
FROM FOOD_ORDER
