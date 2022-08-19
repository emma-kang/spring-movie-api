
CREATE TABLE movie (
    id SERIAL PRIMARY KEY ,
    title VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    release_year VARCHAR(4),
    duration VARCHAR(10),
    rating float,
    create_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
