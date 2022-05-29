<?php

require_once "Pais.php";
require_once "Localidad.php";
require_once "Provincia.php";

class Dao
{

    private $db;

    function __construct($db)
    {
        $this->db = $db;
    }

    function insertarAlumno($alumno)
    {
        $this->db->connect();

        $sql = "INSERT INTO alumnos VALUES(";
        $sql .= "'" . $alumno->Dni . "', ";
        $sql .= "'" . $alumno->Nombre . "', ";
        $sql .= "'" . $alumno->Apellido1 . "', ";
        $sql .= "'" . $alumno->Apellido2 . "', ";
        $sql .= $alumno->Edad . " , ";
        $sql .= $alumno->Pais . ", ";
        $sql .= $alumno->Provincia . ", ";
        $sql .= $alumno->Localidad . "')";

        $this->db->executeInstruction($sql);

        $this->db->close();
    }

    function listarPaises()
    {
        $this->db->connect();

        $datos = array();
        $sql = "SELECT * ";
        $sql .= "FROM paises ";

        $resultados = $this->db->getData($sql);

        foreach ($resultados as $key => $value) {
            $pais = new Pais(
                $value['Id'],
                $value['Nombre']
            );
            array_push($datos, $pais);
        }

        $this->db->close();
        return $datos;
    }

    function listarProvincias($idPais)
    {

        $this->db->connect();

        $datos = array();
        $sql = "SELECT * ";
        $sql .= "FROM provincias ";
        $sql .= "WHERE IdPais = " . $idPais;

        $resultados = $this->db->getData($sql);

        foreach ($resultados as $key => $value) {
            $provincia = new Provincia(
                $value['IdPro'],
                $value['Nombre'],
                $value['IdPais']
            );
            array_push($datos, $provincia);
        }

        $this->db->close();
        return $datos;
    }

    function listarLocalidades($idPais, $idProvincia)
    {

        $this->db->connect();

        $datos = array();
        $sql = "SELECT * ";
        $sql .= "FROM localidades ";
        $sql .= "WHERE IdPais = " . $idPais . " ";
        $sql .= "and IdPro = " . $idProvincia;

        $resultados = $this->db->getData($sql);

        foreach ($resultados as $key => $value) {
            $localidad = new Localidad(
                $value['IdLoc'],
                $value['Nombre'],
                $value['IdProvincia'],
                $value['IdPais'],
            );
            array_push($datos, $localidad);
        }

        $this->db->close();
    }
}
