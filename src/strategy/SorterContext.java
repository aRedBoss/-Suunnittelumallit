package strategy;

public class SorterContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        if (strategy != null) {
            strategy.sort(arr);
        } else {
            throw new IllegalStateException("Sort strategy not set.");
        }
    }
}

