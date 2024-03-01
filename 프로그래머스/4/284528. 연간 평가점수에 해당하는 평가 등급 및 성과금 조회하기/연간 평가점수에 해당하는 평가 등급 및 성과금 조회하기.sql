SELECT T1.EMP_NO
     , T2.EMP_NAME
     , T1.GRADE
     , CASE WHEN T1.GRADE = 'S' THEN T2.SAL * 0.2
            WHEN T1.GRADE = 'A' THEN T2.SAL * 0.15
            WHEN T1.GRADE = 'B' THEN T2.SAL * 0.1
            WHEN T1.GRADE = 'C' THEN 0 END          AS BONUS
  FROM (SELECT EMP_NO
     , CASE WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C' END                    AS GRADE
  FROM HR_GRADE 
 GROUP BY EMP_NO) T1 
 INNER JOIN HR_EMPLOYEES T2 ON T1.EMP_NO = T2.EMP_NO
     


