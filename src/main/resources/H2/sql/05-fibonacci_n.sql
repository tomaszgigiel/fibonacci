CREATE TABLE IF NOT EXISTS fibonacci_n (
 n BIGINT NOT NULL,
 prev_x BIGINT NOT NULL,
 x BIGINT NOT NULL
);

INSERT INTO fibonacci_n(n, prev_x, x)
WITH t (n, prev_x, x) AS
(
 SELECT 0, 1, 0
 UNION ALL
 SELECT n + 1, x, prev_x + x
 FROM t
 WHERE n < 45
)
SELECT * FROM t;
