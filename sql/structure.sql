
CREATE TABLE box (
    id SERIAL NOT NULL PRIMARY KEY,
    label character varying(100),
    vehicle_id integer,
    secret_key character varying(50)
);


CREATE TABLE vehicle (
    id SERIAL NOT NULL PRIMARY KEY,
    brand character varying(200)
);

ALTER TABLE box
    ADD CONSTRAINT box_fk_vehicle foreign key (vehicle_id)  REFERENCES vehicle(id);

