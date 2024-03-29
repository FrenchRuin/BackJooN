SELECT A.CAR_ID , A.CAR_TYPE ,  (A.DAILY_FEE *(1-(B.DISCOUNT_RATE / 100)) * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR A
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN B ON A.CAR_TYPE = B.CAR_TYPE
WHERE A.CAR_ID NOT IN (SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE (CAR_ID , END_DATE) IN (SELECT CAR_ID, MAX(END_DATE)
                                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                         GROUP BY CAR_ID)
                  AND TO_CHAR(START_DATE, 'YYYYMMDD') <= '20221130'
                  AND TO_CHAR(END_DATE, 'YYYYMMDD') >= '20221101')
AND A.CAR_TYPE IN ('세단' , 'SUV')
AND B.DURATION_TYPE = '30일 이상'
AND (A.DAILY_FEE *(1-(B.DISCOUNT_RATE / 100)) * 30) BETWEEN 500000 AND 1990000
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
