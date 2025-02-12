
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE clients
(
    email        VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name   VARCHAR(20),
    last_name    VARCHAR(30),
    phone_number VARCHAR(11),
    city         VARCHAR(30),
    street       VARCHAR(30),
    postal_code  VARCHAR(6)
);

CREATE TABLE statuses
(
    status_id   SERIAL PRIMARY KEY NOT NULL,
    status_name VARCHAR(20)        NOT NULL
);

CREATE TABLE categories
(
    category_id   SERIAL PRIMARY KEY NOT NULL,
    category_name VARCHAR(30)        NOT NULL
);

CREATE TABLE producers
(
    producer_id SERIAL PRIMARY KEY NOT NULL,
    name        VARCHAR(30)        NOT NULL
);

CREATE TABLE advancement_levels
(
    advancement_id SERIAL PRIMARY KEY NOT NULL,
    level          VARCHAR(30)        NOT NULL
);

CREATE TABLE items
(
    item_id        UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    model          VARCHAR(30),
    category_id    INTEGER          NOT NULL,
    price          DECIMAL(6, 2),
    advancement_id INTEGER          NOT NULL,
    producer_id    INTEGER          NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (advancement_id) REFERENCES advancement_levels (advancement_id),
    FOREIGN KEY (producer_id) REFERENCES producers (producer_id)
);

CREATE TABLE sizes
(
    size_id SERIAL PRIMARY KEY NOT NULL,
    size    VARCHAR(3)         NOT NULL
);

CREATE TABLE orders
(
    order_id          UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    email             VARCHAR(50)      NOT NULL,
    confirmation_date TIMESTAMP,
    shipment_date     TIMESTAMP,
    status_id         INTEGER          NOT NULL,
    FOREIGN KEY (email) REFERENCES clients (email),
    FOREIGN KEY (status_id) REFERENCES statuses (status_id)
);

CREATE TABLE copies
(
    copy_id  UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    item_id  UUID             NOT NULL,
    size_id  INTEGER          NOT NULL,
    order_id UUID             NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (item_id),
    FOREIGN KEY (size_id) REFERENCES sizes (size_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
);
