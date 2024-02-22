SELECT id, email, first_name, last_name
FROM developers AS d
WHERE EXISTS (
    SELECT 1
    FROM skillcodes AS s
    WHERE (s.name = 'Python' OR s.name = 'C#') AND 
    (d.skill_code & s.code) = s.code
)
ORDER BY id;
