<?php


class Conexion
{
    protected static $conexion;


    public function __construct()
    {
        if (self::$conexion == null) {
            self::crearConexion();
        }
    }

    public static function crearConexion()
    {
        $user = "gestorT7";
        $pass = "secreto";
        $base='proyectot7';
        $dsn = "mysql:host=localhost;dbname=$base;charset=utf8mb4";
        
        try {
            self::$conexion = new PDO($dsn, $user, $pass);
            self::$conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (\PDOException $ex) {
            die("Error en la conexión: mensaje: " . $ex->getMessage());
        }
    }
}

