SELECT CAR_TYPE, COUNT(*) CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE LOCATE('통풍시트', OPTIONS) > 0 OR 
    LOCATE('열선시트', OPTIONS) > 0 OR 
    LOCATE('가죽시트', OPTIONS) > 0
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE