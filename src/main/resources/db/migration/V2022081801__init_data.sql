
CREATE TABLE movie (
    id SERIAL PRIMARY KEY ,
    title VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    release_year VARCHAR(4),
    duration VARCHAR(10),
    rating float,
    like_count INTEGER DEFAULT 0,
    dislike_count INTEGER DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
