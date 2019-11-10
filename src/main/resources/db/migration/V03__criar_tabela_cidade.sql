CREATE TABLE tbl_cidade (
    id_cidade BIGINT(20) AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    id_estado BIGINT(20) NOT NULL,
    PRIMARY KEY (id_cidade),
    FOREIGN KEY (id_estado) REFERENCES tbl_estado (id_estado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;