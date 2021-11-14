-- Project Name : noname
-- Date/Time    : 2021/11/14 21:42:09
-- Author       : nori
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- 資産
--* RestoreFromTempTable
create table T_ASSETS (
  user_id character varying(36) not null
  , assets_id character varying(36) not null
  , assets_name character varying(128) not null
  , created_at TIMESTAMP
  , constraint T_ASSETS_PKC primary key (user_id,assets_id)
) ;

-- ユーザ
--* RestoreFromTempTable
create table M_USER (
  user_id character varying(36) not null
  , user_name character varying(30) not null
  , created_at TIMESTAMP
  , constraint M_USER_PKC primary key (user_id)
) ;

comment on table T_ASSETS is '資産';
comment on column T_ASSETS.user_id is 'ユーザID';
comment on column T_ASSETS.assets_id is '資産ID';
comment on column T_ASSETS.assets_name is '資産名';
comment on column T_ASSETS.created_at is '作成日';

comment on table M_USER is 'ユーザ';
comment on column M_USER.user_id is 'ユーザID';
comment on column M_USER.user_name is '氏名';
comment on column M_USER.created_at is '作成日';

