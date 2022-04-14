cols
===
```sql
id,name,age,create_time,update_time
```


pageUser
===
```sql
select
-- @pageTag(){
   #{use("cols")}
-- @}
from user
```


jsonMap
===
```json
{
    "id":"id",
    "name":"name",
    "age":"age",
    "createTime":"create_time",
    "updateTime":"update_time"
}
```

listAllTables
===

```sql
SELECT table_name 
FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = #{dbName} 
```
