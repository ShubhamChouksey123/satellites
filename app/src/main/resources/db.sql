-- Table: public.customer_satellites

-- DROP TABLE IF EXISTS public.customer_satellites;

CREATE TABLE IF NOT EXISTS public.customer_satellites
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    country character varying(255) COLLATE pg_catalog."default",
    created_at timestamp(6) without time zone,
    launch_date timestamp(6) without time zone,
    launcher character varying(255) COLLATE pg_catalog."default",
    mass double precision,
    CONSTRAINT customer_satellites_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer_satellites
    OWNER to postgres;



INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DLR-TUBSAT', 'Germany', '26-05-1999', '45', 'PSLV-C2');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('KITSAT-3', 'REPUBLIC OF KOREA', '26-05-1999', '110', 'PSLV-C2');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('BIRD', 'GERMANY', '22-10-2001', '92', 'PSLV-C3');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PROBA', 'BELGIUM', '22-10-2001', '94', 'PSLV-C3');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LAPAN-TUBSAT', 'INDONESIA', '10-07-2007', '56', 'PSLV-C7');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PEHUENSAT-1', 'ARGENTINA', '10-07-2007', '6', 'PSLV-C7');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AGILE', 'ITALY', '23-04-2007', '350', 'PSLV-C8');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('TESCAR', 'ISRAEL', '21-01-2008', '300', 'PSLV-C10');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CAN-X2', 'CANADA', '28-04-2008', '7', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUTE-1.7', 'JAPAN', '28-04-2008', '5', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DELFI-C3', 'THE NETHERLANDS', '28-04-2008', '6.5', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AAUSAT-II', 'DENMARK', '28-04-2008', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('COMPASS-I', 'GERMANY', '28-04-2008', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SEEDS', 'JAPAN', '28-04-2008', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLSS', 'CANADA', '28-04-2008', '16', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-8', 'GERMANY', '28-04-2008', '8', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-1', 'GERMANY', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-2', 'GERMANY', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-3', 'TURKEY', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-4', 'SWITZERLAND', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-9.1', 'GERMANY', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-9.2', 'GERMANY', '23-09-2009', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('ALSAT-2A', 'ALGERIA', '12-07-2010', '116', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS6.1 AISSAT-1', 'NORWAY', '12-07-2010', '6.5', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS6.2 TISAT-1', 'SWITZERLAND', '12-07-2010', '1', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('X-SAT', 'SINGAPORE', '20-04-2011', '106', 'PSLV-C16');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VesselSat-1', 'LUXEMBOURG', '12-10-2011', '28.7', 'PSLV-C18');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SPOT-6', 'FRANCE', '09-09-2012', '712', 'PSLV-C21');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PROITERES', 'JAPAN', '09-09-2012', '15', 'PSLV-C21');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SAPPHIRE', 'CANADA', '25-02-2013', '148', 'PSLV-C20');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SPOT-7', 'FRANCE', '30-06-2014', '714', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AISAT', 'GERMANY', '30-06-2014', '14', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS7.1(CAN-X4)', 'CANADA', '30-06-2014', '15', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS7.2(CAN-X5)', 'CANADA', '30-06-2014', '15', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-1', 'SINGAPORE', '30-06-2014', '7', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AMAZONIA-1', 'BRAZIL', '28-02-2021', '637', 'PSLV-C51');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-1', 'UK', '10-07-2015', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-2', 'UK', '10-07-2015', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-3', 'UK', '10-07-2015', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CBNT-1', 'UK', '10-07-2015', '91', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('De-OrbitSail', 'UK', '10-07-2015', '7', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LAPAN-A2', 'INDONESIA', '28-09-2015', '76', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS-14(Ev9)', 'CANADA', '28-09-2015', '14', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-1', 'USA', '28-09-2015', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-2', 'USA', '28-09-2015', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-3', 'USA', '28-09-2015', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-4', 'USA', '28-09-2015', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('TeLEOS', 'SINGAPORE', '16-12-2015', '400', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Kent Ridge-I', 'SINGAPORE', '16-12-2015', '78', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-C1', 'SINGAPORE', '16-12-2015', '123', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-II', 'SINGAPORE', '16-12-2015', '13', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Galassia', 'SINGAPORE', '16-12-2015', '3.4', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Athenoxat-I', 'SINGAPORE', '16-12-2015', '', 'PSLV-C29');
