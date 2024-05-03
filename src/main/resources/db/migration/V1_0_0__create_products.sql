CREATE TABLE IF NOT EXISTS products(
    id bigserial primary key,
    name varchar,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone not null default now(),
    deleted_at timestamp with time zone
);