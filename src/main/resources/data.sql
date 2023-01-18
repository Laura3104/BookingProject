INSERT INTO users (name, email) VALUES
  ('Laura', 'laura.carmona@epam.com'),
  ('Camilo', 'camilo@epam.com'),
  ('Vanessa', 'vanessa@epam.com'),
  ('Juan', 'juan@epam.com');

INSERT INTO events (title, date) VALUES
  ('Event1', '2020-10-01'),
  ('Event2', '2020-10-02'),
  ('Event3', '2020-10-03'),
  ('Event4', '2020-10-04'),
  ('Event5', '2020-10-05'),
  ('Event6', '2020-10-06');

INSERT INTO tickets (category, place, user_id, event_id) VALUES
  ('CONFERENCES', 1,  1L, 1L),
  ('SEMINARS', 2, 2L, 2L),
  ('SEMINARS', 1, 2L, 2L),
  ('CONFERENCES', 1, 2L, 2L);