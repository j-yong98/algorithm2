select b.author_id, (
    select author_name
    from author a
    where b.author_id = a.author_id
) author_name, b.category, sum(total_sales) total_sales
from (
    select b.category, b.author_id, b.price * s.sales total_sales
    from BOOK b, BOOK_SALES s
    where s.book_id = b.book_id
    and extract(year from s.sales_date) = 2022
    and extract(month from s.sales_date) = 1
) b
group by b.author_id, b.category
order by author_id asc, category desc