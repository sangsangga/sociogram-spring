CREATE table if not exists follows(
    id serial primary key,
    follower_id bigint UNSIGNED,
    FOREIGN KEY (follower_id) REFERENCES users(id),
    following_id bigint unsigned,
    FOREIGN KEY (following_id) REFERENCES posts(id),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp
);

create index idx_follows_follower_id
    on follows(follower_id);

create index idx_follows_following_id
    on follows(following_id);