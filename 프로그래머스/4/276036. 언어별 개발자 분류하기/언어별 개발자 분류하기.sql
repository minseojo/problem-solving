SELECT 
    (CASE 
        WHEN EXISTS (SELECT S.CODE 
                FROM SKILLCODES S 
                WHERE S.CODE & D.SKILL_CODE AND 
                S.NAME = 'Python') AND 
            EXISTS (SELECT S.CODE 
                FROM SKILLCODES S 
                WHERE S.CODE & D.SKILL_CODE AND 
                S.NAME != 'Python' AND # 파이썬이 아닌 경우, 실제로는 파이썬은 Back End라 안겹침
                S.CATEGORY = 'Front End') THEN 'A'

        WHEN EXISTS (SELECT S.CODE 
                FROM SKILLCODES S 
                WHERE S.CODE & D.SKILL_CODE AND 
                S.NAME = 'C#') THEN 'B'

        WHEN EXISTS (SELECT S.CODE 
                FROM SKILLCODES S 
                WHERE S.CODE & D.SKILL_CODE AND 
                S.CATEGORY = 'Front End') THEN 'C'
    ELSE NULL
    END) AS GRADE, D.ID, D.EMAIL
FROM DEVELOPERS D
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID