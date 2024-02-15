SELECT b.flavor
FROM FIRST_HALF as a join ICECREAM_INFO as b
    on a.flavor = b.flavor
where a.TOTAL_ORDER > 3000 and INGREDIENT_TYPE = 'fruit_based';
