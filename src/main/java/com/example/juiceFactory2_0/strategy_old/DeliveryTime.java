package com.example.juiceFactory2_0.strategy_old;

import com.example.juiceFactory2_0.service.DistPar;

public abstract class DeliveryTime {
    DeliverTimeStrategy deliverTimeStrategy;
    final int MAX_VERTS = 100;
    final int INFINITY = 10000;
    Vertex[] vertexList;
    int[][] adjMat;
    int nVerts;
    int nTree;
    DistPar[] path;
    int currentVert;
    int startToCurrent;
    Stack stack;
    Queue queue;

    public DeliveryTime() {
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

    public void calculateDelivery() {
//        deliverTimeStrategy
    }
}
