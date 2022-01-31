package ds.disjointSet;

import java.util.Arrays;

//Find & Union
// can do minimum & maximum spanning tree
@SuppressWarnings("unused")
public class DisjointSet<T> {

    private int size;
    private int setsCount;
    private int totalCost;
    private int[] nodes;
    private Cost[] cost;

    public DisjointSet(int size, Cost[] cost) {
        if(size <= 0) throw new IllegalArgumentException("Size cannot be zero or negative");
        if(null == cost) throw new NullPointerException("Cost points to null");
        nodes = new int[size];
        this.size = size;
        this.setsCount = size;
        this.totalCost = 0;
        for (int i = 0; i < this.size; i++) this.nodes[i] = i;

        // sorting cost by ascending order for finding minimum span. can also be modified to find maximum span
        Arrays.sort(cost);
        this.cost = cost;
    }

    // find which set a node belongs to
    private int find(int n) {
        int root = n;
        while (root != nodes[root]) root = nodes[root];

        // Path compression which gives Alpha(n) time complexity.
        while (n != root) {
            nodes[n] = nodes[n] ^ root;
            root = nodes[n] ^ root;
            nodes[n] = nodes[n] ^ root;
            n = root;
            root = nodes[n];
        }
        return root;
    }

    public boolean isOfSameSet(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public void union(Cost c) {
        int root1 = find(c.getStart());
        int root2 = find(c.getEnd());

        // if both have same root hten they already are in the same group
        if (root1 == root2) return;

        // Merge sets into one - smaller / larger sets doesn't matter since path is compressed while performing find
        nodes[root2] = root1;
        c.setIncluded(true);
        totalCost += c.getCost();
        setsCount--;
    }

    public void perform() {
        int stepCount = 0;
        while (stepCount < cost.length) union(cost[stepCount++]);
    }

    @Override
    public String toString() {
        int stepCount = 0;
        StringBuilder builder = new StringBuilder();
        while (stepCount < cost.length) {
            if (cost[stepCount].isIncluded())
                builder.append("[" + cost[stepCount].getStart() + ", " + cost[stepCount].getEnd() + "], ");
            stepCount++;
        }
        builder.append(" total cost : " + this.totalCost);
        return builder.toString();
    }

}
