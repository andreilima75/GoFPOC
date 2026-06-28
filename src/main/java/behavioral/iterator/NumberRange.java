static class NumberRange implements Iterable<Integer> {
    private final int[] nums;
    NumberRange(int... ns){ this.nums = ns; }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            int i = 0;
            public boolean hasNext() { return i < nums.length; }
            public Integer next()    { return nums[i++]; }
        };
    }
}

void main(){
    NumberRange range = new NumberRange(1, 2, 3, 4, 5);
    for (int n : range) System.out.print(n + " ");
}
