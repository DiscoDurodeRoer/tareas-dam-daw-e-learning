<?php

class Provincia {

    private $idProvincia;
    private $nombreProvincia;
    private $idPais;

    function __construct($idProvincia, $nombreProvincia, $idPais)
    {
        $this->idProvincia = $idProvincia;
        $this->nombreProvincia = $nombreProvincia;
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
