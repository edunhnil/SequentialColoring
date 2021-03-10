/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialcoloring;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author Admin
 */
public class SequentialColoring {
    
    private int V; // so diem cua mot graph
    private LinkedList<Integer> adj[]; // diem gan ke
    
    SequentialColoring(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // do thi vo huong
    }
    
    void sequentColoring() {
        int res[] = new int [V];
        // khoi tao tat ca cac dinh duoi dang chua duoc gan
        Arrays.fill(res, -1); 
        // gan mau dau tien cho dinh dau tien
        res[0] = 0;
        //luu tru cac mau co san
        //false tuc la mau do duoc gan cho hai dinh lien ke nhau
        boolean available[] = new boolean[V];
        Arrays.fill(available, true);
        // gan mau cho V-1 dinh con lai
        for (int u = 1; u < V; u++) {
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (res[i] != -1) {
                    available[res[i]] = false;
                }
            }
            //tim mau co san
            int c;
            for (c = 0; c < V; c++) {
                if (available[c]) break;
            }
            // tim dung mau va chinh available ve true
            res[u] = c;
            Arrays.fill(available, true);
        }
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + (i) + " --->  Color " + res[i]);
        }
    }
    
    public static void main(String[] args) {
        SequentialColoring g1 = new SequentialColoring(5); 
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(1, 3); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 4); 
        System.out.println("Coloring of graph 1"); 
        g1.sequentColoring();
  
        System.out.println(); 
        SequentialColoring g2 = new SequentialColoring(5); 
        g2.addEdge(0, 1); 
        g2.addEdge(0, 2); 
        g2.addEdge(1, 2); 
        g2.addEdge(1, 4); 
        g2.addEdge(2, 4); 
        g2.addEdge(4, 3); 
        System.out.println("Coloring of graph 2 "); 
        g2.sequentColoring();
        
        System.out.println(); 
        SequentialColoring g3 = new SequentialColoring(8); 
        g3.addEdge(0, 4); //diem 1, 3
        g3.addEdge(0, 5); //diem 1, 4
        g3.addEdge(0, 6); //diem 1, 5
        g3.addEdge(1, 4); //diem 2, 5
        g3.addEdge(1, 7); //diem 2, 8
        g3.addEdge(1, 2); //diem 2, 3
        g3.addEdge(2, 6); //diem 3, 7
        g3.addEdge(3, 5); //diem 4, 6
        g3.addEdge(3, 6); //diem 4, 7
        g3.addEdge(5, 7); //diem 6, 8
        g3.addEdge(5, 6); //diem 6, 7
        g3.addEdge(6, 7); //diem 7, 8
        System.out.println("Coloring of graph 3 "); 
        g3.sequentColoring();
    } 
    
}
