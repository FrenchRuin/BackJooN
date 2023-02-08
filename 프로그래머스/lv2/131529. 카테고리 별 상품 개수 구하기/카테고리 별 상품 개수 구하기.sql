-- 코드를 입력하세요
SELECT DISTINCT substr(product_code, 0,2) as CATEGORY  , count(*) as PRODUCTS from product
group by substr(product_code, 0,2) order by CATEGORY
 