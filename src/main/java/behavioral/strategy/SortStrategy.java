interface SortStrategy {
    void sort(int[] arr);
}

static class BubbleSort implements SortStrategy {
    public void sort(int[] a) {
        System.out.println("BubbleSort: " + Arrays.toString(a));
    }
}

static class QuickSort implements SortStrategy {
    public void sort(int[] a) {
        System.out.println("QuickSort: " + Arrays.toString(a));
    }
}

static class Sorter {
    private SortStrategy strategy;

    Sorter(SortStrategy s) {
        this.strategy = s;
    }

    void setStrategy(SortStrategy s) {
        this.strategy = s;
    }

    void sort(int[] arr) {
        strategy.sort(arr);
    }
}

void main() {
    Sorter sorter = new Sorter(new BubbleSort());
    sorter.sort(new int[]{3, 1, 2});
    sorter.setStrategy(new QuickSort());
    sorter.sort(new int[]{3, 1, 2});
}
