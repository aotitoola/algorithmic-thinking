package com.learn.algorithms.unionFind;

public class QuickFind {

    private int[] id;

    public QuickFind(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            // set id of each object to itself (object's index)
            // N-Array accesses
            id[i] = i;
        }
    }


    public boolean connected(int p, int q){
        //check whether p & q are in the same component (2 array accesses)
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i ++){
            // change all entries with id[p] to id[q]
            // at most (2N + 2) array accesses
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    // Conclusion: Union is too expensive.
    // Takes N squared array accesses to process sequence of N union commands on N objects.

    // Quadratic algorithms do not scale. As computers get faster and bigger, quadratic algorthms get slower.
}
