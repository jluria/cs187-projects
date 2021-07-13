package graph;

import java.util.ArrayList;

/**
 * This class implements general operations on a graph as specified by
 * UndirectedGraphADT. It implements a graph where data is contained in Vertex
 * class instances. Edges between verticies are unweighted and undirected. A
 * graph coloring algorithm determines the chromatic number. Colors are
 * represented by integers. The maximum number of vertices and colors must be
 * specified when the graph is instantiated. You may implement the graph in the
 * manner you choose. See instructions and course material for background.
 */

public class UndirectedUnweightedGraph<T> implements UndirectedGraphADT<T> {
  // private class variables here.

  private int MAX_VERTICES;
  private int MAX_COLORS;
  private ArrayList<Vertex<T>> vertices;
  // TODO: Declare class variables here.

  /**
   * Initialize all class variables and data structures.
   */
  public UndirectedUnweightedGraph(int maxVertices, int maxColors) {
    MAX_VERTICES = maxVertices;
    MAX_COLORS = maxColors;
    vertices = new ArrayList<Vertex<T>>();
    // TODO: Implement the rest of this method.

  }

  /**
   * Add a vertex containing this data to the graph. Throws Exception if trying to
   * add more than the max number of vertices.
   */
  public void addVertex(T data) throws Exception {
    if (vertices.size() == MAX_VERTICES) {
      throw new Exception();
    }
    Vertex<T> newVertex = new Vertex<T>(data);
    vertices.add(newVertex);
  }

  /**
   * Return true if the graph contains a vertex with this data, false otherwise.
   */
  public boolean hasVertex(T data) {
    // TODO: Implement this method.
    return false;
  }

  /**
   * Add an edge between the vertices that contain these data. Throws Exception if
   * one or both vertices do not exist.
   */
  public void addEdge(T data1, T data2) throws Exception {
    // TODO: Implement this method.

  }

  /**
   * Get an ArrayList of the data contained in all vertices adjacent to the vertex
   * that contains the data passed in. Returns an ArrayList of zero length if no
   * adjacencies exist in the graph. Throws Exception if a vertex containing the
   * data passed in does not exist.
   */
  public ArrayList<T> getAdjacentData(T data) throws Exception {
    // TODO: Implement this method.
    return null;
  }

  /**
   * Returns the total number of vertices in the graph.
   */
  public int getNumVertices() {
    // TODO: Implement this method.
    return -1;
  }

  /**
   * Returns the total number of edges in the graph.
   */
  public int getNumEdges() {
    // TODO: Implement this method.
    return -1;
  }

  /**
   * Returns the minimum number of colors required for this graph as determined by
   * a graph coloring algorithm. Throws an Exception if more than the maximum
   * number of colors are required to color this graph.
   */
  public int getChromaticNumber() throws Exception {
    // TODO: Implement this method.
    return -1;
  }

}
