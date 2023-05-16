<?php

require 'Conexion.php';
class Voto extends Conexion
{

    public function __construct()
    {
        parent::__construct();
    }

    public function isValido($idPr, $idUs)
    {
        $consulta = "select * from votos where idPr=:idPr AND idUs=:idUs";
        $stmt = Conexion::$conexion->prepare($consulta);
        try {
            $stmt->execute([
                ':idPr' => $idPr,
                ':idUs' => $idUs
            ]);
        } catch (\PDOException $ex) {
            die("Error al consultar usuario: " . $ex->getMessage());
        }
        $filas=$stmt->rowCount();
        if ($filas > 0) return false;
        return true;
    }

    public function insertarVoto($cantidad, $idPr, $idUs) {
        $insert = "INSERT INTO votos (cantidad, idPr, idUs) VALUES (:cantidad,:idPr,:idUs)";
        $stmt = Conexion::$conexion->prepare($insert);
        try {
            $stmt->execute([
                ':cantidad' => $cantidad,
                ':idPr' => $idPr,
                ':idUs' => $idUs
            ]);
        } catch (\PDOException $ex) {
            die("Error al consultar usuario: " . $ex->getMessage());
        }
        $filas=$stmt->rowCount();
        if ($filas == 0) return false;
        return true;
    }

    function pintarEstrellas() {
        $consulta = "select p.id, ";
        $consulta .= "IFNULL(sum(cantidad) / count(*), 0) as mediaVotos, ";
        $consulta .= "count(v.idPr) as numVotos ";
        $consulta .= "from votos v right join productos p ";
        $consulta .= "on v.idPr = p.id group by p.id";
        $stmt = Conexion::$conexion->prepare($consulta);
        try {
            $stmt->execute();
        } catch (\PDOException $ex) {
            die("Error al consultar usuario: " . $ex->getMessage());
        }
        $data = array();
        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
            array_push($data, $row);
        }
        return $data;
    }

}