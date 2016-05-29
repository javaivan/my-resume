--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-05-29 10:40:59

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
-- TOC entry 2247 (class 0 OID 0)
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
-- TOC entry 203 (class 1259 OID 65536)
-- Name: education; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE education (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name text
);


ALTER TABLE education OWNER TO "my-resume";

--
-- TOC entry 204 (class 1259 OID 65549)
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
    type character varying(255) DEFAULT 0 NOT NULL,
    name character varying(255) NOT NULL,
    level character varying(255) NOT NULL
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
-- TOC entry 200 (class 1259 OID 49152)
-- Name: member_add_info; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE member_add_info (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    description text
);


ALTER TABLE member_add_info OWNER TO "my-resume";

--
-- TOC entry 201 (class 1259 OID 49167)
-- Name: member_add_info_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE member_add_info_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE member_add_info_seq OWNER TO "my-resume";

--
-- TOC entry 185 (class 1259 OID 24591)
-- Name: member_contact; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE member_contact (
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
    stackoverflow character varying(255),
    member_id bigint
);


ALTER TABLE member_contact OWNER TO "my-resume";

--
-- TOC entry 202 (class 1259 OID 57346)
-- Name: member_contact_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE member_contact_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE member_contact_seq OWNER TO "my-resume";

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
-- TOC entry 198 (class 1259 OID 24704)
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
-- TOC entry 199 (class 1259 OID 24717)
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
-- TOC entry 205 (class 1259 OID 65551)
-- Name: university; Type: TABLE; Schema: public; Owner: my-resume
--

CREATE TABLE university (
    id bigint NOT NULL,
    member_id bigint NOT NULL,
    name text,
    description text,
    begin_year integer NOT NULL,
    faculty character(255) NOT NULL,
    finish_year integer
);


ALTER TABLE university OWNER TO "my-resume";

--
-- TOC entry 206 (class 1259 OID 65566)
-- Name: university_seq; Type: SEQUENCE; Schema: public; Owner: my-resume
--

CREATE SEQUENCE university_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE university_seq OWNER TO "my-resume";

--
-- TOC entry 2229 (class 0 OID 24673)
-- Dependencies: 196
-- Data for Name: certificate; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY certificate (id, member_id, name, images) FROM stdin;
4	6	-255381456	9533784f-8e49-4fe9-ab8a-bbf02f5df23a.jpg
1	1	-19215207791212	f97814ed-9df1-4ac0-ad8d-702b732728e4.jpg
2	1	9919293331212	024a7f49-44a6-4a7e-aaf7-10698ddac38c.jpg
3	1	-18344430161212	da86f5b2-abbe-43d5-b382-c9887695651e.jpg
\.


--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 197
-- Name: certificate_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('certificate_seq', 4, true);


--
-- TOC entry 2227 (class 0 OID 24653)
-- Dependencies: 194
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY course (id, member_id, name, school, finich_date) FROM stdin;
1	1	-1350914495111	0	\N
2	1	-61216467911	1	\N
3	1	138282140822	2	\N
4	1	-117561342833	3	\N
\.


--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 195
-- Name: course_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('course_seq', 4, true);


--
-- TOC entry 2236 (class 0 OID 65536)
-- Dependencies: 203
-- Data for Name: education; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY education (id, member_id, name) FROM stdin;
\.


--
-- TOC entry 2250 (class 0 OID 0)
-- Dependencies: 204
-- Name: education_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('education_seq', 1, false);


--
-- TOC entry 2225 (class 0 OID 24646)
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
-- TOC entry 2251 (class 0 OID 0)
-- Dependencies: 193
-- Name: hobby_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('hobby_seq', 4, true);


--
-- TOC entry 2223 (class 0 OID 24631)
-- Dependencies: 190
-- Data for Name: language; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY language (id, member_id, type, name, level) FROM stdin;
4	6	-1166708506	-560034340	0
1	1	-13192392890	6741937090	00
2	1	-19502043571	-15058857431	01
3	1	12614270082	1953439112	02
\.


--
-- TOC entry 2252 (class 0 OID 0)
-- Dependencies: 191
-- Name: language_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('language_seq', 4, true);


