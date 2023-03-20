/* Populate table client */
INSERT INTO client (name, last_name, email, create_at) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO client (name, last_name, email, create_at) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO client (name, last_name, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO client (name, last_name, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO client (name, last_name, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO client (name, last_name, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO client (name, last_name, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO client (name, last_name, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO client (name, last_name, email, create_at) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO client (name, last_name, email, create_at) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO client (name, last_name, email, create_at) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO client (name, last_name, email, create_at) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

/* Populate table item */
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item1', (SELECT client_id FROM client WHERE client.name like ('Jade')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item2', (SELECT client_id FROM client WHERE client.name like ('Jade')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item3', (SELECT client_id FROM client WHERE client.name like ('Jade')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item4', (SELECT client_id FROM client WHERE client.name like ('Jade')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item5', (SELECT client_id FROM client WHERE client.name like ('Jade')));

INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item6', (SELECT client_id FROM client WHERE client.name like ('Tornado')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item7', (SELECT client_id FROM client WHERE client.name like ('Tornado')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item8', (SELECT client_id FROM client WHERE client.name like ('Tornado')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item9', (SELECT client_id FROM client WHERE client.name like ('Tornado')));
INSERT INTO item (item_id, name, client_id) VALUES(uuid(), 'item0', (SELECT client_id FROM client WHERE client.name like ('Tornado')));

/* Populate table client_item
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Jade')), (SELECT item_id FROM item WHERE item.name like ('item1')));
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Jade')), (SELECT item_id FROM item WHERE item.name like ('item2')));
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Jade')), (SELECT item_id FROM item WHERE item.name like ('item3')));
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Jade')), (SELECT item_id FROM item WHERE item.name like ('item4')));
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Jade')), (SELECT item_id FROM item WHERE item.name like ('item5')));

INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Tornado')), (SELECT item_id FROM item WHERE item.name like ('item6')));
INSERT INTO client_item (client_fk, item_fk) VALUES((SELECT client_id FROM client WHERE client.name like ('Tornado')), (SELECT item_id FROM item WHERE item.name like ('item7'))); */
