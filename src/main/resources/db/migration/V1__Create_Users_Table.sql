CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Dados iniciais
INSERT INTO users (username, password) VALUES 
('admin', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36qjG4P.l0Z1Zb73z.8iXa.'), -- Senha: admin123
('user', '$2a$10$VTVlFx.uYOoLdRYiKt5ZtOX8P2Ft8RdZsACNu3J5DFYwXeEoqjgyy'); -- Senha: user123

INSERT INTO user_roles (user_id, role) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');
