SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
max(SIZE_OF_COLONY) over (partition by year(DIFFERENTIATION_DATE)) - size_of_colony as YEAR_DEV,
ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV ASC;