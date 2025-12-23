-- 코드를 입력하세요
select year, month, gender, count(distinct user_id) users
from (
    select u.gender, extract(year from s.sales_date) year, extract(month from s.sales_date) month, u.user_id
    from ONLINE_SALE s, USER_INFO u
    where u.user_id = s.user_id
    and u.gender is not null
)
group by year, month, gender
order by year, month, gender