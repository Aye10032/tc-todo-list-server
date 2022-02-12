create table todo_group
(
    id          INTEGER not null
        constraint todo_group_pk
            primary key autoincrement,
    owner       INTEGER not null,
    name        TEXT    not null,
    information TEXT,
    admins      BLOB
);

create table todo_message
(
    id               INTEGER not null
        constraint todo_message_pk
            primary key autoincrement,
    from_player      INTEGER not null,
    target_player    INTEGER not null,
    send_time        NUMERIC not null,
    last_update_time NUMERIC not null,
    msg              TEXT    not null,
    has_read         BOOLEAN not null,
    from_todo        INTEGER
);

create table todo_player
(
    id     INTEGER not null
        constraint todo_player_pk
            primary key autoincrement,
    name   TEXT    not null,
    uuid   TEXT    not null,
    admin  BOOLEAN not null,
    groups BLOB
);

create table todo_task
(
    id               INTEGER not null
        constraint todo_task_pk
            primary key autoincrement,
    name             TEXT    not null,
    pos              TEXT,
    owner            INTEGER not null,
    time             NUMERIC not null,
    last_update_time NUMERIC not null,
    groups           INTEGER not null,
    status           BOOLEAN not null,
    undertaker_list  BLOB    not null
);

create table todo_undertake
(
    id               INTEGER not null
        constraint todo_undertake_pk
            primary key autoincrement,
    player_id        INTEGER not null,
    msg              TEXT,
    time             NUMERIC not null,
    last_update_time NUMERIC
);
