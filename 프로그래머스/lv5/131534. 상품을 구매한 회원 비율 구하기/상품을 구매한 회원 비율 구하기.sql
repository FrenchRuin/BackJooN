WITH JOIN_2021 AS (
    SELECT COUNT(DISTINCT F.USER_ID) AS JOIN
    FROM USER_INFO F
    WHERE TO_CHAR(JOINED,'YYYY-MM-DD') LIKE '2021-%'
),
PURCHASE_2021 AS (
    SELECT EXTRACT(YEAR FROM SALES_DATE) AS YEAR
           , EXTRACT(MONTH FROM SALES_DATE) AS MONTH
           , COUNT(DISTINCT N.USER_ID) AS PURCHASED_USERS
    FROM JOIN_2021
         , ONLINE_SALE N INNER JOIN USER_INFO F
           ON N.USER_ID = F.USER_ID 
           AND TO_CHAR(JOINED,'YYYY-MM-DD') LIKE '2021-%'
    GROUP BY EXTRACT(YEAR FROM SALES_DATE), EXTRACT(MONTH FROM SALES_DATE)
    ORDER BY YEAR ASC, MONTH ASC
)

SELECT YEAR
       , MONTH
       , PURCHASED_USERS
       , ROUND(PURCHASED_USERS / JOIN, 1) AS PURCHASED_RATIO
FROM PURCHASE_2021, JOIN_2021