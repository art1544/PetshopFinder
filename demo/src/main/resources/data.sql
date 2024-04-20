INSERT INTO pet_shop (name, distance) VALUES ('Meu Canino Feliz', 2);
INSERT INTO pet_shop (name, distance) VALUES ('Vai Rex', 1.7);
INSERT INTO pet_shop (name, distance) VALUES ('ChowChawgas', 0.8);

-- Adicionando preços para cada petshop
-- Assume-se que os IDs dos petshops são 1, 2, 3 respectivamente
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (false, 20, 40, 1);
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (true, 24, 48, 1);
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (false, 15, 50, 2);
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (true, 20, 55, 2);
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (false, 30, 45, 3);
INSERT INTO price (is_weekend, small_dog_price, large_dog_price, petshop_id) VALUES (true, 30, 45, 3);
