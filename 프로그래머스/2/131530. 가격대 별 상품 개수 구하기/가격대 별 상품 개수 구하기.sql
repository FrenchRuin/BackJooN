SELECT TRUNC(PRICE, -4) AS PRICE_GROUP, COUNT(1) AS PRODUCTS
  FROM PRODUCT 
GROUP BY TRUNC(PRICE, -4)
ORDER BY PRICE_GROUP