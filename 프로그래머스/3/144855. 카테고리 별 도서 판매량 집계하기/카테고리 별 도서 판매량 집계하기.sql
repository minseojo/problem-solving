-- 코드를 입력하세요
SELECT CATEGORY, SUM(b.SALES) TOTAL_SALES
FROM BOOK JOIN (
    SELECT * 
    FROM BOOK_SALES 
    WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 1
    ) as b
    USING(BOOK_ID)
GROUP BY CATEGORY
ORDER BY CATEGORY