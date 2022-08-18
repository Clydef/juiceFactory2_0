package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.adt.Queue;
import com.example.juiceFactory2_0.adt.Stack;
import com.example.juiceFactory2_0.entity.Customer;
import com.example.juiceFactory2_0.entity.Vertex;

public class Graph {
    private final int MAX_VERTS = 100;
    private final int INFINITY = 10000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int nTree;
    private DistPar[] path;
    private int currentVert;
    private int startToCurrent;
    private Stack stack;
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int row = 0; row < MAX_VERTS; row++) {
            for (int column = 0; column < MAX_VERTS; column++) {
                adjMat[row][column] = INFINITY;
            }
        }
        path = new DistPar[MAX_VERTS];
        stack = new Stack();
        queue = new Queue();
    }

    public void addVertex(Customer customer) {
        vertexList[nVerts++] = new Vertex(customer);
    }

    public void addEdge(Customer start, Customer end, int weight) {
        int starting = findIndexOf(start);
        int ending = findIndexOf(end);
        adjMat[starting][ending] = weight;
    }

    public void displayVertexName(int vertex) {
        System.out.print(vertexList[vertex].customer.getName());
    }

    public void cheapestPath(Customer startTree) {
        int start = findIndexOf(startTree);
        System.out.println("Starting from " + vertexList[start].customer.getName());
        vertexList[start].isInTree = true;
        nTree = 1;

        for (int column = 0; column < nVerts; column++) {
            int tempDist = adjMat[start][column];
            path[column] = new DistPar(start, tempDist);
        }

        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = path[indexMin].distance;

            if (minDist == INFINITY) {
                System.out.println("There are unreachable areas!");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = path[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }
        displayPaths(startTree);
        System.out.println();
        nTree = 0;
        for (int vertex = 0; vertex < nVerts; vertex++)
            vertexList[vertex].isInTree = false;
    }

    public int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int vertex = 1; vertex < nVerts; vertex++) {
            if (!vertexList[vertex].isInTree && path[vertex].distance < minDist) {
                minDist = path[vertex].distance;
                indexMin = vertex;
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {
        int column = 1;
        while (column < nVerts) {
            if (vertexList[column].isInTree) {
                column++;
                continue;
            }
            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = path[column].distance;
            if (startToFringe < sPathDist) {
                path[column].parentVert = currentVert;
                path[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(Customer startVert) {
        for (int vertex = 0; vertex < nVerts; vertex++) {
            System.out.println();
            System.out.print(startVert.getName() + " towards ");
            stack.push(vertex);
            System.out.print(vertexList[vertex].customer.getName() + " costs ");

            if (path[vertex].distance == INFINITY || path[vertex].distance == 0) {
                System.out.print("inf ");
            } else {
                System.out.print(path[vertex].distance + "K ");
            }
            int parentVert = path[vertex].parentVert;
            int startIndex = findIndexOf(startVert);

            if (startIndex != parentVert) {
                stack.push(parentVert);
            }
            int parentOf = parentVert;
            boolean startingVert = false;

            while (!startingVert) {
                int temp = path[parentOf].parentVert;
                String parentOfParent = vertexList[temp].customer.getName();
                stack.push(temp);
                parentOf = temp;

                if (parentOfParent.equals(startVert.getName()))
                    startingVert = true;
            }
            System.out.print("(Path: ");

            while (!stack.isEmpty()) {
                System.out.print(vertexList[stack.pop()].customer.getName());

                if (!stack.isEmpty()) {
                    System.out.print("--> ");
                }
            }
            System.out.println(")");
        }
    }

    public int findIndexOf(Customer customer) {
        if (vertexList == null) {
            return -1;
        }
        int vertex = 0;

        while (vertex < nVerts) {
            if (vertexList[vertex].customer.equals(customer)) {
                return vertex;
            } else {
                vertex++;
            }
        }
        return -1;
    }
}
