# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table stand (
  id                        bigint not null,
  standname                 varchar(255),
  post                      varchar(255),
  constraint pk_stand primary key (id))
;

create sequence stand_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists stand;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists stand_seq;

