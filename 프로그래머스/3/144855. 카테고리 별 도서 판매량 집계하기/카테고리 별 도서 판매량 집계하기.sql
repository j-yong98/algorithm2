# select b.category, sum(bs.sales) as total_sales
# from book_sales bs
# join book b on b.book_id = bs.book_id  
# where date_format(bs.sales_date, '%Y-%m') = '2022-01'
# group by category
# order by total_sales


select b.category, sum(bs.sales) total_sale
from book_sales bs
join book b on bs.book_id = b.book_id
where date_format(bs.sales_date, '%Y-%m') = '2022-01'
group by b.category
order by b.category