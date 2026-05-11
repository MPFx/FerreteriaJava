package model;

/**
 * Clase que representa una pintura.
 * Hereda de Producto e incluye color, tipo, rendimiento y presentacion.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Producto
 */
public class Pintura extends Producto {
    
    // ==================== ATRIBUTOS ====================
    
    /** Color de la pintura. */
    private String color;
    
    /** Tipo de pintura (Vinilo, Esmalte, Impermeable). */
    private String tipoPintura;
    
    /** Rendimiento en metros cuadrados por galon. */
    private double rendimientoM2;
    
    /** Presentacion (Galon, Cuarto, Litro). */
    private String presentacion;
    
    /**
     * Constructor para crear una pintura.
     * 
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio
     */
    public Pintura(String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
        this.categoria = Categoria.PINTURA;
        this.color = "Blanco";
        this.tipoPintura = "Vinilo";
        this.rendimientoM2 = 10;
        this.presentacion = "Galon";
    }
    
    /**
     * Obtiene el tipo de producto.
     * 
     * @return "Pintura"
     */
    @Override
    public String getTipoProducto() {
        return "Pintura";
    }
    
    /**
     * Obtiene informacion adicional de la pintura.
     * 
     * @return Informacion de color, tipo, rendimiento y presentacion
     */
    @Override
    public String getInformacionAdicional() {
        return "Color: " + color + " - Tipo: " + tipoPintura + 
               " - Rendimiento: " + rendimientoM2 + " m2/galon - Presentacion: " + presentacion;
    }
    
    // ==================== GETTERS ====================
    
    /** @return Color */
    public String getColor() {
        return color;
    }
    
    /** @param color Nuevo color */
    public void setColor(String color) {
        this.color = color;
    }
    
    /** @return Tipo de pintura */
    public String getTipoPintura() {
        return tipoPintura;
    }
    
    /** @param tipoPintura Nuevo tipo */
    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }
    
    /** @return Rendimiento m2/galon */
    public double getRendimientoM2() {
        return rendimientoM2;
    }
    
    /** @param rendimientoM2 Nuevo rendimiento */
    public void setRendimientoM2(double rendimientoM2) {
        this.rendimientoM2 = rendimientoM2;
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
     * Devuelve una representacion textual de la pintura.
     * 
     * @return Cadena con informacion
     */
    @Override
    public String toString() {
        return super.toString() + " - " + color + " - " + tipoPintura + " - " + presentacion;
    }
    
}//fin de la clase