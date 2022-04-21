# gido
API for gido-like books

# MySQL 起動
```
docker run -p 3306:3306 --name mysql_80 -e MYSQL_ROOT_PASSWORD=password -d mysql:8 mysqld --default-authentication-plugin=mysql_native_password
```

# `mysql` コマンド
```
docker exec -it mysql_80 mysql -u root -p
```
パスワードは `password`
