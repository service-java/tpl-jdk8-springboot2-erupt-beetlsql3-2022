cols
===
```sql
id,name,age,create_time,update_time
```


pageUser
===
```sql
select #{use("cols")}
from user
where  #{use("condition")}
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

```
SELECT table_name 
FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = 'sku' 
```