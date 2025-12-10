------------------------------------------
-- 4. PATROCINADORES
------------------------------------------
INSERT INTO patrocinador (nombre_patrocinador, sector_industria, pagina_web) VALUES
('Toyota Gazoo Racing', 'Automoción', 'https://toyotagazooracing.com'), -- ID 1
('Shell Helix', 'Energía y combustibles', 'https://www.shell.com'),       -- ID 2
('Red Bull', 'Bebidas energéticas', 'https://www.redbull.com'),           -- ID 3
('Monster Energy', 'Bebidas energéticas', 'https://www.monsterenergy.com'),-- ID 4
('Castrol', 'Lubricantes', 'https://www.castrol.com');                    -- ID 5

----------------------------------------------
-- 5. RALLIES
----------------------------------------------
INSERT INTO rally (nombre_rally, pais_rally, fecha_comienzo, fecha_fin) VALUES
('Rallye Monte-Carlo', 'Mónaco', '2025-01-23', '2025-01-26'),             -- ID 1
('Rally Sweden', 'Suecia', '2025-02-13', '2025-02-16'),                   -- ID 2
('Safari Rally Kenya', 'Kenia', '2025-03-20', '2025-03-23'),              -- ID 3
('Rally Islas Canarias', 'España', '2025-04-24', '2025-04-27'),           -- ID 4
('Vodafone Rally de Portugal', 'Portugal', '2025-05-15', '2025-05-18'),   -- ID 5
('Rally Italia Sardegna', 'Italia', '2025-06-05', '2025-06-08'),          -- ID 6
('EKO Acropolis Rally', 'Grecia', '2025-06-26', '2025-06-29'),            -- ID 7
('Delfi Rally Estonia', 'Estonia', '2025-07-17', '2025-07-20'),           -- ID 8
('Secti Automotive Rally Finland', 'Finlandia', '2025-07-31', '2025-08-03'), -- ID 9
('Rally del Paraguay', 'Paraguay', '2025-08-28', '2025-08-31'),           -- ID 10
('Rally Chile Bio Bío', 'Chile', '2025-09-11', '2025-09-14'),             -- ID 11
('Central European Rally', 'Alemania/R.Checa/Austria', '2025-10-16', '2025-10-19'), -- ID 12
('Rally Japan', 'Japón', '2025-11-06', '2025-11-09'),                     -- ID 13
('Rally Saudi Arabia', 'Arabia Saudí', '2025-11-27', '2025-11-30');       -- ID 14

------------------------------------------
-- 1. EQUIPOS (Añadido id_rally)
------------------------------------------
INSERT INTO equipo (nombre, director, pais_origen, id_rally) VALUES
('Toyota Gazoo Racing WRT', 'Jari-Matti Latvala', 'Japón', 13),
('Hyundai Shell Mobis WRT', 'Cyril Abiteboul', 'Corea del Sur', 2),
('M-Sport Ford WRT', 'Richard Millener', 'Reino Unido', 1),
('Toksport WRT (Škoda)', 'Serkan Duru', 'Alemania', 12),
('Toyota Gazoo Racing WRT NG', 'Jari-Matti Latvala', 'Japón', 9),
('Citroën Racing (DG Sport)', 'Alain Georges', 'Francia', 1),
('M-Sport Ford WRT (WRC2)', 'Richard Millener', 'Reino Unido', 12),
('Hyundai Motorsport N', 'Cyril Abiteboul', 'Corea del Sur', 2),
('M-Sport Poland', 'Maciej Woda', 'Polonia', 12),
('Castrol Renault (Toksport)', 'Serkan Duru', 'Francia', 1);

