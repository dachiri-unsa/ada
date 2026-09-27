package lab03.ejercicio04;

import java.util.Random;

public class RandomDataGenerator {
    private final Random random;

    public RandomDataGenerator() {
        random = new Random();
    }
    public RandomDataGenerator(Random random) {
        this.random =  random;
    }

    public int[] generateIntArray() {
        return generateIntArray(10_000 , 100_000);
    }

    public int[] generateIntArray(int cantidad, int limite) {
        int[] array = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            array[i] = random.nextInt(limite);
        }
        return array;
    }
}