--
-- TOC entry 2216 (class 0 OID 24576)
-- Dependencies: 183
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY member (id, password, first_name, last_name, email, created) FROM stdin;
2	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Lauren	Janet	-156117239_lauren_janet@gmail.com	2016-05-04 09:39:34
5	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Christopher	Ethan	334447551_christopher_ethan@gmail.com	2016-05-04 21:43:30
6	$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq	Patricia	Billy	1773486269_patricia_billy@gmail.com	2016-05-04 21:43:39
1	$2a$10$NZ0s/78owi0SSVkNdDcEQ.EPW4u5r.HDSqjXZbOOzYUBc1JrzGbHC	Ethan	Mildred	osvenh8@gmail.com	2016-04-30 18:47:40
7	$2a$10$NZ0s/78owi0SSVkNdDcEQ.EPW4u5r.HDSqjXZbOOzYUBc1JrzGbHC	11	22	33	2016-05-19 00:49:24
8	$2a$10$JD66c6xs8eskq1dHNZTN4uUoiTpST3oGhjlLr099Lb0lnYn/jOEeG	12	12	12	2016-05-19 00:53:55
\.


--
-- TOC entry 2233 (class 0 OID 49152)
-- Dependencies: 200
-- Data for Name: member_add_info; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY member_add_info (id, member_id, description) FROM stdin;
1	1	123123sdf
\.


--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 201
-- Name: member_add_info_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('member_add_info_seq', 1, false);


--
-- TOC entry 2218 (class 0 OID 24591)
-- Dependencies: 185
-- Data for Name: member_contact; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY member_contact (id, birth_day, phone, country, city, objective, summary, photo, info, status, skype, vkontakte, facebook, linkedin, github, stackoverflow, member_id) FROM stdin;
1	\N	1	1	Odessa	-63005033	-1859187023	6932d3d2-086a-42e3-95d4-1acedc85f543.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet 	1	lauren-brittany	https://vk.com/lauren-brittany	https://facebook.com/lauren-brittany	https://linkedin.com/lauren-brittany	https://github.com/lauren-brittany	https://stackoverflow.com/lauren-brittany	\N
2	\N	+380506614889	Ukraine	Kiyv	2004627019	5957230	0e071920-8b21-4aaf-ba09-4dbfd585ef40.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing 	1	brian-kathleen	https://vk.com/brian-kathleen	https://facebook.com/brian-kathleen	https://linkedin.com/brian-kathleen	https://github.com/brian-kathleen	https://stackoverflow.com/brian-kathleen	2
6	\N	+380501754111	Ukraine	Kiyv	2093788174	638806491	c93d7cfa-1e71-45fc-8e5e-e9d0b8b9c6c1.jpg	Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium 	1	jessica-helen	https://vk.com/jessica-helen	https://facebook.com/jessica-helen	https://linkedin.com/jessica-helen	https://github.com/jessica-helen	https://stackoverflow.com/jessica-helen	3
5	\N	+380508117195	Ukraine	1	1	1	0e071920-8b21-4aaf-ba09-4dbfd585ef40.jpg	1	1	112	223	334	445	556	667	1
\.


--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 202
-- Name: member_contact_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('member_contact_seq', 1, false);


--
-- TOC entry 2255 (class 0 OID 0)
-- Dependencies: 184
-- Name: member_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('member_seq', 8, true);


--
-- TOC entry 2231 (class 0 OID 24704)
-- Dependencies: 198
-- Data for Name: practic; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY practic (id, member_id, name, company, begin_date, finish_date, responsibilities, demo, src) FROM stdin;
1	1	1273579520	467744576	2015-12-30	2016-01-30	362840463	-331561164	-603264470
2	2	-772720014	1323563829	2016-01-04	2016-02-04	-1499997382	-40105546	271312913
3	5	1157591122	-1889753161	2016-03-04	2016-04-04	-514135516	-649234767	-1858451653
4	6	-1200785862	-668294780	2016-01-04	2016-02-04	-734013681	1919710951	-1154619430
\.


--
-- TOC entry 2256 (class 0 OID 0)
-- Dependencies: 199
-- Name: practic_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('practic_seq', 4, true);


--
-- TOC entry 2220 (class 0 OID 24614)
-- Dependencies: 187
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY skill (id, member_id, name, description) FROM stdin;
1	1	a	11111111111111111111111
16	1	a	22222222222222222221
2	1	b	3333333333333333333322
3	1	c	444444444444444442234
4	1	a	55555555555555552345
\.


