--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-05-08 10:55:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 24673)
-- Name: certificate; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE certificate (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    images character varying(255) NOT NULL
);


ALTER TABLE certificate OWNER TO "my-resume";

--
-- TOC entry 197 (class 1259 OID 24687)
-- Name: certificate_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE certificate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE certificate_seq OWNER TO "my-resume";

--
-- TOC entry 194 (class 1259 OID 24653)
-- Name: course; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE course (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    school character varying(255) NOT NULL,
    finich_date date
);


ALTER TABLE course OWNER TO "my-resume";

--
-- TOC entry 195 (class 1259 OID 24671)
-- Name: course_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE course_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE course_seq OWNER TO "my-resume";

--
-- TOC entry 198 (class 1259 OID 24689)
-- Name: education; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE education (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    university character varying(255) NOT NULL,
    faculty character varying(255) NOT NULL,
    begin_year integer NOT NULL,
    finish_year integer
);


ALTER TABLE education OWNER TO "my-resume";

--
-- TOC entry 199 (class 1259 OID 24702)
-- Name: education_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE education_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education_seq OWNER TO "my-resume";

--
-- TOC entry 192 (class 1259 OID 24646)
-- Name: hobby; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE hobby (
    id character varying(1) NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE hobby OWNER TO "my-resume";

--
-- TOC entry 193 (class 1259 OID 24651)
-- Name: hobby_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE hobby_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hobby_seq OWNER TO "my-resume";

--
-- TOC entry 190 (class 1259 OID 24631)
-- Name: language; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE language (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    type character varying(255),
    name character varying(255)
);


ALTER TABLE language OWNER TO "my-resume";

--
-- TOC entry 191 (class 1259 OID 24644)
-- Name: language_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE language_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE language_seq OWNER TO "my-resume";

--
-- TOC entry 183 (class 1259 OID 24576)
-- Name: member; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE member (
    id bigint NOT NULL,
    password character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL
);


ALTER TABLE member OWNER TO "my-resume";

--
-- TOC entry 185 (class 1259 OID 24591)
-- Name: member_info; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE member_info (
    id bigint NOT NULL,
    birth_day date,
    phone character varying(255),
    country character varying(255),
    city character varying(255),
    objective character varying(255),
    summary character varying(255),
    photo character varying(255),
    info text,
    status smallint,
    skype character varying(255),
    vkontakte character varying(255),
    facebook character varying(255),
    linkedin character varying(255),
    github character varying(255),
    stackoverflow character varying(255)
);


ALTER TABLE member_info OWNER TO "my-resume";

--
-- TOC entry 184 (class 1259 OID 24589)
-- Name: member_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE member_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE member_seq OWNER TO "my-resume";

--
-- TOC entry 200 (class 1259 OID 24704)
-- Name: practic; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE practic (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    company character varying(255) NOT NULL,
    begin_date date NOT NULL,
    finish_date date,
    responsibilities character varying(255) NOT NULL,
    demo character varying(255),
    src character varying(255)
);


ALTER TABLE practic OWNER TO "my-resume";

--
-- TOC entry 201 (class 1259 OID 24717)
-- Name: practic_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE practic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE practic_seq OWNER TO "my-resume";

--
-- TOC entry 187 (class 1259 OID 24614)
-- Name: skill; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE skill (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description text NOT NULL
);


ALTER TABLE skill OWNER TO "my-resume";

--
-- TOC entry 186 (class 1259 OID 24609)
-- Name: skill_category; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE skill_category (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE skill_category OWNER TO "my-resume";

--
-- TOC entry 188 (class 1259 OID 24622)
-- Name: skill_category_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE skill_category_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE skill_category_seq OWNER TO "my-resume";

--
-- TOC entry 189 (class 1259 OID 24624)
-- Name: skill_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE skill_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE skill_seq OWNER TO "my-resume";

--
-- TOC entry 2202 (class 0 OID 24673)
-- Dependencies: 196
-- Data for Name: certificate; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY certificate (id, member_id, name, images) FROM stdin;
1	1	-1921520779	f97814ed-9df1-4ac0-ad8d-702b732728e4.jpg
2	2	991929333	024a7f49-44a6-4a7e-aaf7-10698ddac38c.jpg
3	5	-1834443016	da86f5b2-abbe-43d5-b382-c9887695651e.jpg
4	6	-255381456	9533784f-8e49-4fe9-ab8a-bbf02f5df23a.jpg
\.


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 197
-- Name: certificate_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('certificate_seq', 4, true);


--
-- TOC entry 2200 (class 0 OID 24653)
-- Dependencies: 194
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY course (id, member_id, name, school, finich_date) FROM stdin;
1	1	-1350914495	-1383226887	\N
2	2	-612164679	1843918905	\N
3	5	1382821408	-1247898081	\N
4	6	-1175613428	335420796	\N
\.


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 195
-- Name: course_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('course_seq', 4, true);


--
-- TOC entry 2204 (class 0 OID 24689)
-- Dependencies: 198
-- Data for Name: education; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY education (id, member_id, name, university, faculty, begin_year, finish_year) FROM stdin;
1	1	957592957	-437318325	-1436586308	1990	1999
2	2	1169563687	1881778317	-526794861	1990	1999
3	5	1856782419	-276369509	-462632525	1990	1999
4	6	-1073251857	-1992647862	319200152	1990	1999
\.


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 199
-- Name: education_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('education_seq', 4, true);


--
-- TOC entry 2198 (class 0 OID 24646)
-- Dependencies: 192
-- Data for Name: hobby; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY hobby (id, member_id, name) FROM stdin;
1	1	-526534608
2	2	-1981249405
3	5	-856349448
4	6	1269916800
\.


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 193
-- Name: hobby_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('hobby_seq', 4, true);


--
-- TOC entry 2196 (class 0 OID 24631)
-- Dependencies: 190
-- Data for Name: language; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY language (id, member_id, type, name) FROM stdin;
1	1	-1319239289	674193709
2	2	-1950204357	-1505885743
3	5	1261427008	195343911
4	6	-1166708506	-560034340
\.


--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 191
-- Name: language_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('language_seq', 4, true);


--
-- TOC entry 2189 (class 0 OID 24576)
-- Dependencies: 183
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY member (id, password, first_name, last_name, email, created) FROM stdin;
1	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Ethan	Mildred	557408666_ethan_mildred@gmail.com	2016-04-30 18:47:40
2	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Lauren	Janet	-156117239_lauren_janet@gmail.com	2016-05-04 09:39:34
5	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Christopher	Ethan	334447551_christopher_ethan@gmail.com	2016-05-04 21:43:30
6	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Patricia	Billy	1773486269_patricia_billy@gmail.com	2016-05-04 21:43:39
\.


--
-- TOC entry 2191 (class 0 OID 24591)
-- Dependencies: 185
-- Data for Name: member_info; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY member_info (id, birth_day, phone, country, city, objective, summary, photo, info, status, skype, vkontakte, facebook, linkedin, github, stackoverflow) FROM stdin;
1	\N	+380507982168	Ukraine	Odessa	-63005033	-1859187023	6932d3d2-086a-42e3-95d4-1acedc85f543.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet 	1	lauren-brittany	https://vk.com/lauren-brittany	https://facebook.com/lauren-brittany	https://linkedin.com/lauren-brittany	https://github.com/lauren-brittany	https://stackoverflow.com/lauren-brittany
2	\N	+380506614889	Ukraine	Kiyv	2004627019	5957230	0e071920-8b21-4aaf-ba09-4dbfd585ef40.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing 	1	brian-kathleen	https://vk.com/brian-kathleen	https://facebook.com/brian-kathleen	https://linkedin.com/brian-kathleen	https://github.com/brian-kathleen	https://stackoverflow.com/brian-kathleen
5	\N	+380508117195	Ukraine	Odessa	1456428077	-1231019035	b2a564da-3a24-4aaa-ac28-380bd511fb2e.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis 	1	kathleen-nicholas	https://vk.com/kathleen-nicholas	https://facebook.com/kathleen-nicholas	https://linkedin.com/kathleen-nicholas	https://github.com/kathleen-nicholas	https://stackoverflow.com/kathleen-nicholas
6	\N	+380501754111	Ukraine	Kiyv	2093788174	638806491	c93d7cfa-1e71-45fc-8e5e-e9d0b8b9c6c1.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium 	1	jessica-helen	https://vk.com/jessica-helen	https://facebook.com/jessica-helen	https://linkedin.com/jessica-helen	https://github.com/jessica-helen	https://stackoverflow.com/jessica-helen
\.


--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 184
-- Name: member_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('member_seq', 6, true);


--
-- TOC entry 2206 (class 0 OID 24704)
-- Dependencies: 200
-- Data for Name: practic; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY practic (id, member_id, name, company, begin_date, finish_date, responsibilities, demo, src) FROM stdin;
1	1	1273579520	467744576	2015-12-30	2016-01-30	362840463	-331561164	-603264470
2	2	-772720014	1323563829	2016-01-04	2016-02-04	-1499997382	-40105546	271312913
3	5	1157591122	-1889753161	2016-03-04	2016-04-04	-514135516	-649234767	-1858451653
4	6	-1200785862	-668294780	2016-01-04	2016-02-04	-734013681	1919710951	-1154619430
\.


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 201
-- Name: practic_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('practic_seq', 4, true);


--
-- TOC entry 2193 (class 0 OID 24614)
-- Dependencies: 187
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY skill (id, member_id, name, description) FROM stdin;
1	1	a	2119392532
2	1	b	-1882472733
3	1	c	-1007867042
4	1	d	-1419156013
\.


--
-- TOC entry 2192 (class 0 OID 24609)
-- Dependencies: 186
-- Data for Name: skill_category; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY skill_category (id, name) FROM stdin;
1	a
2	b
5	c
6	d
\.


--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 188
-- Name: skill_category_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('skill_category_seq', 6, true);


--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 189
-- Name: skill_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('skill_seq', 4, true);


--
-- TOC entry 2062 (class 2606 OID 24680)
-- Name: certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 24660)
-- Name: course_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 24696)
-- Name: education_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_pkey PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 24650)
-- Name: hobby_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobby_pkey PRIMARY KEY (id);


