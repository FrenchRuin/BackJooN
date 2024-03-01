
SELECT A.SCORE, A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
  FROM (
  SELECT T2.SCORE	,T1.EMP_NO	,T1.EMP_NAME,T1.POSITION,T1.EMAIL, ROW_NUMBER() OVER(ORDER BY T2.SCORE DESC) AS ROWN
  FROM HR_EMPLOYEES T1
  INNER JOIN (SELECT EMP_NO , SUM(SCORE) AS SCORE
  FROM HR_GRADE
 GROUP BY EMP_NO) T2 ON T1.EMP_NO = T2.EMP_NO
  ) A
  WHERE A.ROWN = 1




