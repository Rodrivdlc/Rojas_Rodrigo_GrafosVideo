package src.main.java.grafos;

import java.util.Objects;

public class Vertice {
    private String id; // Identificador único para el vértice
    private Object dato; // Permite almacenar la info asociada al vértice

    /**
     * Constructor para crear un nuevo vértice.
     * @param id El identificador único del vértice.
     * @param dato El dato asociado al vértice.
     */
    public Vertice(String id, Object dato) {
        this.id = id;
        this.dato = dato;
    }

    /**
     * Compara este vértice con otro objeto.
     * @param o El objeto a comparar con este vértice.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(dato, vertice.dato);
    }

    /**
     * Genera un hash basado en el id y el dato del vértice.
     * @return Un hash basado en el id y el dato del vértice.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, dato);
    }

    /**
     * Devuelve una representación en cadena del vértice.
     * @return Una representación en cadena del vértice.
     */
    @Override
    public String toString() {
        return "Vertice{" +
                "id='" + id + '\'' +
                ", dato=" + dato +
                '}';
    }

    /**
     * Obtiene el id del vértice.
     * @return El id del vértice.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el id del vértice.
     * @param id El nuevo id del vértice.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el dato asociado al vértice.
     * @return El dato asociado al vértice.
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Establece el dato asociado al vértice.
     * @param dato El nuevo dato asociado al vértice.
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }
}
