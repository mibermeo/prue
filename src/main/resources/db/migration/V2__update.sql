CREATE VIEW hora_view AS
    SELECT hora, COUNT(hora) AS frequency FROM jugador GROUP BY (hora);

CREATE VIEW cancha_view AS
        SELECT cancha, COUNT(cancha) AS frequency FROM jugador GROUP BY (cancha);
