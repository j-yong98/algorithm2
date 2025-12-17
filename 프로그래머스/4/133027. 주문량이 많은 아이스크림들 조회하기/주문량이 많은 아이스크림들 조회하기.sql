-- 코드를 입력하세요
select flavor
from (
    select f.flavor, f.total_order +
    (
        select sum(total_order) total_order
        from JULY
        where flavor = f.flavor
        group by flavor
    ) total_order
    from FIRST_HALF f
    order by total_order desc
)
where rownum <= 3