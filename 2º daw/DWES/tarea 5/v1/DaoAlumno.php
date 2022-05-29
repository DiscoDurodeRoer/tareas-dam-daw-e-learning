<?php

include_once "alumno.php";

class DaoAlumno
{

    private $db;

    function __construct($db)
    {
        $this->db = $db;
    }

    function insertar($alumno)
    {
        $this->db->connect();

        $sql = "INSERT INTO alumnos VALUES(";
        $sql .= "'" . $alumno->Dni . "', ";
        $sql .= "'" . $alumno->Nombre . "', ";
        $sql .= "'" . $alumno->Apellido1 . "', ";
        $sql .= "'" . $alumno->Apellido2 . "', ";
        $sql .= $alumno->Edad . ")";

        $this->db->executeInstruction($sql);

        $this->db->close();
    }

    function actualizar($alumno)
    {
        $this->db->connect();

        $sql = "UPDATE alumnos SET ";
        $sql .= "nombre = '" . $alumno->Nombre . "', ";
        $sql .= "apellido1 = '" . $alumno->Apellido1 . "', ";
        $sql .= "apellido2 = '" . $alumno->Apellido2 . "', ";
        $sql .= "edad = " . $alumno->Edad . " ";
        $sql .= "WHERE Dni = '" . $alumno->Dni . "'";

        $this->db->executeInstruction($sql);

        $this->db->close();
    }

    function buscar($dni)
    {
        $this->db->connect();

        $sql = "SELECT * ";
        $sql .= "FROM alumnos ";
        $sql .= "WHERE Dni = '" . $dni . "' ";

        $alumnoBuscado = null;

        if($this->db->numRows($sql) > 0){

            $alumno = $this->db->getDataSingle($sql);

            $alumnoBuscado = new Alumno(
                $alumno['Dni'],
                $alumno['Nombre'],
                $alumno['Apellido1'],
                $alumno['Apellido2'],
                $alumno['Edad']
            );

        }

        $this->db->close();

        return $alumnoBuscado;

    }

    function borrar($dnis)
    {
        $this->db->connect();

        $sql = "DELETE FROM alumnos  ";
        $sql .= "WHERE Dni in (" . implode(",", $dnis) . ")";

        $this->db->executeInstruction($sql);

        $this->db->close();
    }

    function listar()
    {
        $this->db->connect();

        $datos = array();
        
        $sql = "SELECT * ";
        $sql .= "FROM alumnos ";

        $result = $this->db->getData($sql);

        foreach ($result as $key => $value) {
            $alumno = new Alumno(
                $value['Dni'],
                $value['Nombre'],
                $value['Apellido1'],
                $value['Apellido2'],
                $value['Edad']
            );
            array_push($datos, $alumno);
        }

        $this->db->close();

        return $datos;
    }
}
