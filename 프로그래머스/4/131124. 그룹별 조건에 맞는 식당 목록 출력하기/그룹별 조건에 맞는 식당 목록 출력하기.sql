select (
    select member_name
    from member_profile mp
    where mp.member_id = rr.member_id
) member_name,
rr.review_text, to_char(rr.review_date, 'YYYY-MM-DD') review_date
from REST_REVIEW rr
where rr.member_id in (
    select r.member_id
    from REST_REVIEW r
    group by r.member_id
    having count(*) = (
        select *
        from (
            select count(*) review_count
            from REST_REVIEW
            group by member_id
            order by review_count desc
        )
        where rownum <= 1
    )
)
order by rr.review_date, rr.review_text