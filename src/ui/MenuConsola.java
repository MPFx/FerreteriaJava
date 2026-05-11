package ui;

import service.*;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de usuario por consola para la Ferreteria.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class MenuConsola {
    
    private Scanner scanner;
    private Inventario inventario;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private List<Venta> ventas;
    private FerreteriaService ferreteriaService;
    private VentaService ventaService;
    private Cliente clienteActual;
    
    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.inventario = new Inventario();
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.ventaService = new VentaService(ventas);
        this.ferreteriaService = new FerreteriaService(inventario, clientes, proveedores, ventaService);
        this.clienteActual = null;
        cargarDatosPrueba();
    }
    
    private void cargarDatosPrueba() {
        // Productos
        Herramienta martillo = new Herramienta("H001", "Martillo de Carpintero", 25000);
        martillo.setTipoHerramienta("Manual");
        martillo.setMaterial("Acero");
        martillo.setGarantiaMeses(12);
        martillo.setStock(20);
        inventario.agregarProducto(martillo);
        
        MaterialConstruccion cemento = new MaterialConstruccion("M001", "Cemento Gris", 35000);
        cemento.setUnidadMedida("kg");
        cemento.setPesoKg(50);
        cemento.setPresentacion("Bulto");
        cemento.setStock(100);
        inventario.agregarProducto(cemento);
        
        Pintura pintura = new Pintura("P001", "Pintura Blanca", 45000);
        pintura.setColor("Blanco");
        pintura.setTipoPintura("Vinilo");
        pintura.setRendimientoM2(10);
        pintura.setPresentacion("Galon");
        pintura.setStock(30);
        inventario.agregarProducto(pintura);
        
        // Clientes
        clientes.add(new Cliente("Juan Perez", "12345678", "555-1234", "juan@email.com"));
        clientes.add(new Cliente("Maria Gomez", "87654321", "555-5678", "maria@email.com"));
        
        // Proveedores
        proveedores.add(new Proveedor("FerreMateriales S.A.", "555-9012", "Calle 123"));
        proveedores.add(new Proveedor("Pinturas Nacionales", "555-3456", "Carrera 45"));
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> ferreteriaService.registrarCliente(scanner);
                case 2 -> ferreteriaService.registrarProveedor(scanner);
                case 3 -> ferreteriaService.registrarProducto(scanner);
                case 4 -> inventario.mostrarInventario();
                case 5 -> ferreteriaService.listarClientes();
                case 6 -> ferreteriaService.listarProveedores();
                case 7 -> clienteActual = ferreteriaService.seleccionarCliente(scanner);
                case 8 -> ventaService.realizarVenta(scanner, inventario, clienteActual);
                case 9 -> ventaService.listarVentas();
                case 10 -> ventaService.mostrarVentasPorCliente(clienteActual);
                case 11 -> {
                    System.out.println("\n¡Gracias por usar el Sistema de Ferreteria!");
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
            
            if (!salir) pausa();
        }
        scanner.close();
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA DE FERRETERIA");
        System.out.println("========================================");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar proveedor");
        System.out.println("3. Registrar producto");
        System.out.println("4. Ver inventario");
        System.out.println("5. Listar clientes");
        System.out.println("6. Listar proveedores");
        System.out.println("7. Seleccionar cliente");
        System.out.println("8. Realizar venta");
        System.out.println("9. Ver ventas");
        System.out.println("10. Ver ventas por cliente");
        System.out.println("11. Salir");
        System.out.println("========================================");
        
        if (clienteActual != null) {
            System.out.println("Cliente actual: " + clienteActual.getNombre());
        } else {
            System.out.println("Cliente actual: NINGUNO");
        }
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
}//fin de la clase