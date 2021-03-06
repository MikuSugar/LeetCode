select a.Id as Id
from Weather a,Weather b
where DATEDIFF(a.RecordDate,b.RecordDate)=1 and a.Temperature > b.Temperature
-- 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
-- 例如，根据上述给定的 Weather 表格，返回如下 Id:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/rising-temperature
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。