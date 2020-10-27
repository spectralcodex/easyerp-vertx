--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)

-- Started on 2020-10-26 14:56:30 GMT

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
-- TOC entry 3002 (class 1262 OID 16385)
-- Name: impala; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE impala WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE impala OWNER TO postgres;

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
-- TOC entry 210 (class 1255 OID 16400)
-- Name: fn_get_now(); Type: FUNCTION; Schema: public; Owner: impala
--

CREATE FUNCTION public.fn_get_now() RETURNS character varying
    LANGUAGE plpgsql
    AS $$
declare
BEGIN
   RETURN to_char(current_timestamp, 'HH12:MI:SS');
END;
$$;


ALTER FUNCTION public.fn_get_now() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16403)
-- Name: tb_accomodation; Type: TABLE; Schema: public; Owner: impala
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


ALTER TABLE public.tb_accomodation OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16401)
-- Name: tb_accomodation_id_seq; Type: SEQUENCE; Schema: public; Owner: impala
--

CREATE SEQUENCE public.tb_accomodation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_accomodation_id_seq OWNER TO postgres;

--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 204
-- Name: tb_accomodation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: impala
--

ALTER SEQUENCE public.tb_accomodation_id_seq OWNED BY public.tb_accomodation.id;


--
-- TOC entry 207 (class 1259 OID 16415)
-- Name: tb_property_amenity; Type: TABLE; Schema: public; Owner: impala
--

CREATE TABLE public.tb_property_amenity (
    id bigint NOT NULL,
    "serialNumber" character varying(255) NOT NULL,
    amenity character varying(255),
    status character varying(5),
    "createdOn" timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "createdBy" character varying(255) NOT NULL
);


ALTER TABLE public.tb_property_amenity OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16413)
-- Name: tb_property_amenity_id_seq; Type: SEQUENCE; Schema: public; Owner: impala
--

CREATE SEQUENCE public.tb_property_amenity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_property_amenity_id_seq OWNER TO postgres;

--
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 206
-- Name: tb_property_amenity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: impala
--

ALTER SEQUENCE public.tb_property_amenity_id_seq OWNED BY public.tb_property_amenity.id;


--
-- TOC entry 209 (class 1259 OID 16427)
-- Name: tb_property_profile; Type: TABLE; Schema: public; Owner: impala
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
    "createdBy" character varying(255)
);


ALTER TABLE public.tb_property_profile OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16425)
-- Name: tb_property_profile_id_seq; Type: SEQUENCE; Schema: public; Owner: impala
--

CREATE SEQUENCE public.tb_property_profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_property_profile_id_seq OWNER TO postgres;

--
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 208
-- Name: tb_property_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: impala
--

ALTER SEQUENCE public.tb_property_profile_id_seq OWNED BY public.tb_property_profile.id;


--
-- TOC entry 203 (class 1259 OID 16388)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: impala
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


ALTER TABLE public.tb_user OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16386)
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: impala
--

CREATE SEQUENCE public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_user_id_seq OWNER TO postgres;

--
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: impala
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- TOC entry 2857 (class 2604 OID 16406)
-- Name: tb_accomodation id; Type: DEFAULT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_accomodation ALTER COLUMN id SET DEFAULT nextval('public.tb_accomodation_id_seq'::regclass);


--
-- TOC entry 2859 (class 2604 OID 16418)
-- Name: tb_property_amenity id; Type: DEFAULT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_property_amenity ALTER COLUMN id SET DEFAULT nextval('public.tb_property_amenity_id_seq'::regclass);


--
-- TOC entry 2861 (class 2604 OID 16430)
-- Name: tb_property_profile id; Type: DEFAULT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_property_profile ALTER COLUMN id SET DEFAULT nextval('public.tb_property_profile_id_seq'::regclass);


--
-- TOC entry 2855 (class 2604 OID 16391)
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- TOC entry 2866 (class 2606 OID 16411)
-- Name: tb_accomodation tb_accomodation_pkey; Type: CONSTRAINT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_accomodation
    ADD CONSTRAINT tb_accomodation_pkey PRIMARY KEY (id);


--
-- TOC entry 2868 (class 2606 OID 16424)
-- Name: tb_property_amenity tb_property_amenity_pkey; Type: CONSTRAINT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_property_amenity
    ADD CONSTRAINT tb_property_amenity_pkey PRIMARY KEY (id);


--
-- TOC entry 2870 (class 2606 OID 16436)
-- Name: tb_property_profile tb_property_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_property_profile
    ADD CONSTRAINT tb_property_profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2864 (class 2606 OID 16397)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


-- Completed on 2020-10-26 14:56:30 GMT

--
-- PostgreSQL database dump complete
--

