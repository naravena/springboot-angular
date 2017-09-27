/*Si el procedimiento ya existe, lo detiene*/
DROP PROCEDURE IF EXISTS agregar_proveedor;

/*Delimita el procedimiento*/
DELIMITER $$

/*Crea el procedimiento, llamado agregar_proveedor, que recibe dos valores: nombre y ciudad*/
CREATE PROCEDURE agregar_proveedor()

/*Inicia el procedimiento*/
BEGIN
/*Variable booleana, para hacer commit si todo va bien y rollback
si existe algun error, inicializada en false*/
DECLARE _error BOOL DEFAULT 0;

/*Control de excepcion, si falla, la variable booleana _error, se vuelve true*/
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET _error = 1;

/*Inicia la transaccion*/
START TRANSACTION;

/*Inserta en la tabla proveedores los valores nombre y ciudad, que
provienen de la tabla piezas*/
INSERT INTO almacen.proveedores (nombre, ciudad)
SELECT piezas.nombre,piezas.ciudad
FROM piezas;

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