DROP  SCHEMA IF EXISTS food_track CASCADE;
/*-----------------------------------------------------*/



CREATE SCHEMA food_track;

/*-----------------------------------------------------*/

CREATE TABLE IF NOT EXISTS food_track.user_roles (

	id   BIGSERIAL   NOT NULL   PRIMARY KEY,
	role_name   VARCHAR(50)   NOT NULL

);


/*-----------------------------------------------------*/

CREATE TABLE IF NOT EXISTS food_track.users (

	id BIGSERIAL PRIMARY KEY NOT NULL,
    username VARCHAR (255) NOT NULL,
	password VARCHAR (60) NOT NULL,
	height BIGINT NOT NULL,
	weight BIGINT NOT NULL,
	role_id BIGINT NOT NULL REFERENCES food_track.user_roles(id)

);


CREATE TABLE IF NOT EXISTS food_track.food(

    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    weight BIGINT NOT NULL,
    height BIGINT NOT NULL,
    calories INT NOT NULL
);

CREATE TABLE IF NOT EXISTS food_track.eaten_food(

    id BIGSERIAL PRIMARY KEY NOT NULL,
    food_id BIGINT NOT NULL REFERENCES food_track.food(id),
    user_id BIGINT NOT NULL REFERENCES food_track.users(id),
    date DATE NOT NULL
);