------------------------------------------
-- 2. PILOTOS
------------------------------------------
INSERT INTO piloto (nombre, apellido, nacionalidad, fecha_nacimiento, numero_licencia, fecha_caducidad, grupo_sanguineo, numero_dni, letra_dni) VALUES
-- WRC1
('Kalle', 'Rovanperä', 'Finlandia', '2000-10-01', 'FIA-FIN-001', '2025-12-31', 'O+', '12345678', 'Z'),
('Elfyn', 'Evans', 'Reino Unido', '1988-12-28', 'FIA-GBR-002', '2025-12-31', 'A+', '87654321', 'X'),
('Takamoto', 'Katsuta', 'Japón', '1993-03-17', 'FIA-JPN-003', '2026-12-31', 'B+', '45678912', 'M'),
('Thierry', 'Neuville', 'Bélgica', '1988-06-16', 'FIA-BEL-004', '2025-12-31', 'O+', '98765432', 'J'),
('Ott', 'Tänak', 'Estonia', '1987-10-15', 'FIA-EST-005', '2025-12-31', 'A-', '11223344', 'P'),
('Esapekka', 'Lappi', 'Finlandia', '1991-01-17', 'FIA-FIN-006', '2025-12-31', 'O-', '55667788', 'L'),
('Adrien', 'Fourmaux', 'Francia', '1995-12-03', 'FIA-FRA-007', '2026-12-31', 'A+', '99887766', 'K'),
('Grégoire', 'Munster', 'Luxemburgo', '1998-12-24', 'FIA-LUX-008', '2025-12-31', 'B+', '22334455', 'H'),
('Sébastien', 'Ogier', 'Francia', '1983-12-17', 'FIA-FRA-009', '2025-12-31', 'A+', '66778899', 'C'),
('Sami', 'Pajari', 'Finlandia', '2001-12-01', 'FIA-FIN-010', '2026-12-31', 'O+', '33445566', 'S'),
('Joshua', 'McErlean', 'Irlanda', '1999-01-01', 'FIA-IRL-011', '2025-12-31', 'AB-', '77889900', 'V'),
('Mārtiņš', 'Sesks', 'Letonia', '1999-09-18', 'FIA-LVA-012', '2026-12-31', 'B+', '44556677', 'B'),
('Nasser', 'Al-Attiyah', 'Qatar', '1970-12-21', 'FIA-QAT-013', '2025-12-31', 'O-', '55443322', 'N'),

-- WRC2
('Robert', 'Virves', 'Estonia', '2000-07-08', 'FIA-EST-014', '2025-12-31', 'A+', '66554433', 'Y'),
('Gus', 'Greensmith', 'Reino Unido', '1996-12-20', 'FIA-GBR-015', '2025-12-31', 'O+', '10293847', 'R'),
('Nikolay', 'Gryazin', 'Bulgaria', '1997-10-07', 'FIA-BUL-016', '2026-12-31', 'B-', '56473829', 'D'),
('Daniel', 'Chwist', 'Polonia', '1977-05-24', 'FIA-POL-017', '2025-12-31', 'O+', '19283746', 'F'),
('Alejandro', 'Mauro', 'México', '2001-01-01', 'FIA-MEX-018', '2026-12-31', 'A-', '91827364', 'G'),
('Abdulaziz', 'Al-Kuwari', 'Qatar', '1979-11-13', 'FIA-QAT-019', '2025-12-31', 'AB+', '38475610', 'H'),
('Miguel', 'Granados', 'México', '1980-05-15', 'FIA-MEX-020', '2025-12-31', 'O+', '29384756', 'J'),
('Gaurav', 'Gill', 'India', '1981-12-02', 'FIA-IND-021', '2025-12-31', 'B+', '47586920', 'K'),
('Ihab', 'Al-Shurafa', 'Jordania', '1985-03-10', 'FIA-JOR-022', '2026-12-31', 'A+', '58693021', 'L'),
('Oliver', 'Solberg', 'Suecia', '2001-09-23', 'FIA-SWE-023', '2025-12-31', 'A+', '20394857', 'Z'),
('Roope', 'Korhonen', 'Finlandia', '1998-01-01', 'FIA-FIN-024', '2025-12-31', 'O-', '39485760', 'X'),
('Jan', 'Solans', 'España', '1997-12-25', 'FIA-ESP-025', '2026-12-31', 'A+', '48596071', 'C'),
('Kajetan', 'Kajetanowicz', 'Polonia', '1979-04-12', 'FIA-POL-026', '2025-12-31', 'B+', '59607182', 'V'),
('Alejandro', 'Cachón', 'España', '1999-03-24', 'FIA-ESP-027', '2026-12-31', 'O+', '60718293', 'B'),
('Fabio', 'Schwarz', 'Alemania', '2005-01-01', 'FIA-DEU-028', '2025-12-31', 'AB-', '71829304', 'N'),
('Diego', 'Domínguez', 'Paraguay', '2000-04-17', 'FIA-PRY-029', '2026-12-31', 'A-', '82930415', 'M'),
('Hamzah', 'Bakhashab', 'Arabia Saudí', '1990-06-20', 'FIA-SAU-030', '2025-12-31', 'O+', '93041526', 'Q'),
('Miguel', 'Díaz-Aboitiz', 'España', '1965-01-01', 'FIA-ESP-031', '2025-12-31', 'B-', '04152637', 'W'),
('Pablo', 'Sarrazin', 'Francia', '2005-01-01', 'FIA-FRA-032', '2026-12-31', 'A+', '15263748', 'E'),
('Adrien', 'Mosca', 'Francia', '1996-08-12', 'FIA-FRA-033', '2025-12-31', 'O+', '26374859', 'R'),
('Nasser', 'Khalifa Al-Atya', 'Qatar', '1965-01-01', 'FIA-QAT-034', '2025-12-31', 'AB+', '37485960', 'T'),

