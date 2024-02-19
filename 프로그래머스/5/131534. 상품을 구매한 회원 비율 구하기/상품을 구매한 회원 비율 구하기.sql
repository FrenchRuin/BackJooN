



SELECT TO_CHAR(SALES_DATE,'YYYY') AS YEAR
     , TO_NUMBER(TO_CHAR(SALES_DATE,'MM')) AS MONTH
     , COUNT(DISTINCT USER_ID) AS PUCHASED_USERS
     , ROUND((COUNT(DISTINCT (USER_ID)) / (SELECT COUNT(USER_ID)
                                           FROM USER_INFO 
                                          WHERE TO_CHAR(JOINED, 'YYYY') = '2021')),1) AS PUCHASED_RATIO
  FROM ONLINE_SALE 
 WHERE USER_ID IN (SELECT USER_ID
                     FROM USER_INFO 
                    WHERE TO_CHAR(JOINED, 'YYYY') = '2021')
GROUP BY TO_CHAR(SALES_DATE,'YYYY'), TO_NUMBER(TO_CHAR(SALES_DATE,'MM'))
ORDER BY YEAR, MONTH







