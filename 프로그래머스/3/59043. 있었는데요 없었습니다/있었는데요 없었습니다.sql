SELECT T1.ANIMAL_ID, T1.NAME
  FROM ANIMAL_INS T1
     , ANIMAL_OUTS T2
WHERE T1.ANIMAL_ID = T2.ANIMAL_ID
  AND T1.DATETIME > T2.DATETIME
 ORDER BY T1.DATETIME