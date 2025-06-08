create table transacao(
    id bigserial PRIMARY KEY NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	valor NUMERIC(17,2) NOT NULL,
	data_transacao DATE NOT NULL,
	categoria_id INTEGER NOT NULL,
	tipo_transacao_id INTEGER NOT NULL,
	CONSTRAINT fk_id_categoria FOREIGN KEY(categoria_id) REFERENCES categoria(id),
	CONSTRAINT fk_id_tipo_transacao FOREIGN KEY(tipo_transacao_id) REFERENCES tipo_transacao(id)
);