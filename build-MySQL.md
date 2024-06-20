# MySQL表

## 以下的是我build Project所用的表,请按照下面的写入MySQL数据库就行

> 请注意:我开发的下面的话,本应该引入一个等级判断,去跳转到我们对应的管理员和普通用户的页面,但是可能是自己技术还是不够好,所以我就只能实现出就是分次登录注册
>
> 当然觉得下面的方案更好一点,分离不会被一口气攻击到

```sql
create database demofinalclassvueproject;
use demofinalclassvueproject;

drop table if exists `user`;
-- 用户表 
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    tel VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
select * from user;
insert into `user` values(1,'xieleihan','13160637910','123456');
```

