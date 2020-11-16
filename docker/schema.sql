--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-1)

-- Started on 2020-11-13 16:58:23 GMT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE impala;
--
-- TOC entry 3031 (class 1262 OID 16385)
-- Name: impala; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE impala WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


\connect impala

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 210 (class 1255 OID 16386)
-- Name: fn_get_now(); Type: FUNCTION; Schema: public; Owner: -
--

CREATE FUNCTION public.fn_get_now() RETURNS character varying
    LANGUAGE plpgsql
    AS $$
declare
BEGIN
   RETURN to_char(current_timestamp, 'HH12:MI:SS');
END;
$$;


SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16387)
-- Name: tb_accomodation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_accomodation (
    id bigint NOT NULL,
    "serialNumber" character varying(255) NOT NULL,
    name character varying(255),
    abbrevation character varying(10),
    units character varying(255),
    "dormBedsPerRoom" integer,
    "totalAccomodation" integer,
    "createdOn" timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "createdBy" character varying(255)
);


--
-- TOC entry 203 (class 1259 OID 16394)
-- Name: tb_accomodation_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_accomodation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 203
-- Name: tb_accomodation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_accomodation_id_seq OWNED BY public.tb_accomodation.id;


--
-- TOC entry 204 (class 1259 OID 16396)
-- Name: tb_property_amenity; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_property_amenity (
    id bigint NOT NULL,
    "serialNumber" character varying(255) NOT NULL,
    amenity character varying(255),
    status character varying(5),
    "createdOn" timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "createdBy" character varying(255) NOT NULL
);


--
-- TOC entry 205 (class 1259 OID 16403)
-- Name: tb_property_amenity_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_property_amenity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 205
-- Name: tb_property_amenity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_property_amenity_id_seq OWNED BY public.tb_property_amenity.id;


--
-- TOC entry 206 (class 1259 OID 16405)
-- Name: tb_property_profile; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_property_profile (
    id bigint NOT NULL,
    "serialNumber" character varying(255) NOT NULL,
    type character varying(255),
    description text,
    image text,
    name character varying(255),
    phone character varying(50),
    email character varying(255),
    website character varying(255),
    "ownerFirstName" character varying(255),
    "ownerLastName" character varying(255),
    country character varying(255),
    address1 character varying(255),
    address2 character varying(255),
    city character varying(255),
    "postalCode" character varying(6),
    "locationCoordinate" character varying(255),
    "createdOn" timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "createdBy" character varying(255),
    "profileCode" character varying(10)
);


--
-- TOC entry 207 (class 1259 OID 16412)
-- Name: tb_property_profile_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_property_profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 207
-- Name: tb_property_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_property_profile_id_seq OWNED BY public.tb_property_profile.id;


--
-- TOC entry 208 (class 1259 OID 16414)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    "roleId" character varying(255),
    "firstName" character varying(255),
    "lastName" character varying(255),
    email character varying(255),
    mobile character varying(255),
    "hashedPassword" character varying(500),
    "passwordSalt" character varying(255),
    "companyCode" character varying(10),
    "createdOn" timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "createdBy" character varying(255)
);


--
-- TOC entry 209 (class 1259 OID 16421)
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 209
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- TOC entry 2885 (class 2604 OID 16423)
-- Name: tb_accomodation id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_accomodation ALTER COLUMN id SET DEFAULT nextval('public.tb_accomodation_id_seq'::regclass);


--
-- TOC entry 2887 (class 2604 OID 16424)
-- Name: tb_property_amenity id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_property_amenity ALTER COLUMN id SET DEFAULT nextval('public.tb_property_amenity_id_seq'::regclass);


--
-- TOC entry 2889 (class 2604 OID 16425)
-- Name: tb_property_profile id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_property_profile ALTER COLUMN id SET DEFAULT nextval('public.tb_property_profile_id_seq'::regclass);


--
-- TOC entry 2891 (class 2604 OID 16426)
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- TOC entry 2893 (class 2606 OID 16428)
-- Name: tb_accomodation tb_accomodation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_accomodation
    ADD CONSTRAINT tb_accomodation_pkey PRIMARY KEY (id);


--
-- TOC entry 2895 (class 2606 OID 16430)
-- Name: tb_property_amenity tb_property_amenity_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_property_amenity
    ADD CONSTRAINT tb_property_amenity_pkey PRIMARY KEY (id);


--
-- TOC entry 2897 (class 2606 OID 16432)
-- Name: tb_property_profile tb_property_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_property_profile
    ADD CONSTRAINT tb_property_profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2899 (class 2606 OID 16434)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


-- Completed on 2020-11-13 16:58:23 GMT

--
-- PostgreSQL database dump complete
--

