CREATE TABLE produto
(
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(100)   NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);