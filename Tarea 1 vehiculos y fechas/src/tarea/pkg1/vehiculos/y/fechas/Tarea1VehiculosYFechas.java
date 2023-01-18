package tarea.pkg1.vehiculos.y.fechas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Tarea1VehiculosYFechas {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        ArrayList <Vehiculo> lista = new ArrayList();
        int opcion;
        do {
            System.out.println("""
                               -------------Menu-------------
                               1- Agregar Vehiculo
                               2- Listar Todos Los Vehiculos
                               3- Modificar Fecha De Creacion
                               4- Modificar El Minuto En Que Se Vendio
                               5- Eliminar Un Vehiculo
                               6- Salir
                               ------------------------------
                               """);
            System.out.print("Ingrese la opcion a evaluar: ");
            opcion = menu.nextInt();
            Scanner casos = new Scanner(System.in);
            switch (opcion){
                case 1:
                    int day=0;
                    int month=0;
                    int year2=0;
                    int dayventa=0;
                    int monthventa=0;
                    int year2venta=0;
                     int contador = 0;
                    System.out.print("Ingrese la marca del vehiculo: ");
                    String marca = casos.nextLine();
                    
                    System.out.print("Ingrese el modelo del vehiculo: ");
                    String modelo = casos.nextLine();
                    
                    Date fechacreacion  = new Date();
                    String creacion;
                    do{
                        contador=0;
                        System.out.print("Ingrese la fecha de creacion del auto (dd/MM/yyyy): ");
                        creacion = casos.nextLine(); 
                        for (int i = 0; i < creacion.length(); i++) {
                            if (creacion.charAt(i)=='/') {
                                contador++;
                            }
                        }
                        if (contador!=2) {
                            System.out.println("Fecha no valida, intente de nuevo");
                        }
                    }while(contador!=2);
                    Scanner sc = new Scanner(creacion);
                    sc.useDelimiter("/");
                    while (sc.hasNext()) {
                        String dia = sc.next();
                        day = Integer.parseInt(dia);
                        String mes = sc.next();
                        month = Integer.parseInt(mes)-1;
                        String year = sc.next();
                        year2 = Integer.parseInt(year)-1900;
                    }
                    fechacreacion.setDate(day);
                    fechacreacion.setMonth(month);
                    fechacreacion.setYear(year2);
                    
                   
                    Date fechaventa = new Date();
                    String venta;
                    do{
                        contador=0;
                        System.out.print("Ingrese la fecha de venta del auto (dd/MM/yyyy): ");
                        venta = casos.nextLine();
                        for (int i = 0; i < venta.length(); i++) {
                            if(venta.charAt(i)=='/'){
                                contador++;
                            }
                        }
                        if(contador!=2){
                            System.out.println("Fecha no valida, ingrese una fecha valida");
                        }
                    }while(contador!=2);
                    Scanner sc2 = new Scanner(venta);
                    sc2.useDelimiter("/");
                    while (sc2.hasNext()) {
                        String diaventa = sc2.next();
                        dayventa = Integer.parseInt(diaventa);
                        String mesventa = sc2.next();
                        monthventa = Integer.parseInt(mesventa) - 1;
                        String yearventa = sc2.next();
                        year2venta = Integer.parseInt(yearventa) - 1900;
                    }
                    fechaventa.setDate(dayventa);
                    fechaventa.setMonth(monthventa);
                    fechaventa.setYear(year2venta);
                    
                    System.out.print("Ingrese el color del auto: ");
                    String color = casos.nextLine();
                    
                    lista.add(new Vehiculo(marca, modelo, fechacreacion, fechaventa, color));
                    System.out.println("Se ha integrado un nuevo "+marca+" "+modelo+" a la coleccion");
                    System.out.println();
                    break;
                    
                    
                case 2:
                    mostrar(lista);
                    break;
                    
                    
                case 3:
                    int dianuevo =0;
                    int mesnuevo =0;
                    int yearnuevo =0;
                    Scanner case3 = new Scanner(System.in);
                    if(lista.size()>0){
                        mostrar(lista);
                        System.out.println();
                        boolean bandera;
                        int cual2;
                        do{
                            System.out.print("Ingrese el numero del vehiculo al cual le quiere cambiar la fecha de creacion: ");
                            cual2 = case3.nextInt();
                            if (cual2-1>=lista.size()||(cual2<1)) {
                                System.out.println("opcion no valida");
                                bandera = true;
                            }else{
                                bandera = false;
                            }
                        }while(bandera);
                        case3 = new Scanner(System.in);

                        System.out.println("Ha elegido "+ lista.get(cual2-1));
                        System.out.println();

                        String nuevafecha;
                        do{
                            contador=0;
                            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
                            nuevafecha = case3.nextLine();
                            for (int i = 0; i < nuevafecha.length(); i++) {
                                if (nuevafecha.charAt(i)=='/') {
                                    contador++;
                                }
                            }
                            if (contador!=2) {
                                System.out.println("La fecha ingresada no es valida");
                            }
                        }while(contador!=2);
                        Scanner token = new Scanner(nuevafecha);
                        token.useDelimiter("/");
                        while (token.hasNext()) {
                            String diastring = token.next();
                            dianuevo = Integer.parseInt(diastring);
                            String messtring = token.next();
                            mesnuevo = Integer.parseInt(messtring)-1;
                            String yearstring = token.next();
                            yearnuevo = Integer.parseInt(yearstring)-1900;
                        }
                        lista.get(cual2-1).getFechacreacion().setDate(dianuevo);
                        lista.get(cual2-1).getFechacreacion().setMonth(mesnuevo);
                        lista.get(cual2-1).getFechacreacion().setYear(yearnuevo);
                        System.out.println();
                        System.out.println("Se ha cambiado la fecha correctamente");
                    }else{
                        System.out.println("No hay ningun carro en la lista");
                    }
                    break;
                    
                    
                case 4:
                    Scanner case4 = new Scanner(System.in);
                    int opcioncase4;
                    if(lista.size()>0){
                        mostrar(lista);
                        System.out.println();
                        boolean banderita;
                        do{
                            System.out.print("Ingrese el numero del vehiculo al que le quiere cambiar el minuto de venta: ");
                            opcioncase4 = case4.nextInt();
                            if (opcioncase4-1>=lista.size()||opcioncase4<1) {
                                System.out.println("opcion no valida");
                                banderita = true;
                            }else{
                                banderita = false;
                            }
                        }while(banderita);

                            System.out.println("Usted ha elegido el vehiculo "+lista.get(opcioncase4-1));
                            System.out.println();

                        int nuevominuto;
                        do{
                            System.out.print("Ingrese el nuevo minuto de venta: ");
                            nuevominuto = case4.nextInt();
                            if ((nuevominuto>60)||(nuevominuto<00)){
                                System.out.println("Minuto no valido, ingrese un minuto correcto");
                            }
                        }while((nuevominuto>60)||(nuevominuto<00));
                        lista.get(opcioncase4-1).getFechaventa().setMinutes(nuevominuto);
                        System.out.println("Se ha cambiado el minuto en que se vendio el vehiculo correctamente");
                    }else{
                        System.out.println("Lo siento, no hay ningun carro en la lista.");
                    }
                    break;
                    
                    
                case 5:
                    if(lista.size()>0){
                        lista = eliminar(lista);
                    }else{
                        System.out.println("Lo siento, no hay vehiculos en la lista");
                    }
                    break;
                    
                    
                case 6:
                    System.out.println("Saliendo...................");
                    break;
                    
                    
                default:
                    System.out.println("Opcion no valida, ingrese de nuevo.");
                    System.out.println();
                    break;
            }
            
        } while (opcion!=6);
        System.out.println("Se ha terminado el programa exitosamente.");
    }
    public static void mostrar(ArrayList<Vehiculo> lista){
        System.out.println("---------------------Lista De Vehiculos---------------------");
        System.out.println();
        for (int i = 1; i <= lista.size(); i++) {
            System.out.println(i+". "+lista.get(i-1));
        }
        System.out.println("------------------------------------------------------------");
    }
    
    public static ArrayList<Vehiculo> eliminar(ArrayList<Vehiculo> lista){
        Scanner erase = new Scanner(System.in);
        mostrar(lista);
        System.out.println();
        int cual;
        boolean bandera;
        do{
            System.out.print("Ingrese el numero del vehiculo que quiere eliminar: ");
            cual = erase.nextInt();
            if (cual-1>=lista.size()||cual<1) {
                System.out.println("opcion no valida");
                bandera = true;
            }else{
                bandera = false;
            }
        }while(bandera);
        lista.remove(cual-1);
        return lista;
    }
     
}
