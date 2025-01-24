# InventoryManagement
# 概要
 
在庫管理を円滑にするため試作したアプリです。

# 作成経緯
現在所属する職場では、使用する道具の管理を書類で行っており、生産計画表から導き出す必要のある発注数、日々消費されていく在庫を把握するためにこのアプリを制作しました。

# 使用技術
Java 11  
Spring Boot 3.0.5  
MySQL 5.7.33

# ER図
![スクリーンショット 2025-01-24 223220](https://github.com/user-attachments/assets/247f25cb-fd75-4b99-88e4-baa3f4e08c79)




# テーブル定義
## itemsテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|category         |varchar(100)    |                |
|item             |varchar(100)    |                |
|registration_date|timestamp       |                |
|deleded_date     |timestamp       |                |

## stocksテーブル
|列名             |データ型         |備考            |
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|items  _id       |int(11)         |                |
|quantity         |int(100)        |                |
|update_date      |timestamp       |                |



## ordersテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|items_id         |int(11)         |                |
|stocks_id        |int(11)         |                |
|order_date       |timestamp       |                |
|delivery_date    |varchar(26)     |                |


# Requirement
