package src.main.java.grafos;

public class Arista {
    private Vertice origen;
    private Vertice destino;
    private double peso;

    /**
     * Constructor para crear una nueva arista con peso predeterminado de 1.0.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     */
    public Arista(Vertice origen, Vertice destino) {
        this(origen, destino, 1.0);
    }

    /**
     * Constructor para crear una nueva arista con un peso específico.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     * @param peso El peso de la arista.
     */
    public Arista(Vertice origen, Vertice destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Devuelve una representación en cadena de la arista.
     * @return Una representación en cadena de la arista.
     */
    @Override
    public String toString() {
        return "Arista{" +
                "origen=" + origen +
                ", destino=" + destino +
                ", peso=" + peso +
                '}';
    }

    /**
     * Obtiene el vértice de origen de la arista.
     * @return El vértice de origen de la arista.
     */
    public Vertice getOrigen() {
        return origen;
    }

    /**
     * Establece el vértice de origen de la arista.
     * @param origen El nuevo vértice de origen de la arista.
     */
    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    /**
     * Obtiene el vértice de destino de la arista.
     * @return El vértice de destino de la arista.
     */
    public Vertice getDestino() {
        return destino;
    }

    /**
     * Establece el vértice de destino de la arista.
     * @param destino El nuevo vértice de destino de la arista.
     */
    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    /**
     * Obtiene el peso de la arista.
     * @return El peso de la arista.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso de la arista.
     * @param peso El nuevo peso de la arista.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
}