-- WRC3
('Matteo', 'Fontana', 'Italia', '2003-01-01', 'FIA-ITA-035', '2026-12-31', 'A+', '48596072', 'Y'),
('Naveen', 'Pulligilla', 'India', '1995-02-14', 'FIA-IND-036', '2025-12-31', 'B+', '59607183', 'U'),
('Philipos', 'Matthai', 'India', '1988-11-30', 'FIA-IND-037', '2025-12-31', 'O-', '60718294', 'I'),
('Burcu', 'Çetinkaya', 'Turquía', '1981-03-19', 'FIA-TUR-038', '2025-12-31', 'A-', '71829305', 'O'),
('Saeed', 'Al-Mouri', 'Arabia Saudí', '1982-09-05', 'FIA-SAU-039', '2026-12-31', 'O+', '82930416', 'P');

-------------------------------------------------
-- 3. COCHES (Añadido id_patrocinador)
-------------------------------------------------
INSERT INTO coche (modelo, dorsal, motor, categoria, potencia_cv, par_motor_nm, cilindrada_cc, es_hibrido, id_equipo, id_piloto, id_patrocinador) VALUES
-- TOYOTA RALLY1 (Sponsor 1: Toyota Gazoo)
('Toyota GR Yaris Rally1', 33, 'G16E-GTS Hybrid 1.6L', 'RALLY1', 520, 500, 1600, TRUE, 1, 2, 1),
('Toyota GR Yaris Rally1', 17, 'G16E-GTS Hybrid 1.6L', 'RALLY1', 520, 500, 1600, TRUE, 1, 9, 1),
('Toyota GR Yaris Rally1', 69, 'G16E-GTS Hybrid 1.6L', 'RALLY1', 520, 500, 1600, TRUE, 1, 1, 1),
('Toyota GR Yaris Rally1', 18, 'G16E-GTS Hybrid 1.6L', 'RALLY1', 520, 500, 1600, TRUE, 1, 3, 1),
('Toyota GR Yaris Rally1', 5, 'G16E-GTS Hybrid 1.6L', 'RALLY1', 520, 500, 1600, TRUE, 1, 10, 1),

-- HYUNDAI RALLY1 (Sponsor 2: Shell Helix)
('Hyundai i20 N Rally1', 8, 'T-GDI Hybrid 1.6L', 'RALLY1', 525, 510, 1600, TRUE, 2, 5, 2),
('Hyundai i20 N Rally1', 11, 'T-GDI Hybrid 1.6L', 'RALLY1', 525, 510, 1600, TRUE, 2, 4, 2),
('Hyundai i20 N Rally1', 16, 'T-GDI Hybrid 1.6L', 'RALLY1', 525, 510, 1600, TRUE, 2, 7, 2),

