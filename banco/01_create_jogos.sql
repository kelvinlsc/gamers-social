-- Tabela JOGOS (AC1)
CREATE TABLE jogo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50),
    genero VARCHAR(50)
);

-- Inserir alguns jogos de exemplo
INSERT INTO jogo (nome, plataforma, genero) VALUES 
('God of War', 'PS5', 'Action'),
('Final Fantasy', 'PS4', 'RPG');
