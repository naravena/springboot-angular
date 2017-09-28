/*Delimita el procedimiento*/
DELIMITER $$

/*Crea el procedimiento, llamado agregar_proveedor, que recibe dos valores: nombre y ciudad*/
CREATE PROCEDURE agregar_pieza()

/*Inicia el procedimiento*/
BEGIN
/*Variable booleana, para hacer commit si todo va bien y rollback
si existe algun error, inicializada en false*/
DECLARE _error BOOL DEFAULT 0;

/*Control de excepcion, si falla, la variable booleana _error, se vuelve true*/
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET _error = 1;

/*Inicia la transaccion*/
START TRANSACTION;

/*Inserta en la tabla piezas los valores aleatorios, con un límite de 1*/
INSERT INTO piezas ( `codigo`, `nombre`,`color`,`precio`, `peso`,`ciudad`) 
SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 6), 
		 concat( 
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97),
    char(round(rand()*25)+97)
),
       (SELECT color FROM piezas ORDER BY RAND() limit 1),
        round( rand() * 100),
        round( rand() * 10),
       (SELECT  ciudad FROM proveedores ORDER BY RAND() LIMIT 1) 
FROM piezas LIMIT 1;



/*Comprueba si hay error, si _error es true, se hace rollback, sino, hace commit*/
IF _error THEN
SELECT "Ha habido un error en la operacion";
ROLLBACK;

ELSE
SELECT "Operacion completada";
COMMIT;
/*Fin del IF*/
END IF;

/*Fin del procedimiento*/
END $$
/*Llamada al procedimiento*/
CALL agregar_proveedor()
