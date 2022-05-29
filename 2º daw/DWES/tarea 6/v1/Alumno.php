<?php

class Alumno {

    private $Dni;
    private $Nombre;
    private $Apellido1;
    private $Apellido2;
    private $Edad;
    private $Pais;
    private $Provincia;
    private $Localidad;

    function __construct($Dni, $Nombre, $Apellido1, $Apellido2, $Edad, $Pais, $Provincia, $Localidad)
    {
        $this->Dni = $Dni;
        $this->Nombre = $Nombre;
        $this->Apellido1 = $Apellido1;
        $this->Apellido2 = $Apellido2;
        $this->Edad = $Edad;
        $this->Pais = $Pais;
        $this->Provincia = $Provincia;
        $this->Localidad = $Localidad;
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
