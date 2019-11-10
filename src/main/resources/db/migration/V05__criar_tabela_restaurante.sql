CREATE TABLE tbl_restaurante (
    id_restaurante BIGINT(20) AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    taxa_frete DECIMAL(10, 2),
    data_cadastro DATE,
    data_atualizacao DATE,
    cep VARCHAR(20),
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    id_cidade BIGINT(20) NOT NULL,
    id_cozinha BIGINT(20) NOT NULL,
    PRIMARY KEY (id_restaurante),
    INDEX cidade (id_cidade),
    FOREIGN KEY (id_cidade) REFERENCES tbl_cidade (id_cidade) ON DELETE CASCADE,
    INDEX cozinha (id_cozinha),
    FOREIGN KEY (id_cozinha) REFERENCES tbl_cozinha (id_cozinha) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;