--
-- TOC entry 2219 (class 0 OID 24609)
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
-- TOC entry 2257 (class 0 OID 0)
-- Dependencies: 188
-- Name: skill_category_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('skill_category_seq', 6, true);


--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 189
-- Name: skill_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('skill_seq', 24, true);


--
-- TOC entry 2238 (class 0 OID 65551)
-- Dependencies: 205
-- Data for Name: university; Type: TABLE DATA; Schema: public; Owner: my-resume
--

COPY university (id, member_id, name, description, begin_year, faculty, finish_year) FROM stdin;
1	1	2	1	1901	3                                                                                                                                                                                                                                                              	123
2	1	1	1	1900	1                                                                                                                                                                                                                                                              	\N
\.


--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 206
-- Name: university_seq; Type: SEQUENCE SET; Schema: public; Owner: my-resume
--

SELECT pg_catalog.setval('university_seq', 41, true);


--
-- TOC entry 2081 (class 2606 OID 24680)
-- Name: certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- TOC entry 2079 (class 2606 OID 24660)
-- Name: course_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 2089 (class 2606 OID 65543)
-- Name: education_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_pkey PRIMARY KEY (id);


--
-- TOC entry 2077 (class 2606 OID 24650)
-- Name: hobby_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobby_pkey PRIMARY KEY (id);


--
-- TOC entry 2075 (class 2606 OID 24638)
-- Name: language_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- TOC entry 2085 (class 2606 OID 49161)
-- Name: member_add_info_member_id_key; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_add_info
    ADD CONSTRAINT member_add_info_member_id_key UNIQUE (member_id);


--
-- TOC entry 2087 (class 2606 OID 49159)
-- Name: member_add_info_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_add_info
    ADD CONSTRAINT member_add_info_pkey PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 57351)
-- Name: member_contact_member_id_key; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_contact
    ADD CONSTRAINT member_contact_member_id_key UNIQUE (member_id);


--
-- TOC entry 2069 (class 2606 OID 57345)
-- Name: member_contact_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_contact
    ADD CONSTRAINT member_contact_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 24588)
-- Name: member_email_key; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member
    ADD CONSTRAINT member_email_key UNIQUE (email);


--
-- TOC entry 2065 (class 2606 OID 24584)
-- Name: member_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);


--
-- TOC entry 2083 (class 2606 OID 24711)
-- Name: practic_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_pkey PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 24613)
-- Name: skill_category_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill_category
    ADD CONSTRAINT skill_category_pkey PRIMARY KEY (id);


--
-- TOC entry 2073 (class 2606 OID 24621)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 2091 (class 2606 OID 65558)
-- Name: university_pkey; Type: CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY university
    ADD CONSTRAINT university_pkey PRIMARY KEY (id);


--
-- TOC entry 2063 (class 1259 OID 32768)
-- Name: member_id_key; Type: INDEX; Schema: public; Owner: my-resume
--

CREATE INDEX member_id_key ON member USING btree (id);


--
-- TOC entry 2097 (class 2606 OID 24682)
-- Name: certificate_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2096 (class 2606 OID 24661)
-- Name: course_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2100 (class 2606 OID 65544)
-- Name: education_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_fk FOREIGN KEY (member_id) REFERENCES member(id);


--
-- TOC entry 2095 (class 2606 OID 24666)
-- Name: hobby_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobby_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2094 (class 2606 OID 24639)
-- Name: language_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2099 (class 2606 OID 49162)
-- Name: member_add_info_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_add_info
    ADD CONSTRAINT member_add_info_fk FOREIGN KEY (member_id) REFERENCES member(id);


--
-- TOC entry 2092 (class 2606 OID 24604)
-- Name: member_contact_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY member_contact
    ADD CONSTRAINT member_contact_fk FOREIGN KEY (id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2098 (class 2606 OID 24712)
-- Name: practic_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2093 (class 2606 OID 24626)
-- Name: skill_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_fk FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE;


--
-- TOC entry 2101 (class 2606 OID 65561)
-- Name: university_fk; Type: FK CONSTRAINT; Schema: public; Owner: my-resume
--

ALTER TABLE ONLY university
    ADD CONSTRAINT university_fk FOREIGN KEY (member_id) REFERENCES member(id);


--
-- TOC entry 2246 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-05-29 10:41:00

--
-- PostgreSQL database dump complete
--

