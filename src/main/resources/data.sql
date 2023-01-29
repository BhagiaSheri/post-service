INSERT into users (id, name, username, password)
VALUES (101, 'Super User', 'SuperUser', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT into users (id, name, username, password)
VALUES (102, 'Sub User', 'SubUser', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (101, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (102, 2);

INSERT into posts (id, title, content, author, user_id)
VALUES (201, 'Test Post # 1', 'Test Content # 1', 'Super Author', 101);
INSERT into posts (id, title, content, author, user_id)
VALUES (202, 'Test Post # 2', 'Test Content # 2', 'Super Author', 101);

INSERT into comments (id, name, post_id)
VALUES (301, 'Post # 1 Comment', 201);