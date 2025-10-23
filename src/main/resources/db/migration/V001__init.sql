CREATE TABLE IF NOT EXISTS roles
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    fio        VARCHAR(150) NOT NULL,
    nickname   VARCHAR(150) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    role_id    UUID         NOT NULL REFERENCES roles (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS auth_codes
(
    id          uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id     uuid       NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    passcode    varchar(6) NOT NULL,
    expire_date bigint     NOT NULL
);
