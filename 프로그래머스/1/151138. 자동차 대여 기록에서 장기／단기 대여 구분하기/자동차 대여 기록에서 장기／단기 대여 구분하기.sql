select history_id, car_id, date_format(start_date, '%Y-%m-%d') START_DATE, date_format(end_date, '%Y-%m-%d') END_DATE, 
if (timestampdiff(day,start_date, end_date) + 1 >= 30, '장기 대여', '단기 대여') RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where Year(start_date) = 2022 and month(start_date) = 9
order by history_id desc