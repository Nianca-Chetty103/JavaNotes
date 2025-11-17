/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithms;
import java.util.*;

public class DijkstrasAlgorithm<T> {
 

/**
 * A simple, generic Weighted Graph using an adjacency list.
 * Includes Dijkstra's algorithm for shortest paths.
 */


    // ---------- 1. Edge Class ----------
    private static class Edge<T> {
        T to;
        int weight;

        Edge(T to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // ---------- 2. Priority Queue Node ----------
    private static class Node<T> implements Comparable<Node<T>> {
        T vertex;
        int distance;

        Node(T vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node<T> other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // ---------- 3. Adjacency List ----------
    private Map<T, List<Edge<T>>> adj = new HashMap<>();

    // Add a vertex
    public void addVertex(T v) {
        adj.putIfAbsent(v, new LinkedList<>());
    }

    // Add a directed edge
    public void addEdge(T from, T to, int weight) {
        addVertex(from);
        addVertex(to);
        adj.get(from).add(new Edge<>(to, weight));
    }

    // Print graph
    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (T v : adj.keySet()) {
            System.out.print(v + " -> ");
            for (Edge<T> e : adj.get(v)) {
                System.out.print(e.to + "(w=" + e.weight + ") ");
            }
            System.out.println();
        }
    }

    // ---------- 4. Dijkstra's Algorithm ----------
    public Map<T, Integer> dijkstra(T start) {
        Map<T, Integer> dist = new HashMap<>();
        Set<T> visited = new HashSet<>();
        PriorityQueue<Node<T>> pq = new PriorityQueue<>();

        // Initialize all distances to infinity
        for (T v : adj.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        pq.add(new Node<>(start, 0));

        while (!pq.isEmpty()) {
            Node<T> current = pq.poll();
            T u = current.vertex;

            if (visited.contains(u)) continue;
            visited.add(u);

            for (Edge<T> edge : adj.get(u)) {
                T v = edge.to;
                int weight = edge.weight;
                int newDist = dist.get(u) + weight;

                if (newDist < dist.get(v)) {
                    dist.put(v, newDist);
                    pq.add(new Node<>(v, newDist));
                }
            }
        }

        return dist;
    }

    // ---------- Example Usage ----------
    public static void main(String[] args) {

        DijkstrasAlgorithm<String> g = new DijkstrasAlgorithm<>();

        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("C", "B", 1);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 8);
        g.addEdge("C", "E", 10);
        g.addEdge("D", "E", 2);

        g.printGraph();
        System.out.println();

        Map<String, Integer> distances = g.dijkstra("A");

        System.out.println("Shortest distances from A:");
        for (String v : distances.keySet()) {
            System.out.println(v + ": " + distances.get(v));
        }
    }
   
}

