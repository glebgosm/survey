CREATE TABLE IF NOT EXISTS "surveys" (
    id           BIGSERIAL PRIMARY KEY NOT NULL,
    name         VARCHAR(100) NOT NULL,
    start_date   DATE NOT NULL,
    end_date     DATE NOT NULL,
    description  VARCHAR(1000)
);

CREATE TABLE IF NOT EXISTS "questions" (
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    type        VARCHAR(15) NOT NULL,
    text        VARCHAR(1000) NOT NULL,
    survey_id   BIGINT NOT NULL REFERENCES surveys(id),
    ordinal     BIGINT NOT NULL  -- question number in its survey
);

CREATE TABLE IF NOT EXISTS "users" (
    id         BIGSERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS "answered_surveys" (
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    user_id    BIGINT NOT NULL REFERENCES users(id),
    survey_id  BIGINT NOT NULL REFERENCES surveys(id)
);

CREATE TABLE IF NOT EXISTS "answers" (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    question_id         BIGINT NOT NULL REFERENCES questions(id),
    answered_survey_id  BIGINT NOT NULL REFERENCES answered_surveys(id),
    answer              VARCHAR(1000),
    ordinal             BIGINT NOT NULL
);
