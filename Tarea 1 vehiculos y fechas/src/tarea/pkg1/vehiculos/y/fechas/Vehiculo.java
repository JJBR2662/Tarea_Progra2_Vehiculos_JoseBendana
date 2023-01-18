
package tarea.pkg1.vehiculos.y.fechas;

import java.util.Date;


public class Vehiculo {
    
    public String marca;
    public String modelo;
    public Date fechacreacion;
    public Date fechaventa;
    public String color;

    public Vehiculo(String marca, String modelo, Date fechacreacion, Date fechaventa, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.fechacreacion = fechacreacion;
        this.fechaventa = fechaventa;
        this.color = color;
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

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Fecha de creacion: " + fechacreacion + ", fecha de venta: " + fechaventa + ", Color: " + color;
    }
    
}
