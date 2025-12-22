select a.MCDP_CD as "진료과코드", count(*) as "5월예약건수"
from APPOINTMENT a
where to_char(a.APNT_YMD, 'YYYY-MM') = '2022-05'
group by MCDP_CD
order by count(*), MCDP_CD