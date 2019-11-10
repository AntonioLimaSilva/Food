CREATE TABLE tbl_restaurante_forma_pgto (
    id_restaurante BIGINT(20) NOT NULL,
    id_forma_pgto BIGINT(20) NOT NULL,
    PRIMARY KEY (id_restaurante, id_forma_pgto),
    FOREIGN KEY (id_restaurante) REFERENCES tbl_restaurante (id_restaurante),
    FOREIGN KEY (id_forma_pgto) REFERENCES tbl_forma_pgto (id_forma_pgto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;