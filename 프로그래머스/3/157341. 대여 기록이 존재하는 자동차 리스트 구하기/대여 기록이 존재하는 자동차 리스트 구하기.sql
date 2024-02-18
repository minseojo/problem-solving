-- 코드를 입력하세요
SELECT DISTINCT(CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR as a JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as b
USING(CAR_ID)
WHERE CAR_TYPE = '세단' AND MONTH(b.START_DATE) = 10
ORDER BY CAR_ID DESC