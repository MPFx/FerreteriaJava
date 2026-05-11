package model;

/**
 * Clase que representa una herramienta.
 * Hereda de Producto e incluye tipo de herramienta, material y garantia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Herramienta extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Tipo de herramienta (Manual, Electrica, Neumatica). */
    private String tipoHerramienta;
    
    /** Material de fabricacion (Acero, Aluminio, Plastico). */
    private String material;
    
    /** Garantia en meses. */
    private int garantiaMeses;
    
    /**
     * Constructor para crear una herramienta.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public Herramienta(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = Categoria.HERRAMIENTA;
        this.tipoHerramienta = "Manual";
        this.material = "Acero";
        this.garantiaMeses = 6;
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Herramienta"
     */
    @Override
    public String getTipoProducto() {
        return "Herramienta";
    }
    
    /**
     * Obtiene informacion adicional de la herramienta.
     * 
     * @return Informacion de tipo, material y garantia
     */
    @Override
    public String getInformacionAdicional() {
        return "Tipo: " + tipoHerramienta + " - Material: " + material + 
               " - Garantia: " + garantiaMeses + " meses";
    }
    
    // ==================== GETTERS ====================
    
    /** @return Tipo de herramienta */
    public String getTipoHerramienta() {
        return tipoHerramienta;
    }
    
    /** @param tipoHerramienta Nuevo tipo */
    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }
    
    /** @return Material */
    public String getMaterial() {
        return material;
    }
    
    /** @param material Nuevo material */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    /** @return Garantia en meses */
    public int getGarantiaMeses() {
        return garantiaMeses;
    }
    
    /** @param garantiaMeses Nueva garantia */
    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }
    
    /**
     * Devuelve una representacion textual de la herramienta.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + tipoHerramienta + " - " + material;
    }
    
}//fin de la clase