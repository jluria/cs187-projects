package graph;

import java.util.ArrayList;
import java.util.ListIterator;

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
  private ArrayList<ArrayList<Integer>> adjacencyMatrix;
  private int numEdges;
  // TODO: Declare class variables here.

  /**
   * Initialize all class variables and data structures.
   */
  public UndirectedUnweightedGraph(int maxVertices, int maxColors) {
    MAX_VERTICES = maxVertices;
    MAX_COLORS = maxColors;
    vertices = new ArrayList<Vertex<T>>();
    adjacencyMatrix = new ArrayList<ArrayList<Integer>>();
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

    ArrayList<Integer> newRow = new ArrayList<Integer>();
    adjacencyMatrix.add(newRow);

    adjacencyMatrix.forEach((row) -> row.add(0));
  }

  /**
   * Return true if the graph contains a vertex with this data, false otherwise.
   */
  public boolean hasVertex(T data) {
    boolean vertexPresent = false;
    for (int i = 0; i < vertices.size(); i++) {
      T vertexData = vertices.get(i).getData();
      if (vertexData.equals(data)) {
        vertexPresent = true;
      }
    }
    return vertexPresent;
  }

  /**
   * Add an edge between the vertices that contain these data. Throws Exception if
   * one or both vertices do not exist.
   */
  public void addEdge(T data1, T data2) throws Exception {
    int data1Index = -1;
    int data2Index = -1;

    for (int i = 0; i < vertices.size(); i++) {
      Vertex<T> vertex = vertices.get(i);
      if (vertex.getData().equals(data1)) {
        data1Index = i;
      } else if (vertex.getData().equals(data2)) {
        data2Index = i;
      }
    }

    if (data1Index == -1 || data2Index == -1) {
      throw new Exception("One or both vertices not found.");
    } else {
      adjacencyMatrix.get(data1Index).set(data2Index, 1);
      adjacencyMatrix.get(data2Index).set(data1Index, 1);
      numEdges++;
    }
  }

  /**
   * Get an ArrayList of the data contained in all vertices adjacent to the vertex
   * that contains the data passed in. Returns an ArrayList of zero length if no
   * adjacencies exist in the graph. Throws Exception if a vertex containing the
   * data passed in does not exist.
   */
  public ArrayList<T> getAdjacentData(T data) throws Exception {
    ArrayList<T> connectedVertices = new ArrayList<T>();
    int edgeDataIndex = -1;

    for (int i = 0; i < vertices.size(); i++) {
      if (vertices.get(i).getData().equals(data)) {
        edgeDataIndex = i;
        break;
      }
    }

    if (edgeDataIndex == -1) {
      throw new Exception("Vertex with provided data does not exist.");
    }

    ListIterator<Integer> edgeIterator = adjacencyMatrix.get(edgeDataIndex).listIterator();

    while (edgeIterator.hasNext()) {
      if (edgeIterator.next() == 1) {
        Vertex<T> connectedVertex = vertices.get(edgeIterator.previousIndex());
        connectedVertices.add(connectedVertex.getData());
      }
    }

    return connectedVertices;
  }

  /**
   * Returns the total number of vertices in the graph.
   */
  public int getNumVertices() {
    int numVertices = 0;
    numVertices = vertices.size();
    return numVertices;
  }

  /**
   * Returns the total number of edges in the graph.
   */
  public int getNumEdges() {
    return this.numEdges;
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
