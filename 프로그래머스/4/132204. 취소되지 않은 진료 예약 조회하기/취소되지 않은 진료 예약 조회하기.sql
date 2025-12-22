select a.APNT_NO, (
    select PT_NAME
    from PATIENT 
    where PT_NO = a.PT_NO
) PT_NAME, a.PT_NO, a.MCDP_CD,
(
    select DR_NAME
    from DOCTOR 
    where DR_ID = a.MDDR_ID
) DR_NAME, a.APNT_YMD
from APPOINTMENT a
where a.APNT_YMD >= to_date('2022-04-13', 'YYYY-MM-DD')
and a.APNT_YMD < to_date('2022-04-14', 'YYYY-MM-DD')
and a.APNT_CNCL_YN = 'N'
order by a.APNT_YMD