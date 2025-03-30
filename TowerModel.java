public class TowerModel {

    private IntegerStack[] t;
    private int tHeight;
    private int print;
    private int move;

    public TowerModel(int height) {
        tHeight = height;
        t = new IntegerStack[3];
        t[0] = new IntegerStack(height);
        t[1] = new IntegerStack(height);
        t[2] = new IntegerStack(height);

        for (int i = height; i > 0; i--) {
            t[0].push(i);
        }
    }

    public int height() {
        return tHeight;
    }

    public void move(int source, int destination) {
        if (t[source].peek() == 0 && t[source].get(0) == 0) {
            System.out.println("Invalid move attempted from " + source + " to " + destination);
            return;
        }

        if (t[destination].peek() == 0 && t[destination].get(0) == 0 || t[source].peek() < t[destination].peek()) {
            int disk = t[source].pop();
            t[destination].push(disk);
            System.out.println("Move #" + ++move + " from " + source + " to " + destination);
        } else {
            System.out.println("Invalid move attempted from " + source + " to " + destination);
        }
    }

    public void print() {
        System.out.print("Print #" + ++print + " Towers of Hanoi\n");

        for (int layer = tHeight - 1; layer >= 0; layer--) {
            System.out.print("\n");
            for (int tower = 0; tower < t.length; tower++) {
                int value = t[tower].get(layer);
                if (value == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < t.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    public IntegerStack[] getTowers() {
        return t;
    }

    public int getHeight() {
        return tHeight;
    }
}
