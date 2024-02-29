-- 코드를 작성해주세요
select Year(ym) YEAR, round(avg(PM_VAL1), 2) AS PM10, round(avg(PM_VAL2), 2) AS "PM2.5"
from AIR_POLLUTION
where LOCATION2 = '수원'
group by (Year(ym))
order by year