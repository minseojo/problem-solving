select month(start_date) month, car_id, 
    case 
        when count(month(start_date)) != 0 then count(month(start_date))
        end records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date >= '2022-08-01' && start_date <= '2022-10-31'
    group by car_id
    having count(*) >= 5
) and start_date >= '2022-08-01' && start_date <= '2022-10-31'
group by car_id, month(start_date)
order by month, car_id desc