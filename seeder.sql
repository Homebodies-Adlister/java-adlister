

USE adlister_project_db;

INSERT INTO users(id, username, email, password, zip, is_admin)
VALUES(1, 'teddybear1', 'tedz@codeup.com', '$2a$12$gusZ/dLsO5FAClzLFqdjZ.NFMXSYSpO7l125ldfgbXrHP.Z8vJDmi', 78221, true),
      (2, 'johnnydgood', 'johnny@codeup.com', '$2a$12$PS23wM46uQJUaYCgXcy52.DL.Gly6mGk7EiVD99HkPD7HcB0/Zfty', 78259, true),
      (3, 'livinlachicaloca', 'jackie@codeup.com', '$2a$12$v.AuRrzZHbnsKpgAGqU3U.L/nmpBof9cWA/nRYCPnzYNHqoezOS/S', 78230, true),
      (4, 'spicybubbles', 'james@codeup.com', '$2a$12$a.M.yIVZ2ZP0ALEp.Z3ypu7sqgGn5KsMjs0a1sA.fKxRSTv1EfSni', 78254, true);

USE adlister_project_db;
INSERT INTO restaurant(id, user_id, title, description, rating, mask, gloves, social_distancing, dine_in, take_out)
VALUES (1, 1, 'Panchos', 'I like the flags', '5', true, true, true, false, true),
       (2, 2, 'China Harbor', 'I found a bug in my food', '1', false, true, false, false, true),
       (3, 3, 'Lubys', 'pretty decent', '4', true, true, false, false, true),
       (4, 4, 'Taco Bell', 'The food is good and i love that hot sauce', '5', false, true, true, false, true);


INSERT INTO retail(id, user_id, title, description, rating, curb_side, in_store, mask, gloves, social_distancing)
VALUES (1, 1, 'Solo Serve', 'Great selection but not really', '3', true, true, true, false, true),
       (2, 2, 'K-mart', 'Brings back memories', '5', false, true, false, false, true),
       (3, 3, 'Target', 'Always clean', '4', true, true, false, false, true),
       (4, 4, 'HEB', 'I love this place!', '5', false, true, true, false, true);


USE adlister_project_db;
INSERT INTO restaurant(id, user_id, title, description, rating, mask, gloves, social_distancing, dine_in, take_out)
VALUES (5, 5, 'Red Lobster', 'They dont have much sanitation but i dont care cause im a cat', 4, true, true, false, false, true);
#
# USE adlister_project_db;
# INSERT INTO retail(id, user_id, title, description, rating, curb_side, in_store, mask, gloves, social_distancing)
# VALUES (5, 5, 'Montgomery Wards', 'Very friendly staff', '5', true, true, true, false, true);