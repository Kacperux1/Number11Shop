CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE clients
(
    email        VARCHAR(50) PRIMARY KEY NOT NULL,
    first_name   VARCHAR(20)             NOT NULL,
    last_name    VARCHAR(30)             NOT NULL,
    phone_number VARCHAR(11),
    city         VARCHAR(30)             NOT NULL,
    street       VARCHAR(30)             NOT NULL,
    postal_code  VARCHAR(6)              NOT NULL
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

CREATE TABLE items
(
    item_id     UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    model       VARCHAR(30),
    category_id INTEGER          NOT NULL,
    price       DECIMAL(6, 2),
    advancement VARCHAR(20)      NOT NULL,
    producer_id INTEGER          NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (producer_id) REFERENCES producers (producer_id)
);


CREATE TABLE orders
(
    order_id          UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    email             VARCHAR(50)      NOT NULL,
    confirmation_date TIMESTAMP,
    shipment_date     TIMESTAMP,
    status            varchar(20)      NOT NULL,
    FOREIGN KEY (email) REFERENCES clients (email)
);

CREATE TABLE copies
(
    copy_id  UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    item_id  UUID             NOT NULL,
    size     varchar(20)      NOT NULL,
    order_id UUID             NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items (item_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
);