-- FORD PUMA RALLY1 (Sponsor 3: Red Bull)
('Ford Puma Rally1', 55, 'EcoBoost Hybrid 1.6L', 'RALLY1', 515, 495, 1600, TRUE, 3, 11, 3),
('Ford Puma Rally1', 13, 'EcoBoost Hybrid 1.6L', 'RALLY1', 515, 495, 1600, TRUE, 3, 8, 3),
('Ford Puma Rally1', 22, 'EcoBoost Hybrid 1.6L', 'RALLY1', 515, 495, 1600, TRUE, 3, 12, 3),
('Ford Puma Rally1', 20, 'EcoBoost Hybrid 1.6L', 'RALLY1', 515, 495, 1600, TRUE, 3, 13, 3),

-- SKODA FABIA RALLY2 (Sponsor 5: Castrol)
('Škoda Fabia RS Rally2', 24, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 14, 5),
('Škoda Fabia RS Rally2', 25, '1.6 Turbo 4-cyl', 'RALLY2', 290, 430, 1620, FALSE, 4, 15, 5),
('Škoda Fabia RS Rally2', 26, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 16, 5),
('Škoda Fabia RS Rally2', 31, '1.6 Turbo 4-cyl', 'RALLY2', 290, 430, 1620, FALSE, 4, 17, 5),
('Škoda Fabia RS Rally2', 35, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 18, 5),
('Škoda Fabia RS Rally2', 36, '1.6 Turbo 4-cyl', 'RALLY2', 290, 430, 1620, FALSE, 4, 19, 5),
('Škoda Fabia RS Rally2', 38, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 20, 5),

-- SKODA FABIA EVO (Sponsor 4: Monster)
('Škoda Fabia Evo Rally2', 47, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 21, 4),
('Škoda Fabia Evo Rally2', 48, '1.6 Turbo 4-cyl', 'RALLY2', 290, 390, 1620, FALSE, 4, 22, 4),

-- TOYOTA YARIS RALLY2 (Sponsor 1: Toyota)
('Toyota GR Yaris Rally2', 21, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 23, 1),
('Toyota GR Yaris Rally2', 23, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 24, 1),
('Toyota GR Yaris Rally2', 27, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 25, 1),
('Toyota GR Yaris Rally2', 28, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 26, 1),
('Toyota GR Yaris Rally2', 29, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 27, 1),
('Toyota GR Yaris Rally2', 32, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 28, 1),
('Toyota GR Yaris Rally2', 34, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 29, 1),
('Toyota GR Yaris Rally2', 37, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 30, 1),
('Toyota GR Yaris Rally2', 40, '1.6 Turbo 3-cyl', 'RALLY2', 290, 420, 1618, FALSE, 5, 31, 1),

-- CITROEN & FORD RALLY2 (Sponsor 5: Castrol)
('Citroën C3 Rally2', 23, '1.6 Turbo THP', 'RALLY2', 295, 400, 1598, FALSE, 6, 32, 5),
('Citroën C3 Rally2', 27, '1.6 Turbo THP', 'RALLY2', 295, 400, 1598, FALSE, 6, 33, 5),
('Ford Fiesta Mk II Rally2', 22, '1.6 EcoBoost Turbo', 'RALLY2', 290, 400, 1598, FALSE, 7, 34, 5),

-- RALLY3 (Sponsor 4: Monster)
('Ford Fiesta Rally3', 41, '1.5 EcoBoost 3-cyl', 'RALLY3', 235, 400, 1497, FALSE, 9, 35, 4),
('Ford Fiesta Rally3', 45, '1.5 EcoBoost 3-cyl', 'RALLY3', 235, 400, 1497, FALSE, 9, 36, 4),
('Ford Fiesta Rally3', 49, '1.5 EcoBoost 3-cyl', 'RALLY3', 235, 400, 1497, FALSE, 9, 37, 4),
('Renault Clio Rally3', 61, '1.3 TCe 4-cyl 16V', 'RALLY3', 260, 415, 1332, FALSE, 10, 38, 4),
('Renault Clio Rally3', 62, '1.3 TCe 4-cyl 16V', 'RALLY3', 260, 415, 1332, FALSE, 10, 39, 4);

