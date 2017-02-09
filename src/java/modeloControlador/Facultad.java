package modeloControlador;

import java.util.Arrays;

public class Facultad {

    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double[] coordenadas;

    public Facultad(int id, String nombre, String descripcion, String imagen, Double[] coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.coordenadas = coordenadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Facultad{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", coordenadas=" + Arrays.toString(coordenadas) + '}';
    }
}
