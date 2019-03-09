class Array {
    public static void push(GridCell[] array, GridCell cell) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = cell;
            }
        }
    }
}