------------------------------------------
-- 6. TRAMOS
------------------------------------------
INSERT INTO tramo (nombre_tramo, distancia_km, superficie, clima, hora, latitud, longitud, altitud_sobre_el_mar, id_rally) VALUES
('La Bollène-Vésubie / Col de Turini', 17.25, 'ASFALTO', 'CON_NUBES', 13.30, 43.9875, 7.3932, 1607, 1),
('Sarsjöliden', 14.23, 'NIEVE', 'NIEVE', 14.15, 64.1950, 19.5700, 280, 2),
('Sleeping Warrior', 31.04, 'TIERRA', 'LLUVIA', 15.45, -0.4350, 36.2400, 1950, 3),
('San Mateo - Valsequillo', 15.00, 'ASFALTO', 'DESPEJADO', 12.00, 28.0102, -15.5340, 850, 4),
('Fafe', 11.18, 'TIERRA', 'DESPEJADO', 14.30, 41.4905, -8.1102, 650, 5),
('Monte Lerno - Sa Conchedda', 17.20, 'TIERRA', 'DESPEJADO', 16.10, 40.5833, 9.2333, 750, 6),
('Tarzan', 23.37, 'TIERRA', 'CON_NUBES', 13.50, 38.9600, 21.8500, 880, 7),
('Otepää', 11.15, 'TIERRA', 'NUBLADO', 15.20, 58.0580, 26.5000, 152, 8),
('Ouninpohja', 32.98, 'TIERRA', 'CON_NUBES', 17.05, 61.8050, 25.0450, 160, 9),
('Carmen del Paraná', 18.50, 'TIERRA', 'LLUVIA', 13.15, -27.2250, -56.1550, 110, 10),
('Maria Las Cruces', 28.40, 'TIERRA', 'NIEBLA', 12.45, -37.2000, -73.1000, 250, 11),
('Klatovy', 11.70, 'ASFALTO', 'NUBLADO', 14.40, 49.3955, 13.2930, 405, 12),
('Isegami''s Tunnel', 23.60, 'ASFALTO', 'LLUVIA', 16.55, 35.1380, 137.4600, 680, 13),
('Jeddah Desert Stage', 24.50, 'TIERRA', 'DESPEJADO', 17.30, 21.5433, 39.1900, 80, 14);

--------------------------------------------------------
-- 7. INSCRIPCIONES (Añadido id_tramo)
--------------------------------------------------------
-- Se distribuyen las inscripciones entre los tramos disponibles para variar los datos
INSERT INTO inscripcion (numero_entrada, categoria, piloto_id, id_tramo) VALUES
(1, 'RALLY1', 4, 1),
(2, 'RALLY1', 2, 1),
(3, 'RALLY1', 5, 2),
(4, 'RALLY1', 9, 2),
(5, 'RALLY1', 7, 3),
(6, 'RALLY1', 3, 3),
(7, 'RALLY1', 1, 4),
(8, 'RALLY1', 8, 4),
(9, 'RALLY1', 10, 5),
(10, 'RALLY1', 13, 5),
(11, 'RALLY1', 12, 6),
(12, 'RALLY1', 11, 6),

(13, 'RALLY2', 23, 7),
(14, 'RALLY2', 24, 7),
(15, 'RALLY2', 14, 8),
(16, 'RALLY2', 15, 8),
(17, 'RALLY2', 16, 9),
(18, 'RALLY2', 25, 9),
(19, 'RALLY2', 26, 10),
(20, 'RALLY2', 27, 10),
(21, 'RALLY2', 32, 11),
(22, 'RALLY2', 17, 11),
(23, 'RALLY2', 28, 12),
(24, 'RALLY2', 29, 12),
(25, 'RALLY2', 18, 13),
(26, 'RALLY2', 19, 13),
(27, 'RALLY2', 30, 14),
(28, 'RALLY2', 20, 14),
(29, 'RALLY2', 34, 1),
(30, 'RALLY2', 31, 2),
(31, 'RALLY2', 33, 3),
(32, 'RALLY2', 21, 4),
(33, 'RALLY2', 22, 5),

(34, 'RALLY3', 35, 6),
(35, 'RALLY3', 38, 7),
(36, 'RALLY3', 39, 8),
(37, 'RALLY3', 36, 9),
(38, 'RALLY3', 37, 10);