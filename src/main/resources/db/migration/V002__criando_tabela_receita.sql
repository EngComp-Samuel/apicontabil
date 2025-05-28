CREATE TABLE receita(
	id SERIAL PRIMARY KEY NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	valor NUMERIC(17,2) NOT NULL,
	data_receita DATE NOT NULL,
	categoria_id INTEGER NOT NULL,
	CONSTRAINT fk_id_categoria FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);