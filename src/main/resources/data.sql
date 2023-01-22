INSERT into users (id, name)
VALUES (101, 'Super User');
INSERT into users (id, name)
VALUES (102, 'Sub User');

INSERT into posts (id, title, content, author, user_id)
VALUES (201, 'Test Post # 1', 'Test Content # 1', 'Super Author', 101);
INSERT into posts (id, title, content, author, user_id)
VALUES (202, 'Test Post # 2', 'Test Content # 2', 'Super Author', 101);

INSERT into comments (id, name, post_id)
VALUES (301, 'Post # 1 Comment', 201);