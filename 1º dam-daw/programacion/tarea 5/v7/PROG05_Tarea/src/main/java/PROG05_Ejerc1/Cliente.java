package PROG05_Ejerc1;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private int codigoPostal;

    public Cliente() {
    }

    public Cliente(String dni) throws Exception {
        this.dni = dni;
        this.validarDNI();
    }

    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, String poblacion, int codigoPostal) throws Exception {
        this.dni = dni;
        this.validarDNI();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblación(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public boolean existe_Dni() {

        Cliente clienteEncontrado = null;

        // Busqueda del cliente
        if (Principal.cliente1 != null && Principal.cliente1.getDni().equals(this.dni)) {
            clienteEncontrado = Principal.cliente1;
        } else if (Principal.cliente2 != null && Principal.cliente2.getDni().equals(this.dni)) {
            clienteEncontrado = Principal.cliente2;
        } else if (Principal.cliente3 != null && Principal.cliente3.getDni().equals(this.dni)) {
            clienteEncontrado = Principal.cliente3;
        } else if (Principal.cliente4 != null && Principal.cliente4.getDni().equals(this.dni)) {
            clienteEncontrado = Principal.cliente4;
        } else if (Principal.cliente5 != null && Principal.cliente5.getDni().equals(this.dni)) {
            clienteEncontrado = Principal.cliente5;
        }

        // Si existe, lo relleno
        if (clienteEncontrado != null) {
            this.setNombre(clienteEncontrado.getNombre());
            this.setApellidos(clienteEncontrado.getApellidos());
            this.setPoblación(clienteEncontrado.getPoblacion());
            this.setDireccion(clienteEncontrado.getDireccion());
            this.setCodigoPostal(clienteEncontrado.getCodigoPostal());
            return true;
        }
        return false;

    }

    public boolean existe_nombre() {
        Cliente clienteEncontrado = null;

        // Busqueda del cliente
        if (Principal.cliente1 != null && Principal.cliente1.getNombre().equalsIgnoreCase(this.nombre) && Principal.cliente1.getApellidos().equalsIgnoreCase(this.apellidos)) {
            clienteEncontrado = Principal.cliente1;
        } else if (Principal.cliente2 != null && Principal.cliente2.getNombre().equalsIgnoreCase(this.nombre) && Principal.cliente2.getApellidos().equalsIgnoreCase(this.apellidos)) {
            clienteEncontrado = Principal.cliente2;
        } else if (Principal.cliente3 != null && Principal.cliente3.getNombre().equalsIgnoreCase(this.nombre) && Principal.cliente3.getApellidos().equalsIgnoreCase(this.apellidos)) {
            clienteEncontrado = Principal.cliente3;
        } else if (Principal.cliente4 != null && Principal.cliente4.getNombre().equalsIgnoreCase(this.nombre) && Principal.cliente4.getApellidos().equalsIgnoreCase(this.apellidos)) {
            clienteEncontrado = Principal.cliente4;
        } else if (Principal.cliente5 != null && Principal.cliente5.getNombre().equalsIgnoreCase(this.nombre) && Principal.cliente5.getApellidos().equalsIgnoreCase(this.apellidos)) {
            clienteEncontrado = Principal.cliente5;
        }

        // Si existe, lo relleno
        if (clienteEncontrado != null) {
            this.setDni(clienteEncontrado.getDni());
            this.setPoblación(clienteEncontrado.getPoblacion());
            this.setDireccion(clienteEncontrado.getDireccion());
            this.setCodigoPostal(clienteEncontrado.getCodigoPostal());
            return true;
        }
        return false;
    }

    private void validarDNI() throws Exception {
        Validacion.comprobar_dni(dni);
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal + '}';
    }

}
