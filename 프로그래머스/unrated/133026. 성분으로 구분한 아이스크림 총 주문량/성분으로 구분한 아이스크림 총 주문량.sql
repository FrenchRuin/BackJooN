-- 코드를 입력하세요
SELECT b.ingredient_type ,sum(A.TOTAL_ORDER) as TOTAL_ORDER
from  FIRST_HALF A, ICECREAM_INFO B
where A.FLAVOR = B.FLAVOR
group by b.ingredient_type
