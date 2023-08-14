create schema if not exists tasklist;

CREATE TABLE IF NOT EXISTS users
(
    id       bigserial primary key,
    name     varchar(255) NOT NULL,
    username varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks
(
    id              bigserial primary key,
    title           varchar(255) NOT NULL,
    description     varchar(255) NULL,
    status          varchar(255) NOT NULL,
    expiration_date timestamp    NULL
);

CREATE TABLE IF NOT EXISTS users_tasks
(
    user_id bigint NOT NULL,
    task_id bigint NOT NULL,
    primary key (user_id, task_id),
    constraint fk_users_tasks_users foreign key (user_id) references users (id) on delete cascade on update no action,
    constraint fk_users_tasks_tasks foreign key (task_id) references tasks (id) on delete cascade on update no action
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id bigint       NOT NULL,
    role    varchar(255) NOT NULL,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);