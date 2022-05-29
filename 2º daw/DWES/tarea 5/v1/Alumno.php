<?php

class Alumno {

    private $Dni;
    private $Nombre;
    private $Apellido1;
    private $Apellido2;
    private $Edad;

    function __construct($dni, $nombre, $apellido1, $apellido2, $edad)
    {
        $this->Dni = $dni;
        $this->Nombre = $nombre;
        $this->Apellido1 = $apellido1;
        $this->Apellido2 = $apellido2;
        $this->Edad = $edad;
    }

    public function __get($property){
        if(property_exists($this, $property)) {
            return $this->$property;
        }
    }

    public function __set($property, $value){
        if(property_exists($this, $property)) {
            $this->$property = $value;
        }
    }

}

?>