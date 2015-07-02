# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table stand (
  id                        bigint not null,
  standname                 varchar(255),
  post                      varchar(255),
  constraint pk_stand primary key (id))
;

create table user (
  id                        bigint not null,
  name                      varchar(255),
  stand_id                  bigint,
  constraint pk_user primary key (id))
;

create sequence stand_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists stand;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists stand_seq;

drop sequence if exists user_seq;

