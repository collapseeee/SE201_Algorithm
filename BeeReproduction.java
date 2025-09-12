public class BeeReproduction {
    public static void main(String[] args) {
        System.out.println(bee(0));
        System.out.println(bee(1));
        System.out.println(bee(2));
        System.out.println(bee(3));
        System.out.println(bee(5));
        System.out.println(bee(10));
    }

    public static int bee(int year) {
        int queen = 1;
        int soldier = 0;
        int worker = 1;
        for (int i=0; i<year; i++) {
            int addedSoldier = 0;
            int addedWorker = 0;

            addedWorker += queen*1; // Queen gives one worker bee and still alive.
            addedWorker = addedWorker + (soldier * 1); // Sodier gives one worker bee.
            soldier = 0; // and die.
            
            addedWorker = addedWorker + (worker * 1); // Worker gives one worker bee.
            addedSoldier = worker * 1; // Worker gives one sodier bee.
            worker = 0; // and die.

            worker = addedWorker;
            soldier = addedSoldier;
        }
        return queen+soldier+worker;
    }
}
