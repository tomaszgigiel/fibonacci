CREATE TABLE IF NOT EXISTS fibonacci45 AS
WITH t (n, prev_x, x) AS
(
 SELECT 0, 1, 0
 UNION ALL
 SELECT n + 1, x, prev_x + x
 FROM t
 WHERE n < 45
)
SELECT * FROM t;
