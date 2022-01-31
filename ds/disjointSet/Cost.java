package ds.disjointSet;

@SuppressWarnings("unused")
public class Cost implements Comparable<Cost> {
    private final int start;
    private final int end;
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

    public void setCost(int cost) {
        this.cost = cost;
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