--
-- TOC entry 2056 (class 2606 OID 24638)
-- Name: language_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- TOC entry 2045 (class 2606 OID 24588)
-- Name: member_email_key; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member
    ADD CONSTRAINT member_email_key UNIQUE (email);


--
-- TOC entry 2050 (class 2606 OID 24598)
-- Name: member_info_id_key; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_info
    ADD CONSTRAINT member_info_id_key UNIQUE (id);


--
-- TOC entry 2048 (class 2606 OID 24584)
-- Name: member_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 24711)
-- Name: practic_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_pkey PRIMARY KEY (id);


--
-- TOC entry 2052 (class 2606 OID 24613)
-- Name: skill_category_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill_category
    ADD CONSTRAINT skill_category_pkey PRIMARY KEY (id);


--
-- TOC entry 2054 (class 2606 OID 24621)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 2046 (class 1259 OID 32768)
-- Name: member_id_key; Type: INDEX; Schema: public; Owner: my-resume
--

CREATE INDEX member_id_key ON member USING btree (id);


--
-- TOC entry 2072 (class 2606 OID 24682)
-- Name: certificate_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2071 (class 2606 OID 24661)
-- Name: course_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2073 (class 2606 OID 24697)
-- Name: education_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2070 (class 2606 OID 24666)
-- Name: hobby_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobby_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2069 (class 2606 OID 24639)
-- Name: language_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2067 (class 2606 OID 24604)
-- Name: member_info_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_info
    ADD CONSTRAINT member_info_fk FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2074 (class 2606 OID 24712)
-- Name: practic_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2068 (class 2606 OID 24626)
-- Name: skill_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-05-08 10:55:21

--
-- PostgreSQL database dump complete
--

