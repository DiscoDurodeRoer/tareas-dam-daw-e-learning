<?php

class Localidad {

    private $idLocalidad;
    private $nombreLocalidad;
    private $idProvincia;
    private $idPais;

    function __construct($idLocalidad, $nombreLocalidad, $idProvincia, $idPais)
    {
        $this->idLocalidad = $idLocalidad;
        $this->nombreLocalidad = $nombreLocalidad;
        $this->idProvincia = $idProvincia;
        $this->idPais = $idPais;
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
