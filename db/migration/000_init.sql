CREATE USER onix_user WITH PASSWORD 'onix_user';
CREATE SCHEMA IF NOT EXISTS onix;
GRANT USAGE ON SCHEMA onix TO "onix_user";
ALTER SCHEMA onix OWNER TO "onix_user";
ALTER USER "onix_user" SET search_path = onix;