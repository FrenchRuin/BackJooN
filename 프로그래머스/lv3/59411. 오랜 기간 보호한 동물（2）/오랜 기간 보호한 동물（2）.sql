SELECT ANIMAL_ID, NAME
FROM (SELECT AI.ANIMAL_ID , AI.NAME ,  AO.DATETIME - AI.DATETIME
FROM ANIMAL_INS AI , ANIMAL_OUTS AO
WHERE AI.ANIMAL_ID = AO.ANIMAL_ID (+)
AND AO.DATETIME IS NOT NULL 
ORDER BY AO.DATETIME - AI.DATETIME DESC )
WHERE ROWNUM < 3 




