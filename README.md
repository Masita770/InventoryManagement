# InventoryManagement
# 概要
 
在庫管理を円滑にするためのアプリです。

# 作成経緯
現在所属する職場では、使用する道具の管理を書類で行っており、生産計画表から導きす必要のある発注数、日々消費されていく在庫を把握するためにこのアプリを制作しました。

# 使用技術
Java 11  
Spring Boot 3.0.5  
MySQL 5.7.33

# ER図
# テーブル定義
## productsテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|p_number         |varchar8256)    |                |
|product          |varchar(256)    |                |
|category         |varchar(100)    |                |
|price            |varchar(256)    |                |
|registration_date|timestamp       |                |
|deleded_date     |timestamp       |                |

## stocksテーブル
|列名             |データ型         |備考            |
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|product_id       |int(11)         |                |
|inventory        |char(100)       |                |
|update_date      |timestamp       |                |



## ordersテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|stocks_id        |int(11)         |                |
|orders_number    |int(11)         |                |
|order_date       |timestamp       |                |
|delivery_date    |varchar(26)     |                |


# Requirement
