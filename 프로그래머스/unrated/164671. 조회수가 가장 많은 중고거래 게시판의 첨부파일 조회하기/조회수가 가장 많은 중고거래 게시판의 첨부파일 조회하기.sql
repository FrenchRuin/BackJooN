-- 코드를 입력하세요


SELECT '/home/grep/src/' || UGF.BOARD_ID ||'/'|| UGF.FILE_ID || UGF.FILE_NAME || UGF.FILE_EXT AS FILE_PATH
FROM USED_GOODS_BOARD UGB , USED_GOODS_FILE UGF
WHERE UGB.BOARD_ID = UGF.BOARD_ID 
AND UGB.VIEWS IN (SELECT MAX(VIEWS)
                    FROM USED_GOODS_BOARD )
ORDER BY UGF.FILE_ID DESC



