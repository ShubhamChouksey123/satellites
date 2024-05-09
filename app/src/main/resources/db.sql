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




INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DLR-TUBSAT', 'Germany', '1999-05-26', '45', 'PSLV-C2');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('KITSAT-3', 'REPUBLIC OF KOREA', '1999-05-26', '110', 'PSLV-C2');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('BIRD', 'GERMANY', '2001-10-22', '92', 'PSLV-C3');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PROBA', 'BELGIUM', '2001-10-22', '94', 'PSLV-C3');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LAPAN-TUBSAT', 'INDONESIA', '2007-07-10', '56', 'PSLV-C7');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PEHUENSAT-1', 'ARGENTINA', '2007-07-10', '6', 'PSLV-C7');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AGILE', 'ITALY', '2007-04-23', '350', 'PSLV-C8');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('TESCAR', 'ISRAEL', '2008-01-21', '300', 'PSLV-C10');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CAN-X2', 'CANADA', '2008-04-28', '7', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUTE-1.7', 'JAPAN', '2008-04-28', '5', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DELFI-C3', 'THE NETHERLANDS', '2008-04-28', '6.5', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AAUSAT-II', 'DENMARK', '2008-04-28', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('COMPASS-I', 'GERMANY', '2008-04-28', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SEEDS', 'JAPAN', '2008-04-28', '3', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLSS', 'CANADA', '2008-04-28', '16', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-8', 'GERMANY', '2008-04-28', '8', 'PSLV-C9');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-1', 'GERMANY', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-2', 'GERMANY', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-3', 'TURKEY', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CUBESAT-4', 'SWITZERLAND', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-9.1', 'GERMANY', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('RUBIN-9.2', 'GERMANY', '2009-09-23', '1', 'PSLV-C14');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('ALSAT-2A', 'ALGERIA', '2010-07-12', '116', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS6.1 AISSAT-1', 'NORWAY', '2010-07-12', '6.5', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS6.2 TISAT-1', 'SWITZERLAND', '2010-07-12', '1', 'PSLV-C15');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('X-SAT', 'SINGAPORE', '2011-04-20', '106', 'PSLV-C16');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VesselSat-1', 'LUXEMBOURG', '2011-10-12', '28.7', 'PSLV-C18');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SPOT-6', 'FRANCE', '2012-09-09', '712', 'PSLV-C21');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('PROITERES', 'JAPAN', '2012-09-09', '15', 'PSLV-C21');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SAPPHIRE', 'CANADA', '2013-02-25', '148', 'PSLV-C20');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('SPOT-7', 'FRANCE', '2014-06-30', '714', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AISAT', 'GERMANY', '2014-06-30', '14', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS7.1(CAN-X4)', 'CANADA', '2014-06-30', '15', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS7.2(CAN-X5)', 'CANADA', '2014-06-30', '15', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-1', 'SINGAPORE', '2014-06-30', '7', 'PSLV-C23');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('AMAZONIA-1', 'BRAZIL', '2021-02-28', '637', 'PSLV-C51');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-1', 'UK', '2015-07-10', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-2', 'UK', '2015-07-10', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('DMC3-3', 'UK', '2015-07-10', '447', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('CBNT-1', 'UK', '2015-07-10', '91', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('De-OrbitSail', 'UK', '2015-07-10', '7', 'PSLV-C28');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LAPAN-A2', 'INDONESIA', '2015-09-28', '76', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('NLS-14(Ev9)', 'CANADA', '2015-09-28', '14', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-1', 'USA', '2015-09-28', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-2', 'USA', '2015-09-28', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-3', 'USA', '2015-09-28', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('LEMUR-4', 'USA', '2015-09-28', '7', 'PSLV-C30');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('TeLEOS', 'SINGAPORE', '2015-12-16', '400', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Kent Ridge-I', 'SINGAPORE', '2015-12-16', '78', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-C1', 'SINGAPORE', '2015-12-16', '123', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('VELOX-II', 'SINGAPORE', '2015-12-16', '13', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Galassia', 'SINGAPORE', '2015-12-16', '3.4', 'PSLV-C29');
INSERT INTO customer_satellites (id, country, launch_date, mass, launcher) VALUES ('Athenoxat-I', 'SINGAPORE', '2015-12-16', '21', 'PSLV-C29');




UPDATE public.customer_satellites
	SET created_at = '2024-05-09 22:50:35.258'
	WHERE created_at IS NULL;