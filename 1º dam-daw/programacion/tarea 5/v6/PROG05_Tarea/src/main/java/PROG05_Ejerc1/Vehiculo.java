package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

public class Vehiculo {

    private String marca;
    private String modelo;
    private String matricula;
    private int numKm;
    private LocalDate fechaMatriculacion;
    private int capacidad;
    private int consumo;
    private int deposito;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniPropietario;

    private static double precioCombustible = 10;

    public Vehiculo(
            String marca,
            String modelo,
            String matricula,
            int numKm,
            LocalDate fechaMatriculacion,
            int capacidad,
            int consumo,
            String descripcion,
            double precio,
            String nombrePropietario,
            String dniPropietario) {

        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.numKm = numKm;
        this.consumo = consumo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.capacidad = capacidad;
        this.deposito = 0;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKm() {
        return numKm;
    }

    public void setNumKm(int numKm) {
        this.numKm = numKm;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public static double getPrecioCombustible() {
        return precioCombustible;
    }

    public static void setPrecioCombustible(double precioCombustible) {
        Vehiculo.precioCombustible = precioCombustible;
    }

    public int get_Anios() {
        LocalDate f1 = this.fechaMatriculacion;
        LocalDate f2 = LocalDate.now();

        // Obtenemos el periodo de diferencia
        Period p = Period.between(f1, f2);

        return p.getYears();

    }

    public void mostrarDatosIdentificativos() {
        System.out.println("Marca: " + marca + ", modelo: " + modelo + ", matricula: " + matricula + " y precio: " + precio);
    }

    public void mostrarEstadoVehiculo() {
        System.out.println("El numero de KM es " + numKm + " y el contenido del deposito es de " + deposito + " litros");
    }

    public void viajar(int km) {

        /*
            10 litros (consumo) -> 100km
            x                   -> km (parametro)
         */
        int litrosConsumidos = km * consumo / 100;
        int kmRecorridos;

        if (litrosConsumidos > deposito) {
            /*
                10 litros (consumo) -> 100km
                deposito            -> x
             */
            kmRecorridos = deposito * 100 / consumo;
            deposito = 0;
        } else {
            kmRecorridos = km;
            deposito -= litrosConsumidos;
        }

        this.numKm += kmRecorridos;
        
        System.out.println("Hemos recorrido " + kmRecorridos + "km");

    }

    public void repostar(int litros) {

        int litrosRepostados;

        // Si lo litros superan a la capacidad, sacamos la diferencia
        if (deposito + litros > capacidad) {
            litrosRepostados = capacidad - deposito;
            deposito = capacidad; // Lleno
        } else {
            litrosRepostados = litros;
            deposito += litros;
        }

        System.out.println("Litros repostados: " + litrosRepostados);
        // Importe
        double importe = litrosRepostados * precioCombustible;
        System.out.println("El importe del repostaje es de " + importe + " €");

    }

    public void llenar() {
        // Llamamos a repostar con la capacidad del vehiculo
        repostar(capacidad);
    }

    public void actualizarPrecio(double nuevoPrecio) {
        // Si es estatico, hay que utilizar Vehiculo directamente
        Vehiculo.setPrecioCombustible(nuevoPrecio);
    }

}
