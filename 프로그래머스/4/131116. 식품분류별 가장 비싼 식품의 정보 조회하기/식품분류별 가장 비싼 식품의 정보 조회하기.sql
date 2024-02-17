-- 코드를 입력하세요
SELECT b.CATEGORY, a.MAX_PRICE, b.PRODUCT_NAME
FROM (SELECT PRODUCT_ID, CATEGORY, MAX(PRICE) AS MAX_PRICE, PRODUCT_NAME
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY) as a 
    JOIN FOOD_PRODUCT as b
    USING (CATEGORY)
WHERE b.CATEGORY = a.CATEGORY AND b.PRICE = a.MAX_PRICE
ORDER BY MAX_PRICE DESC
