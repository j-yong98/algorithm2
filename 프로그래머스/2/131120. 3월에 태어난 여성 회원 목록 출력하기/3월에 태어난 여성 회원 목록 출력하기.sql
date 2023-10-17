select 
    MEMBER_ID, 
    MEMBER_NAME, 
    GENDER,
    date_format(DATE_OF_BIRTH, "%Y-%m-%d") date_of_birth
from member_profile
where tlno is not null 
and gender = 'W'
and date_format(DATE_OF_BIRTH, "%m") = 3
order by member_id