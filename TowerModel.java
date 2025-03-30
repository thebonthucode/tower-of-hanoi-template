public class TowerModel {

    private IntegerStack[] towers;
    private int towerHeight;
    private int printCounter;
    private int moveCounter;

    public TowerModel(int height) {
        towerHeight = height;
        towers = new IntegerStack[3];
        towers[0] = new IntegerStack(height);
        towers[1] = new IntegerStack(height);
        towers[2] = new IntegerStack(height);

        for (int i = height; i > 0; i--) {
            towers[0].push(i);
        }
    }

    public int height() {
        return towerHeight;
    }

    public void move(int source, int destination) {
        if (towers[source].peek() == 0 && towers[source].get(0) == 0) {
            System.out.println("Invalid move attempted from " + source + " to " + destination);
            return;
        }

        if (towers[destination].peek() == 0 && towers[destination].get(0) == 0 || towers[source].peek() < towers[destination].peek()) {

            int disk = towers[source].pop();
            towers[destination].push(disk);
            System.out.println("Move #" + ++moveCounter + " from " + source + " to " + destination);
        } else {
            System.out.println("Invalid move attempted from " + source + " to " + destination);
        }
    }

    public void print() {
        System.out.print("Print #" + ++printCounter + " Towers of Hanoi\n");

        for (int layer = towerHeight - 1; layer >= 0; layer--) {
            System.out.print("\n");
            for (int tower = 0; tower < towers.length; tower++) {
                int value = towers[tower].get(layer);
                if (value == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < towers.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    public IntegerStack[] getTowers() {
        return towers;
    }

    public int getHeight() {
        return towerHeight;
    }
}