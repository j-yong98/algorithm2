WITH joined_2021 AS (
    SELECT USER_ID
    FROM   USER_INFO 
    WHERE  EXTRACT(year from JOINED) = 2021
),
sale_joined_2021 AS (
    SELECT     EXTRACT(YEAR FROM s.SALES_DATE) AS year
             , EXTRACT(MONTH FROM s.SALES_DATE) AS month
             , COUNT(DISTINCT s.USER_ID) AS PURCHASED_USERS
    FROM       ONLINE_SALE s
    INNER JOIN joined_2021 j
               ON s.user_id = j.user_id
    GROUP BY   EXTRACT(YEAR FROM s.sales_date)
             , EXTRACT(MONTH FROM s.sales_date)
)
SELECT   year
       , month
       , purchased_users
       , ROUND(purchased_users / (SELECT COUNT(*) FROM joined_2021), 1) AS puchased_ratio
FROM     sale_joined_2021
ORDER BY year ASC
       , month ASC;