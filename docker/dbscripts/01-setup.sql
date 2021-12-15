CREATE USER quarkususer WITH PASSWORD 'quarkuspass';
CREATE DATABASE keycloak_quarkus_db owner 'quarkususer';
GRANT ALL PRIVILEGES ON DATABASE keycloak_quarkus_db TO quarkususer;

\c keycloak_quarkus_db quarkususer;
DROP SCHEMA IF EXISTS keycloak_schema CASCADE;
CREATE SCHEMA keycloak_schema;
