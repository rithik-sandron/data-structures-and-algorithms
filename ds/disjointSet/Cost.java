package ds.disjointSet;

public class Cost implements Comparable<Cost> {
    private int start;
    private int end;
    private int cost;
    private boolean isIncluded;

    public Cost(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.isIncluded = false;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }

    boolean isIncluded() {
        return isIncluded;
    }

    void setIncluded(boolean included) {
        isIncluded = included;
    }

    @Override
    public int compareTo(Cost c) {
        return this.getCost() == c.getCost() ? 0 : this.getCost() < c.getCost() ? -1 : 1;
    }
}
