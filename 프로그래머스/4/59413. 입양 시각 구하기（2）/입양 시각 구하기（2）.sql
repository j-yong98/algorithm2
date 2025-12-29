WITH hour_counts AS (
    SELECT EXTRACT(HOUR FROM CAST(datetime AS TIMESTAMP)) AS hour,
           COUNT(*) AS cnt
    FROM animal_outs
    GROUP BY EXTRACT(HOUR FROM CAST(datetime AS TIMESTAMP))
),
hours AS (
    SELECT level - 1 AS hour
    FROM dual
    CONNECT BY level <= 24
)
SELECT
    h.hour,
    NVL(c.cnt, 0) AS count
FROM hours h
LEFT JOIN hour_counts c
       ON c.hour = h.hour
ORDER BY h.hour;