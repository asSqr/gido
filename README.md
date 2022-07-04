# gido
[![codecov](https://codecov.io/gh/asSqr/gido/branch/master/graph/badge.svg?token=30zXEaG8oz)](https://codecov.io/gh/asSqr/gido) 

<h1 align="center">API for gido-like books</h1>

# MySQL 起動
```
docker run -p 3306:3306 --name mysql_80 -e MYSQL_ROOT_PASSWORD=password -d mysql:8 mysqld --default-authentication-plugin=mysql_native_password
```

# `mysql` コマンド
```
docker exec -it mysql_80 mysql -u root -p
```
パスワードは `password`

その後，`src/resources/init.sql` を実行．

# Seed 作成
```
cd ./shells
python ./create_seed.py > ../src/main/resources/data.sql
```
