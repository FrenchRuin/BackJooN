-- 코드를 입력하세요
SELECT A.ANIMAL_ID,A.ANIMAL_TYPE,A.NAME
FROM ANIMAL_INS A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID (+)
AND A.SEX_UPON_INTAKE !=  B.SEX_UPON_OUTCOME
ORDER BY A.ANIMAL_ID