INSERT INTO users (username, password, enabled, firstname, lastname, email) values ('admin', 'admin', true, 'heriberto', 'alarcon', 'heriberto@alarcon.com');
INSERT INTO users (username, password, enabled, firstname, lastname, email) values ('user1', 'user1', true, 'pepe', 'perez', 'pepe@perez.com');


INSERT into roles (firstname) values ('ROLE_USER');
INSERT into roles (firstname) values ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) values (1,1);
INSERT INTO user_roles (user_id, role_id) values (2,2);
INSERT INTO user_roles (user_id, role_id) values (2,1);

