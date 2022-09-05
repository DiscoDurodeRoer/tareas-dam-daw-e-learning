package programacuerposceletes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.CuerpoCeleste;

public class Principal {

    public static void main(String[] args) {

        // Creamos un scanner
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        // Variables necesarias
        File fichero = new File("sistemasolar.dat");

        boolean salir = false;
        int opcion;

        short codigoCuerpo;
        String nombre, tipoObjeto;
        int diametro;

        CuerpoCeleste cc;
        ArrayList<CuerpoCeleste> cuerpos;

        while (!salir) {

            try {

                // menu
                System.out.println("1. Añadir cuerpo celeste");
                System.out.println("2. Listar cuerpos celestes");
                System.out.println("3. Buscar cuerpo celeste por código");
                System.out.println("4. Buscar cuerpo celeste por tipo");
                System.out.println("5. Borrar cuerpo celeste");
                System.out.println("6. Borrar fichero de cuerpos celestes");
                System.out.println("7. Salir");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        // Pido el codigo de cuerpo celeste
                        System.out.println("Introduce el codigo del cuerpo");
                        codigoCuerpo = sn.nextShort();

                        // Valido el numero de cifras
                        if (!Util.validarNumCifras(codigoCuerpo, 3)) {
                            throw new Exception("El codigo del cuerpo no debe tener mas de 3 digitos");
                        }

                        // Pido el nombre del cuerpo celeste
                        System.out.println("Introduce el nombre del cuerpo");
                        nombre = sn.next();

                        // Valido la longitud del nombre
                        if (!Util.validarLongitud(nombre, 15)) {
                            throw new Exception("El nombre del cuerpo no debe tener mas de 15 caracteres");
                        }

                        // Pido el tipo del cuerpo celeste
                        System.out.println("Introduce el tipo del cuerpo (planeta/planetaEnano/luna)");
                        tipoObjeto = sn.next();

                        // Valido el tipo del cuerpo celeste
                        if (!Util.validarTipoObjeto(tipoObjeto)) {
                            throw new Exception("El tipo del cuerpo debe ser planeta, planetaEnano o luna");
                        }

                        // Pido el diametro del cuerpo celeste
                        System.out.println("Introduce el diametro del cuerpo");
                        diametro = sn.nextInt();

                        // Valido el numero de cifras
                        if (!Util.validarNumCifras(diametro, 6)) {
                            throw new Exception("El diametro del cuerpo no debe tener mas de 6 digitos");
                        }

                        // Creo el cuerpo celeste
                        cc = new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro);

                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {

                            // Si el cuerpo celeste existe, lo indicamos
                            if (existeCuerpoCeleste(fichero, codigoCuerpo)) {
                                System.out.println("El cuerpo celeste ya existe");
                            } else {

                                // Guardamos el cuerpo celeste sin cabecera
                                MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                                oos.writeObject(cc);
                                oos.close();
                                System.out.println("Cuerpo celeste agregado con exito");
                            }

                        } else {

                            // Guardamos el cuerpo celeste con cabecera
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
                            oos.writeObject(cc);
                            oos.close();
                            System.out.println("Cuerpo celeste agregado con exito");
                        }

                        break;
                    case 2:

                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {
                            listarCuerpos(fichero);
                        } else {
                            System.out.println("No hay cuerpos celestes");
                        }

                        break;
                    case 3:

                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {
                            // Pido el codigo de cuerpo celeste
                            System.out.println("Introduce el codigo del cuerpo");
                            codigoCuerpo = sn.nextShort();

                            // Obtengo el cuerpo celeste
                            cc = buscarCuerpoPorCodigo(fichero, codigoCuerpo);

                            // Sino es nulo, lo muestro
                            if (cc != null) {
                                System.out.println(cc.toString());
                            } else {
                                System.out.println("No existe el cuerpo con ese codigo");
                            }

                        } else {
                            System.out.println("No hay cuerpos celestes");
                        }

                        break;
                    case 4:
                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {

                            // Pido el tipo del cuerpo celeste
                            System.out.println("Introduce el tipo del cuerpo (planeta/planetaEnano/luna)");
                            tipoObjeto = sn.next();

                            // Valido el tipo del cuerpo celeste
                            if (!Util.validarTipoObjeto(tipoObjeto)) {
                                throw new Exception("El tipo del cuerpo debe ser planeta, planetaEnano o luna");
                            }

                            // Obtengo los cuerpos celestes
                            cuerpos = buscarCuerpoPorTipo(fichero, tipoObjeto);

                            // si hay cuerpos celestes, los muestro
                            if (cuerpos.size() > 0) {
                                for (CuerpoCeleste cuerpo : cuerpos) {
                                    System.out.println(cuerpo.toString());
                                }
                            } else {
                                System.out.println("No existen cuerpos de ese tipo");
                            }

                        } else {
                            System.out.println("No hay cuerpos celestes");
                        }
                        break;
                    case 5:
                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {

                            // Pido el codigo de cuerpo celeste
                            System.out.println("Introduce el codigo del cuerpo");
                            codigoCuerpo = sn.nextShort();

                            if (borrarCuerpoCeleste(fichero, codigoCuerpo)) {
                                System.out.println("Se ha borrado el cuerpo celeste");
                            } else {
                                System.out.println("No existe el cuerpo con ese codigo");
                            }

                        } else {
                            System.out.println("No hay cuerpos celestes");
                        }
                        break;
                    case 6:
                        // Si el fichero existe y no esta vacio
                        if (fichero.exists() && fichero.length() != 0) {

                            // borro el fichero
                            if (fichero.delete()) {
                                System.out.println("Se ha borrado el fichero de cuerpos celestes");
                            } else {
                                System.out.println("No se ha borrado el fichero de cuerpos celestes");
                            }

                        } else {
                            System.out.println("No hay cuerpos celestes");
                        }
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opcion debe estar entre 1 y 7");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un numero");
                sn.next();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public static boolean existeCuerpoCeleste(File fichero, short codigoCuerpo) {

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

            // Recorro hasta que lance la excepcion EOFException
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                // Si coincide con el codigo pasado
                if (cc.getCodigoCuerpo() == codigoCuerpo) {
                    return true;
                }
            }

        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static void listarCuerpos(File fichero) {

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            // Recorro hasta que lance la excepcion EOFException
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                // Mostramos el objeto
                System.out.println(cc.toString());
            }

        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static CuerpoCeleste buscarCuerpoPorCodigo(File fichero, short codigoCuerpo) {

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            // Recorro hasta que lance la excepcion EOFException
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                // Si coincide con el codigo pasado, devuelvo el objeto
                if (cc.getCodigoCuerpo() == codigoCuerpo) {
                    return cc;
                }
            }

        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public static ArrayList<CuerpoCeleste> buscarCuerpoPorTipo(File fichero, String tipo) {

        ArrayList<CuerpoCeleste> cuerpos = new ArrayList<>();
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            // Recorro hasta que lance la excepcion EOFException
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                // Si coincide con el tipo, lo añado al arraylist
                if (cc.getTipoObjeto().equals(tipo)) {
                    cuerpos.add(cc);
                }
            }

        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return cuerpos;
    }

    public static boolean borrarCuerpoCeleste(File fichero, short codigoCuerpo) {

        File temp = new File("temp-sistemasolar.dat");
        boolean borrado = false;
        int contador = 0;

        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp))) {
            // Recorro hasta que lance la excepcion EOFException
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                // Sino coincide con el codigo pasado, lo guardo en el fichero temporal
                // Si coincide con el codigo pasado, indico que se ha borrado
                if (cc.getCodigoCuerpo() != codigoCuerpo) {
                    oos.writeObject(cc);
                } else {
                    borrado = true;
                }
                // Cuento cuantos objetos hay
                contador++;
            }

        } catch (EOFException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        if (borrado) {
            // Si lo borro y hay un elemento, borro el fichero temporal y el fichero original
            if (contador == 1) {
                fichero.delete();
                temp.delete();
            } else {
                // Si se borra el fichero, renombramos el fichero temporal al fichero original
                if (fichero.delete()) {
                    temp.renameTo(fichero.getAbsoluteFile());
                } else {
                    // Borro el fichero temporal
                    temp.delete();
                    return false;
                }
            }

        } else {
            // Borro el fichero temporal
            temp.delete();
        }

        return borrado;
    }

}
