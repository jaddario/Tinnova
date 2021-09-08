SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE VEICULOS;

SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('1', 'Monza', 'fiat', '1998', 'Monza tubarão', false, current_timestamp, current_timestamp);

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('2', 'Monza', 'chevrolet', '2000', 'Monza tubarão', false, current_timestamp, current_timestamp);

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('3', 'Omega', 'chevrolet', '1995', 'Omega cd', false, current_timestamp, current_timestamp);

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('4', 'Giulietta', 'alfa romeo', '1997', 'Alfa romeo Giulietta', true, current_timestamp, current_timestamp);

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('5', 'C4', 'citroen', '2005', 'C4 Pallas', false, current_timestamp, current_timestamp);

INSERT INTO VEICULOS (ID, MODELO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED) VALUES
  ('6', 'A360', 'mazda', '1970', 'A360', true, current_timestamp, current_timestamp);

