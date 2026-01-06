select animal_id, name
from (
select i.animal_id, i.name
from ANIMAL_INS i, ANIMAL_OUTS o
where i.animal_id = o.animal_id
order by o.datetime - i.datetime desc
    )
    where rownum <= 2;
    