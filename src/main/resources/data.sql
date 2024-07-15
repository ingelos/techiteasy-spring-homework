-- In deze data.sql gebruiken we expliciete id's
INSERT INTO wallbrackets (id, size, adjustable, name, price) VALUES (1001, '25X32', false, 'LG bracket', 32.23),
                                                                    (1002, '25X32/32X40', true, 'LG bracket', 32.23),
                                                                    (1003, '25X25', false, 'Philips bracket', 32.23),
                                                                    (1004, '25X32/32X40', true, 'Nikkei bracket', 32.23),
                                                                    (1005, '25X32', false, 'Nikkei bracket', 32.23);

INSERT INTO cimodules (id, name, type, price) VALUES (1001, 'universal CI-module', '23JI12', 32.5);

INSERT INTO remotecontrollers (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1001, 'NH3216SMART', 'AAA', 'Nikkei HD smart TV controller', 'Nikkei', 12.99, 235885),
                                                                                                             (1002, '43PUS6504/12/L', 'AA', 'Philips smart TV controller', 'Philips', 12.99, 235885),
                                                                                                             (1003, 'OLED55C16LA', 'AAA', 'OLED55C16LA TV controller', 'LG', 12.99, 235885);

INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1001, 'NH3216SMART', 'Nikkei', 'HD smart TV', 159, 3, 100, 'LED', 'HD ready',  true, true, false, false, false, false, 235885, 45896),
                                                                                                                                                                                                         (1002, '43PUS6504/12/L', 'Philips', '4K UHD LED Smart Tv', 379, 3, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 8569452, 5685489),
                                                                                                                                                                                                        (1003, '43PUS6504/12/M', 'Philips', '4K UHD LED Smart Tv', 379, 5, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 345549, 244486),
                                                                                                                                                                                                         (1004, '43PUS6504/12/S', 'Philips', '4K UHD LED Smart Tv', 379, 2, 60, 'LED', 'Ultra HD',  true, true, false, true, false, false, 6548945, 4485741),
                                                                                                                                                                                                         (1005, 'OLED55C16LA', 'LG', 'LG OLED55C16LA', 989, 5, 100, 'OLED', 'ULTRA HD',  true, true, true, true, true, false, 50000, 20500);


INSERT INTO users (username, password, email) VALUES ('user', '$2a$12$Yox4VhA8.x4cH7jTJAPXselLvu6CQBc.C.0xyqdhnxKj/W0Subrlu','user@test.nl');
INSERT INTO users (username, password, email) VALUES ('admin', '$2a$12$epVBmNrfdcs2TNTCjhaDwe3Ar4QFZbvEnQvIs2OwNur1ylRPmNy7a', 'admin@test.nl');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

-- INSERT INTO users (username, password, apikey, email) VALUES ('henk', "$2a$12$fI.QqK5uTjkLal6JfYVAZur85zew.rSddD0JHg4YyjUlyBXCIeWBC", '7847493', "test@testy.tst");
-- INSERT INTO authorities (username, authority) VALUES ('henk', 'ROLE_ADMIN');