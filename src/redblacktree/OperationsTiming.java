package redblacktree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class OperationsTiming {

    public void measureOperationsTime(int elementsNumber, int iterations) {
        long[] setValueTimings = measureSetValueTime(elementsNumber, iterations);
        long[] getValueTimings = measureGetValueTime(elementsNumber, iterations);
        writeTimingResults(setValueTimings, getValueTimings);
    }

    private long[] measureSetValueTime(int elementsNumber, int iterations) {
        Random generator = new Random();
        long timeResults[] = new long[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            timeResults[i] = 0;
        }
        for (int i = 0; i < iterations; i++) {
            RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
            for (int j = 0; j < elementsNumber; j++) {
                int randomNumber = generator.nextInt();
                timeResults[j] += getSetMethodValueTime(tree, randomNumber);
            }
        }
        for (int i = 0; i < elementsNumber; i++) {
            timeResults[i] = timeResults[i] / iterations;
        }
        return timeResults;
    }

    private long getSetMethodValueTime(RedBlackTree rbt, int value) {
        long timerStartTime = System.nanoTime();
        rbt.setValue(value, value);
        long timerStopTime = System.nanoTime();
        return timerStopTime - timerStartTime;
    }

    private long[] measureGetValueTime(int elementsNumber, int iterations) {
        Random generator = new Random();
        long timeResults[] = new long[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            timeResults[i] = 0;
        }
        for (int i = 0; i < iterations; i++) {
            RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
            for (int j = 0; j < elementsNumber; j++) {
                int randomNumber = generator.nextInt();
                tree.setValue(randomNumber, randomNumber);
                timeResults[j] += getGetMethodValueTime(tree, randomNumber);
            }
        }
        for (int i = 0; i < elementsNumber; i++) {
            timeResults[i] /= iterations;
        }
        return timeResults;
    }

    private long getGetMethodValueTime(RedBlackTree rbt, int key) {
        long timerStartTime = System.nanoTime();
        rbt.getValue(key);
        long timerStopTime = System.nanoTime();
        return timerStopTime - timerStartTime;
    }

    private void writeTimingResults(long[] setValueTimings, long[] getValueTimings) {
        PrintWriter writer;
        try {
            writer = new PrintWriter("set_timing_values.txt");
            for (long value : setValueTimings) {
                writer.println(value);
            }
            writer.close();

            writer = new PrintWriter("get_timing_values.txt");
            for (long value : getValueTimings) {
                writer.println(value);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("There was a problem with writing data to the file.");
        }
    }
}
