CREATE TABLE IF NOT EXISTS table100 AS
WITH RECURSIVE t(x) AS (
 SELECT 1
 UNION ALL
 SELECT x + 1 FROM T WHERE x < 100
)
SELECT * FROM t;