INSERT INTO tasklist.users (name, username, password)
values ('Jane Lake', 'janelake@gmail.com', '$2a$12$KArfIpepmR/VQkQO7g1K9./RCwPWihdj4CK592BtKW1zys2SszzQm'),
       ('Kirill Vasovsky', 'mikevaz@gmail.com', '$2a$12$hiSWPCGJwXktvzXTCsFIEe.Q1sUG07ZPKtuNgl5sWrM6N4KFWVLfG');

INSERT INTO tasklist.tasks (title, description, status, expiration_date)
values ('Wash windows', null, 'TODO', '2023-08-16 12:30:00'),
       ('Repair curtains', 'Child room ones', 'IN_PROGRESS', '2023-08-20 18:00:00'),
       ('Fix bugs', 'Commit #12345', 'DONE', null),
       ('Call grandma', null, 'TODO', '2023-08-15 13:15:00');

INSERT INTO tasklist.users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 1),
       (4, 2);

INSERT INTO tasklist.users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');