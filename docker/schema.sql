--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)

-- Started on 2020-09-25 17:23:20 GMT

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

DROP DATABASE IF EXISTS impala;
--
-- TOC entry 2969 (class 1262 OID 16385)
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
-- TOC entry 204 (class 1255 OID 16400)
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
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: impala
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- TOC entry 2834 (class 2604 OID 16391)
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- TOC entry 2837 (class 2606 OID 16397)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: impala
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


-- Completed on 2020-09-25 17:23:20 GMT

--
-- PostgreSQL database dump complete
--

