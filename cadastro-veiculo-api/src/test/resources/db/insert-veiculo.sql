SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE VEICULOS;

SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('1', 'Monza', 'Fiat', '1998', 'Monza tubarão', false, current_timestamp, current_timestamp);