package src.main.java.grafos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private Map<Vertice, Set<Arista>> adyacencias;
    private boolean esDirigido;

    /**
     * Constructor para crear un nuevo grafo.
     * @param esDirigido Indica si el grafo es dirigido o no.
     */
    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.adyacencias = new HashMap<>();
    }

    /**
     * Añade un vértice al grafo.
     * @param vertice El vértice a añadir.
     */
    public void addVertice(Vertice vertice) {
        adyacencias.putIfAbsent(vertice, new HashSet<>());
    }

    /**
     * Añade una arista con peso al grafo.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     * @param peso El peso de la arista.
     */
    public void addAristaPeso(Vertice origen, Vertice destino, double peso) {
        adyacencias.get(origen).add(new Arista(origen, destino, peso));
        if(!esDirigido) {
            adyacencias.get(destino).add(new Arista(destino, origen, peso));
        }
    }

    /**
     * Elimina una arista del grafo.
     * @param origen El vértice de origen de la arista.
     * @param destino El vértice de destino de la arista.
     */
    public void deleteArista(Vertice origen, Vertice destino) {
        Set<Arista> aristas = adyacencias.get(origen);
        if (aristas != null) {
            aristas.removeIf(arista -> arista.getDestino().equals(destino));
        }
        if (!esDirigido) {
            Set<Arista> aristasInversas = adyacencias.get(destino);
            if (aristasInversas != null) {
                aristasInversas.removeIf(arista -> arista.getDestino().equals(origen));
            }
        }
    }

    /**
     * Obtiene los vértices adyacentes a un vértice dado.
     * @param vertice El vértice del que se quieren obtener los adyacentes.
     * @return Un conjunto de vértices adyacentes al vértice dado.
     */
    public Set<Vertice> getAdyacentes(Vertice vertice) {
        Set<Arista> aristas = adyacencias.get(vertice);
        Set<Vertice> adyacentes = new HashSet<>();
        if (aristas != null) {
            for (Arista arista : aristas) {
                adyacentes.add(arista.getDestino());
            }
        }
        return adyacentes;
    }

    /**
     * Elimina un vértice del grafo y todas las aristas asociadas a él.
     * @param vertice El vértice a eliminar.
     */
    public void deleteVertice(Vertice vertice) {
        adyacencias.remove(vertice);
        for (Set<Arista> aristas : adyacencias.values()) {
            aristas.removeIf(arista -> arista.getDestino().equals(vertice));
        }
    }

    /**
     * Devuelve una representación en cadena del grafo.
     * @return Una representación en cadena del grafo.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for( Map.Entry<Vertice, Set<Arista>> entry : adyacencias.entrySet() ){
            for( Arista arista : entry.getValue()) {
                builder.append(arista.getOrigen().getId())
                        .append(" -> ")
                        .append(arista.getDestino().getId())
                        .append(" [")
                        .append(arista.getPeso())
                        .append("]\n");
            }
        }
        return builder.toString();
    }

    /**
     * Obtiene el mapa de adyacencias del grafo.
     * @return El mapa de adyacencias del grafo.
     */
    public Map<Vertice, Set<Arista>> getAdyacencias() {
        return adyacencias;
    }

    /**
     * Indica si el grafo es dirigido o no.
     * @return true si el grafo es dirigido, false en caso contrario.
     */
    public boolean isEsDirigido() {
        return esDirigido;
    }
}