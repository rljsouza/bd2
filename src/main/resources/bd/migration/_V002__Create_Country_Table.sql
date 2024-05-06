CREATE tb_country (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    abbreviation VARCHAR(255) NOT NULL,
    country_code int NOT NULL,
    name_pt VARCHAR(255) NOT NULL,
);

ALTER TABLE IF EXISTS tb_city
ADD CONSTRAINT IF NOT EXISTS fk_city_country
FOREIGN KEY (country_id) REFERENCES tb_country(id);




INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(1, 'Brazil', 'Brasil', 'BR', 1058)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(2, 'Afghanistan', 'Afeganistão', 'AF', 132)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(3, 'Albania', 'Albânia, Republica da', 'AL', 175)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(4, 'Algeria', 'Argélia', 'DZ', 590)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(5, 'American Samoa', 'Samoa Americana', 'AS', 6912)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(6, 'Andorra', 'Andorra', 'AD', 370)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(7, 'Angola', 'Angola', 'AO', 400)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(8, 'Anguilla', 'Anguilla', 'AI', 418)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(9, 'Antarctica', 'Antártida', 'AQ', 3596)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(10, 'Antigua and Barbuda', 'Antigua e Barbuda', 'AG', 434)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(11, 'Argentina', 'Argentina', 'AR', 639)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(12, 'Armenia', 'Armênia, Republica da', 'AM', 647)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(13, 'Aruba', 'Aruba', 'AW', 655)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(14, 'Australia', 'Austrália', 'AU', 698)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(15, 'Austria', 'Áustria', 'AT', 728)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(16, 'Azerbaijan', 'Azerbaijão, Republica do', 'AZ', 736)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(17, 'Bahamas', 'Bahamas, Ilhas', 'BS', 779)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(18, 'Bahrain', 'Bahrein, Ilhas', 'BH', 809)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(19, 'Bangladesh', 'Bangladesh', 'BD', 817)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(20, 'Barbados', 'Barbados', 'BB', 833)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(21, 'Belarus', 'Belarus, Republica da', 'BY', 850)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(22, 'Belgium', 'Bélgica', 'BE', 876)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(23, 'Belize', 'Belize', 'BZ', 884)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(24, 'Benin', 'Benin', 'BJ', 2291)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(25, 'Bermuda', 'Bermudas', 'BM', 906)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(26, 'Bhutan', 'Butão', 'BT', 1198)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(27, 'Bolivia', 'Bolívia', 'BO', 973)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(28, 'Bosnia and Herzegowina', 'Bósnia-herzegovina (Republica da)', 'BA', 981)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(29, 'Botswana', 'Botsuana', 'BW', 1015)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(30, 'Bouvet Island', 'Bouvet, Ilha', 'BV', 1023)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(31, 'British Indian Ocean Territory', 'Território Britânico do Oceano Indico', 'IO', 7820)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(32, 'Brunei Darussalam', 'Brunei', 'BN', 1082)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(33, 'Bulgaria', 'Bulgária, Republica da', 'BG', 1112)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(34, 'Burkina Faso', 'Burkina Faso', 'BF', 310)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(35, 'Burundi', 'Burundi', 'BI', 1155)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(36, 'Cambodia', 'Camboja', 'KH', 1414)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(37, 'Cameroon', 'Camarões', 'CM', 1457)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(38, 'Canada', 'Canada', 'CA', 1490)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(39, 'Cape Verde', 'Cabo Verde, Republica de', 'CV', 1279)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(40, 'Cayman Islands', 'Cayman, Ilhas', 'KY', 1376)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(41, 'Central African Republic', 'Republica Centro-Africana', 'CF', 6408)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(42, 'Chad', 'Chade', 'TD', 7889)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(43, 'Chile', 'Chile', 'CL', 1589)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(44, 'China', 'China, Republica Popular', 'CN', 1600)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(45, 'Christmas Island', 'Christmas, Ilha (Navidad)', 'CX', 5118)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(46, 'Cocos (Keeling) Islands', 'Cocos (Keeling) Ilhas', 'CC', 1651)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(47, 'Colombia', 'Colômbia', 'CO', 1694)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(48, 'Comoros', 'Comores, Ilhas', 'KM', 1732)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(49, 'Congo', 'Congo', 'CG', 1775)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(50, 'Congo, the Democratic Republic of the', 'Congo, Republica Democrática do', 'CD', 8885)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(51, 'Cook Islands', 'Cook, Ilhas', 'CK', 1830)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(52, 'Costa Rica', 'Costa Rica', 'CR', 1961)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(53, 'Cote dIvoire', 'Costa do Marfim', 'CI', 1937)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(54, 'Croatia (Hrvatska)', 'Croácia (Republica da)', 'HR', 1953)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(55, 'Cuba', 'Cuba', 'CU', 1996)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(56, 'Cyprus', 'Chipre', 'CY', 1635)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(57, 'Czech Republic', 'Tcheca, Republica', 'CZ', 7919)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(58, 'Denmark', 'Dinamarca', 'DK', 2321)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(59, 'Djibouti', 'Djibuti', 'DJ', 7838)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(60, 'Dominica', 'Dominica, Ilha', 'DM', 2356)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(61, 'Dominican Republic', 'Republica Dominicana', 'DO', 6475)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(62, 'East Timor', 'Timor Leste', 'TL', 7951)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(63, 'Ecuador', 'Equador', 'EC', 2399)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(64, 'Egypt', 'Egito', 'EG', 2402)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(65, 'El Salvador', 'El Salvador', 'SV', 6874)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(66, 'Equatorial Guinea', 'Guine-Equatorial', 'GQ', 3310)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(67, 'Eritrea', 'Eritreia', 'ER', 2437)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(68, 'Estonia', 'Estônia, Republica da', 'EE', 2518)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(69, 'Ethiopia', 'Etiópia', 'ET', 2534)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(70, 'Falkland Islands (Malvinas)', 'Falkland (Ilhas Malvinas)', 'FK', 2550)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(71, 'Faroe Islands', 'Feroe, Ilhas', 'FO', 2593)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(72, 'Fiji', 'Fiji', 'FJ', 8702)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(73, 'Finland', 'Finlândia', 'FI', 2712)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(74, 'France', 'Franca', 'FR', 2755)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(76, 'French Guiana', 'Guiana francesa', 'GF', 3255)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(77, 'French Polynesia', 'Polinésia Francesa', 'PF', 5991)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(78, 'French Southern Territories', 'Terras Austrais e Antárticas Francesas', 'TF', 3607)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(79, 'Gabon', 'Gabão', 'GA', 2810)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(80, 'Gambia', 'Gambia', 'GM', 2852)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(81, 'Georgia', 'Georgia, Republica da', 'GE', 2917)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(82, 'Germany', 'Alemanha', 'DE', 230)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(83, 'Ghana', 'Gana', 'GH', 2895)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(84, 'Gibraltar', 'Gibraltar', 'GI', 2933)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(85, 'Greece', 'Grécia', 'GR', 3018)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(86, 'Greenland', 'Groenlândia', 'GL', 3050)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(87, 'Grenada', 'Granada', 'GD', 2976)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(88, 'Guadeloupe', 'Guadalupe', 'GP', 3093)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(89, 'Guam', 'Guam', 'GU', 3131)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(90, 'Guatemala', 'Guatemala', 'GT', 3174)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(91, 'Guinea', 'Guine', 'GN', 3298)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(92, 'Guinea-Bissau', 'Guine-Bissau', 'GW', 3344)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(93, 'Guyana', 'Guiana', 'GY', 3379)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(94, 'Haiti', 'Haiti', 'HT', 3417)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(95, 'Heard and Mc Donald Islands', 'Ilha Heard e Ilhas McDonald', 'HM', 3603)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(96, 'Holy See (Vatican City State)', 'Vaticano, Estado da Cidade do', 'VA', 8486)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(97, 'Honduras', 'Honduras', 'HN', 3450)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(98, 'Hong Kong', 'Hong Kong', 'HK', 3514)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(99, 'Hungary', 'Hungria, Republica da', 'HU', 3557)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(100, 'Iceland', 'Islândia', 'IS', 3794)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(101, 'India', 'Índia', 'IN', 3611)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(102, 'Indonesia', 'Indonésia', 'ID', 3654)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(103, 'Iran (Islamic Republic of)', 'Ira, Republica Islâmica do', 'IR', 3727)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(104, 'Iraq', 'Iraque', 'IQ', 3697)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(105, 'Ireland', 'Irlanda', 'IE', 3751)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(106, 'Israel', 'Israel', 'IL', 3832)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(107, 'Italy', 'Itália', 'IT', 3867)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(108, 'Jamaica', 'Jamaica', 'JM', 3913)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(109, 'Japan', 'Japão', 'JP', 3999)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(110, 'Jordan', 'Jordânia', 'JO', 4030)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(111, 'Kazakhstan', 'Cazaquistão, Republica do', 'KZ', 1538)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(112, 'Kenya', 'Quênia', 'KE', 6238)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(113, 'Kiribati', 'Kiribati', 'KI', 4111)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(114, 'Korea, Democratic Peoples Republic of', 'Coreia, Republica Popular Democrática da', 'KP', 1872)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(115, 'Korea, Republic of', 'Coreia, Republica da', 'KR', 1902)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(116, 'Kuwait', 'Kuwait', 'KW', 1988)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(117, 'Kyrgyzstan', 'Quirguiz, Republica', 'KG', 6254)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(118, 'Lao Peoples Democratic Republic', 'Laos, Republica Popular Democrática do', 'LA', 4200)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(119, 'Latvia', 'Letônia, Republica da', 'LV', 4278)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(120, 'Lebanon', 'Líbano', 'LB', 4316)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(121, 'Lesotho', 'Lesoto', 'LS', 4260)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(122, 'Liberia', 'Libéria', 'LR', 4340)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(123, 'Libyan Arab Jamahiriya', 'Líbia', 'LY', 4383)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(124, 'Liechtenstein', 'Liechtenstein', 'LI', 4405)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(125, 'Lithuania', 'Lituânia, Republica da', 'LT', 4421)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(126, 'Luxembourg', 'Luxemburgo', 'LU', 4456)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(127, 'Macau', 'Macau', 'MO', 4472)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(128, 'North Macedonia', 'Macedônia do Norte', 'MK', 4499)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(129, 'Madagascar', 'Madagascar', 'MG', 4502)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(130, 'Malawi', 'Malavi', 'MW', 4588)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(131, 'Malaysia', 'Malásia', 'MY', 4553)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(132, 'Maldives', 'Maldivas', 'MV', 4618)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(133, 'Mali', 'Mali', 'ML', 4642)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(134, 'Malta', 'Malta', 'MT', 4677)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(135, 'Marshall Islands', 'Marshall, Ilhas', 'MH', 4766)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(136, 'Martinique', 'Martinica', 'MQ', 4774)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(137, 'Mauritania', 'Mauritânia', 'MR', 4880)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(138, 'Mauritius', 'Mauricio', 'MU', 4855)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(139, 'Mayotte', 'Mayotte (Ilhas Francesas)', 'YT', 4885)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(140, 'Mexico', 'México', 'MX', 4936)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(141, 'Micronesia, Federated States of', 'Micronesia', 'FM', 4995)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(142, 'Moldova, Republic of', 'Moldávia, Republica da', 'MD', 4944)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(143, 'Monaco', 'Mônaco', 'MC', 4952)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(144, 'Mongolia', 'Mongólia', 'MN', 4979)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(145, 'Montserrat', 'Montserrat, Ilhas', 'MS', 5010)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(146, 'Morocco', 'Marrocos', 'MA', 4740)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(147, 'Mozambique', 'Moçambique', 'MZ', 5053)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(148, 'Myanmar', 'Mianmar (Birmânia)', 'MM', 930)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(149, 'Namibia', 'Namíbia', 'NA', 5070)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(150, 'Nauru', 'Nauru', 'NR', 5088)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(151, 'Nepal', 'Nepal', 'NP', 5177)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(152, 'Netherlands', 'Países Baixos (Holanda)', 'NL', 5738)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(154, 'New Caledonia', 'Nova Caledonia', 'NC', 5428)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(155, 'New Zealand', 'Nova Zelândia', 'NZ', 5487)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(156, 'Nicaragua', 'Nicarágua', 'NI', 5215)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(157, 'Niger', 'Níger', 'NE', 5258)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(158, 'Nigeria', 'Nigéria', 'NG', 5282)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(159, 'Niue', 'Niue, Ilha', 'NU', 5312)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(160, 'Norfolk Island', 'Norfolk, Ilha', 'NF', 5355)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(161, 'Northern Mariana Islands', 'Marianas do Norte', 'MP', 4723)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(162, 'Norway', 'Noruega', 'NO', 5380)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(163, 'Oman', 'Oma', 'OM', 5568)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(164, 'Pakistan', 'Paquistão', 'PK', 5762)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(165, 'Palau', 'Palau', 'PW', 5754)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(166, 'Panama', 'Panamá', 'PA', 5800)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(167, 'Papua New Guinea', 'Papua Nova Guine', 'PG', 5452)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(168, 'Paraguay', 'Paraguai', 'PY', 5860)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(169, 'Peru', 'Peru', 'PE', 5894)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(170, 'Philippines', 'Filipinas', 'PH', 2674)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(171, 'Pitcairn', 'Pitcairn, Ilha', 'PN', 5932)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(172, 'Poland', 'Polônia, Republica da', 'PL', 6033)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(173, 'Portugal', 'Portugal', 'PT', 6076)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(174, 'Puerto Rico', 'Porto Rico', 'PR', 6114)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(175, 'Qatar', 'Catar', 'QA', 1546)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(176, 'Reunion', 'Reunião, Ilha', 'RE', 6602)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(177, 'Romania', 'Romênia', 'RO', 6700)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(178, 'Russian Federation', 'Rússia, Federação da', 'RU', 6769)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(179, 'Rwanda', 'Ruanda', 'RW', 6750)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(180, 'Saint Kitts and Nevis', 'São Cristovão e Neves, Ilhas', 'KN', 6955)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(181, 'Saint LUCIA', 'Santa Lucia', 'LC', 7153)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(182, 'Saint Vincent and the Grenadines', 'São Vicente e Granadinas', 'VC', 7056)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(183, 'Samoa', 'Samoa', 'WS', 6904)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(184, 'San Marino', 'San Marino', 'SM', 6971)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(185, 'Sao Tome and Principe', 'São Tome e Príncipe, Ilhas', 'ST', 7200)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(186, 'Saudi Arabia', 'Arábia Saudita', 'SA', 531)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(187, 'Senegal', 'Senegal', 'SN', 7285)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(188, 'Seychelles', 'Seychelles', 'SC', 7315)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(189, 'Sierra Leone', 'Serra Leoa', 'SL', 7358)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(190, 'Singapore', 'Cingapura', 'SG', 7412)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(191, 'Slovakia (Slovak Republic)', 'Eslovaca, Republica', 'SK', 2470)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(192, 'Slovenia', 'Eslovênia, Republica da', 'SI', 2461)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(193, 'Solomon Islands', 'Salomão, Ilhas', 'SB', 6777)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(194, 'Somalia', 'Somalia', 'SO', 7480)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(195, 'South Africa', 'África do Sul', 'ZA', 7560)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(196, 'South Georgia and the South Sandwich Islands', 'Ilhas Geórgia do Sul e Sandwich do Sul', 'GS', 2925)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(197, 'Spain', 'Espanha', 'ES', 2453)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(198, 'Sri Lanka', 'Sri Lanka', 'LK', 7501)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(199, 'St. Helena', 'Santa Helena', 'SH', 7102)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(200, 'St. Pierre and Miquelon', 'São Pedro e Miquelon', 'PM', 7005)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(201, 'Sudan', 'Sudão', 'SD', 7595)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(202, 'Suriname', 'Suriname', 'SR', 7706)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(203, 'Svalbard and Jan Mayen Islands', 'Svalbard e Jan Mayen', 'SJ', 7552)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(204, 'Swaziland', 'Eswatini', 'SZ', 7544)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(205, 'Sweden', 'Suécia', 'SE', 7641)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(206, 'Switzerland', 'Suíça', 'CH', 7676)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(207, 'Syrian Arab Republic', 'Síria, Republica Árabe da', 'SY', 7447)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(208, 'Taiwan, Province of China', 'Formosa (Taiwan)', 'TW', 1619)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(209, 'Tajikistan', 'Tadjiquistao, Republica do', 'TJ', 7722)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(210, 'Tanzania, United Republic of', 'Tanzânia, Republica Unida da', 'TZ', 7803)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(211, 'Thailand', 'Tailândia', 'TH', 7765)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(212, 'Togo', 'Togo', 'TG', 8001)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(213, 'Tokelau', 'Toquelau, Ilhas', 'TK', 8052)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(214, 'Tonga', 'Tonga', 'TO', 8109)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(215, 'Trinidad and Tobago', 'Trinidad e Tobago', 'TT', 8150)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(216, 'Tunisia', 'Tunísia', 'TN', 8206)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(217, 'Turkey', 'Turquia', 'TR', 8273)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(218, 'Turkmenistan', 'Turcomenistão, Republica do', 'TM', 8249)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(219, 'Turks and Caicos Islands', 'Turcas e Caicos, Ilhas', 'TC', 8230)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(220, 'Tuvalu', 'Tuvalu', 'TV', 8281)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(221, 'Uganda', 'Uganda', 'UG', 8338)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(222, 'Ukraine', 'Ucrânia', 'UA', 8311)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(223, 'United Arab Emirates', 'Emirados Árabes Unidos', 'AE', 2445)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(224, 'United Kingdom', 'Reino Unido', 'GB', 6289)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(225, 'United States', 'Estados Unidos', 'US', 2496)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(226, 'United States Minor Outlying Islands', 'Ilhas Menores Distantes dos Estados Unidos', 'UM', 18664)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(227, 'Uruguay', 'Uruguai', 'UY', 8451)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(228, 'Uzbekistan', 'Uzbequistão, Republica do', 'UZ', 8478)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(229, 'Vanuatu', 'Vanuatu', 'VU', 5517)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(230, 'Venezuela', 'Venezuela', 'VE', 8508)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(231, 'Viet Nam', 'Vietnã', 'VN', 8583)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(232, 'Virgin Islands (British)', 'Virgens, Ilhas (Britânicas)', 'VG', 8630)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(233, 'Virgin Islands (U.S.)', 'Virgens, Ilhas (E.U.A.)', 'VI', 8664)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(234, 'Wallis and Futuna Islands', 'Wallis e Futuna, Ilhas', 'WF', 8753)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(235, 'Western Sahara', 'Saara Ocidental', 'EH', 6858)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(236, 'Yemen', 'Iémen', 'YE', 3573)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(237, 'Yugoslavia', 'Iugoslávia, República Fed. da', 'YU', 3883)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(238, 'Zambia', 'Zâmbia', 'ZM', 8907)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(239, 'Zimbabwe', 'Zimbabue', 'ZW', 6653)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(240, 'Bailiwick of Guernsey', 'Guernsey, Ilha do Canal (Inclui Alderney e Sark)', 'GG', 1504)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(241, 'Bailiwick of Jersey', 'Jersey, Ilha do Canal', 'JE', 1508)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(243, 'Isle of Man', 'Man, Ilha de', 'IM', 3595)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(246, 'Crna Gora (Montenegro)', 'Montenegro', 'ME', 4985)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(247, 'SÉRVIA', 'Republika Srbija', 'RS', 7370)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(248, 'Republic of South Sudan', 'Sudao do Sul', 'SS', 7600)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(249, 'Zona del Canal de Panamá', 'Zona do Canal do Panamá', NULL, 8958)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(252, 'Dawlat Filasṭīn', 'Palestina', 'PS', 5780)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(253, 'Åland Islands', 'Aland, Ilhas', 'AX', 153)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(255, 'Curaçao', 'Curaçao', 'CW', 200)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(256, 'Saint Martin', 'São Martinho, Ilha de (Parte Holandesa)', 'SM', 6998)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(258, 'Bonaire', 'Bonaire', 'AN', 990)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(259, 'Antartica', 'Antartica', 'AQ', 420)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(260, 'Heard Island and McDonald Islands', 'Ilha Herad e Ilhas Macdonald', 'AU', 3433)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(261, 'Saint-Barthélemy', 'São Bartolomeu', 'FR', 6939)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(262, 'Saint Martin', 'São Martinho, Ilha de (Parte Francesa)', 'SM', 6980)
INSERT INTO tb_country (id, name, name_pt, abbreviation, country_code) VALUES(263, 'Terres Australes et Antarctiques Françaises', 'Terras Austrais e Antárcticas Francesas', 'TF', 7811);
