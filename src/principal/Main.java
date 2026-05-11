package principal;

import ui.MenuConsola;

/**
 * Clase principal del Sistema de Ferreteria.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BIENVENIDO AL SISTEMA DE");
        System.out.println("         FERRETERIA");
        System.out.println("========================================");
        System.out.println("Gestiona clientes, proveedores, productos,");
        System.out.println("inventario y ventas de herramientas,");
        System.out.println("materiales de construccion y pinturas.");
        System.out.println("========================================\n");
        
        MenuConsola menu = new MenuConsola();
        menu.iniciar();
    }
    
}//fin de la clase