package model;

/**
 * Clase que representa un material de construccion.
 * Hereda de Producto e incluye unidad de medida, peso y presentacion.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class MaterialConstruccion extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Unidad de medida (kg, m, m2, unidad). */
    private String unidadMedida;
    
    /** Peso en kilogramos. */
    private double pesoKg;
    
    /** Presentacion del producto (bolsa, caja, bulto). */
    private String presentacion;
    
    /**
     * Constructor para crear un material de construccion.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public MaterialConstruccion(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = Categoria.CONSTRUCCION;
        this.unidadMedida = "unidad";
        this.pesoKg = 1;
        this.presentacion = "unidad";
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Material de Construccion"
     */
    @Override
    public String getTipoProducto() {
        return "Material de Construccion";
    }
    
    /**
     * Obtiene informacion adicional del material.
     * 
     * @return Informacion de unidad, peso y presentacion
     */
    @Override
    public String getInformacionAdicional() {
        return "Unidad: " + unidadMedida + " - Peso: " + pesoKg + " kg - Presentacion: " + presentacion;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Unidad de medida */
    public String getUnidadMedida() {
        return unidadMedida;
    }
    
    /** @param unidadMedida Nueva unidad */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    /** @return Peso en kg */
    public double getPesoKg() {
        return pesoKg;
    }
    
    /** @param pesoKg Nuevo peso */
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
    
    /** @return Presentacion */
    public String getPresentacion() {
        return presentacion;
    }
    
    /** @param presentacion Nueva presentacion */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    /**
     * Devuelve una representacion textual del material.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + unidadMedida + " - " + pesoKg + "kg";
    }
    
}//fin de la clase