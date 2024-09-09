class Variable {
    static int a;
    public static void main(String[] args) {
        int x;
        x = 10;
        a = 2;
        System.out.println("Nilai a : " + a);
        {
            int y = 5;
            System.out.println("Nilai x : " + x);
            System.out.println("Nilai a : " + a);
            {
                int z;
                z = 20;
                System.out.println("Nilai x + y + z + a : " + (x + y + z +a));
            }
            // variable `z` out of scope
            // System.out.println("Nilai z : " + z);
            System.out.println("Nilai y : " + y);
        }
        // variable `z` out of scope
        // System.out.println("Nilai z : " + z);
        // variable `y` out of scope
        // System.out.println("Nilai y : " + y);
        System.out.println("Nilai x : " + x);
    }
}