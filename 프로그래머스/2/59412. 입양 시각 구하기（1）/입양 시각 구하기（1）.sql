select extract(hour from cast(a.DATETIME as timestamp)) as hour, count(*) as count
from ANIMAL_OUTS a
where extract(hour from cast(a.DATETIME as timestamp)) >= 09
and extract(hour from cast(a.DATETIME as timestamp)) < 20
group by extract(hour from cast(a.DATETIME as timestamp))
order by hour
