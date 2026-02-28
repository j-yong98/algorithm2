select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, r.score
from REST_INFO i, (
    select rest_id, round(avg(review_score), 2) score
    from REST_REVIEW
    group by rest_id
) r
where i.address like '서울%'
and r.rest_id = i.rest_id
order by r.score desc, i.favorites desc