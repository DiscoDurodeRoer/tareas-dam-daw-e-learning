<?php

class Pais
{

    private $idPais;
    private $nombrePais;

    function __construct($idPais, $nombrePais)
    {
        $this->idPais = $idPais;
        $this->nombrePais = $nombrePais;
    }


    public function __get($property)
    {
        if (property_exists($this, $property)) {
            return $this->$property;
        }
    }

    public function __set($property, $value)
    {
        if (property_exists($this, $property)) {
            $this->$property = $value;
        }
    }
}
