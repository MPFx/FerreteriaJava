package service;

import model.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las operaciones generales de la ferreteria.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public class FerreteriaService {
    
    private Inventario inventario;
    private List<Cliente> clientes;
    private List<Proveedor> proveedores;
    private VentaService ventaService;
    
    public FerreteriaService(Inventario inventario, List<Cliente> clientes,
                             List<Proveedor> proveedores, VentaService ventaService) {
        this.inventario = inventario;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.ventaService = ventaService;
    }
    
    public void registrarCliente(Scanner scanner) {
        System.out.println("\n=== REGISTRAR CLIENTE ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, documento, telefono, email);
        clientes.add(cliente);
        System.out.println("✅ Cliente registrado: " + cliente.getNombre());
    }
    
    public void registrarProveedor(Scanner scanner) {
        System.out.println("\n=== REGISTRAR PROVEEDOR ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();
        
        Proveedor proveedor = new Proveedor(nombre, telefono, direccion);
        proveedores.add(proveedor);
        System.out.println("✅ Proveedor registrado: " + proveedor.getNombre());
    }
    
    public void registrarProducto(Scanner scanner) {
        System.out.println("\n=== REGISTRAR PRODUCTO ===");
        System.out.println("Tipo de producto:");
        System.out.println("1. Herramienta");
        System.out.println("2. Material de Construccion");
        System.out.println("3. Pintura");
        System.out.print("Seleccione: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        
        Producto producto = null;
        
        switch (tipo) {
            case 1:
                Herramienta herramienta = new Herramienta(codigo, nombre, precio);
                System.out.print("Tipo de herramienta (Manual/Electrica/Neumatica): ");
                herramienta.setTipoHerramienta(scanner.nextLine());
                System.out.print("Material: ");
                herramienta.setMaterial(scanner.nextLine());
                System.out.print("Garantia (meses): ");
                herramienta.setGarantiaMeses(Integer.parseInt(scanner.nextLine()));
                producto = herramienta;
                break;
            case 2:
                MaterialConstruccion material = new MaterialConstruccion(codigo, nombre, precio);
                System.out.print("Unidad de medida (kg/m/m2/unidad): ");
                material.setUnidadMedida(scanner.nextLine());
                System.out.print("Peso (kg): ");
                material.setPesoKg(Double.parseDouble(scanner.nextLine()));
                System.out.print("Presentacion: ");
                material.setPresentacion(scanner.nextLine());
                producto = material;
                break;
            case 3:
                Pintura pintura = new Pintura(codigo, nombre, precio);
                System.out.print("Color: ");
                pintura.setColor(scanner.nextLine());
                System.out.print("Tipo de pintura: ");
                pintura.setTipoPintura(scanner.nextLine());
                System.out.print("Rendimiento (m2/galon): ");
                pintura.setRendimientoM2(Double.parseDouble(scanner.nextLine()));
                System.out.print("Presentacion (Galon/Cuarto/Litro): ");
                pintura.setPresentacion(scanner.nextLine());
                producto = pintura;
                break;
        }
        
        if (producto != null) {
            System.out.print("Stock inicial: ");
            producto.setStock(Integer.parseInt(scanner.nextLine()));
            System.out.print("Stock minimo: ");
            producto.setStockMinimo(Integer.parseInt(scanner.nextLine()));
            inventario.agregarProducto(producto);
        }
    }
    
    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    
    public void listarProveedores() {
        System.out.println("\n=== LISTA DE PROVEEDORES ===");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados");
            return;
        }
        for (Proveedor p : proveedores) {
            System.out.println(p);
        }
    }
    
    public Cliente seleccionarCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clientes.stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
        }
        return cliente;
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
}//fin de la clase