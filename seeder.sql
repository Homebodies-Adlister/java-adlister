USE adlister_project_db;

INSERT INTO users(id, username, email, password, zip, is_admin)
VALUES(1, 'teddybear1', 'tedz@codeup.com', 'aaaa', 78221, true),
      (2, 'johnnydgood', 'johnny@codeup.com', 'bbbb', 78259, true),
      (3, 'livinlachicaloca', 'jackie@codeup.com', 'cccc', 78230, true),
      (4, 'spicybubbles', 'james@codeup.com', 'dddd', 78254, true);


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
