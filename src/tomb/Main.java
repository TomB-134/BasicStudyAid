package tomb;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Term> terms;
    private static int lastTermIndex;

    private static Random random;

    private static ArrayList<Boolean> results;

    public static ArrayList<Term> terms() {
        ArrayList<Term> terms = new ArrayList<Term>();
        terms.add(new Term("fast_cruise_performance_for_warrior", "110"));
        terms.add(new Term("normal_cruise_performance_for_warrior", "105"));
        terms.add(new Term("slow_cruise_performance_for_warrior", "80"));
        terms.add(new Term("precautionary_cruise_performance_for_warrior", "80"));

        return terms;
    }

    public static Term randomTerm(ArrayList<Term> terms) {
        int x = random.nextInt(terms.size());
        while (x == lastTermIndex) {
            x = random.nextInt(terms.size());
        }
        lastTermIndex = x;

        return terms.get(x);
    }

    public static void main(String[] args) {
        random = new Random();
        results = new ArrayList<>();
        terms = terms();

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) { //Loop
            Term term = randomTerm(terms());
            System.out.println("What is " + Util.processTermString(term.term) + "?");

            String input = sc.nextLine();

            if (input.equals("stats")) {
                printStatistics();
                continue;
            }

            if (input.equals("reset")) {
                results = new ArrayList<>();
                continue;
            }

            if (input.equals("exit")) {
                run = false;
                continue;
            }

            if (input.equals(term.definition)) {
                System.out.println("Correct");
                results.add(Boolean.TRUE);
            } else {
                System.out.println("Incorrect > " + term.definition);
                results.add(Boolean.FALSE);
            }
        }
    }

    public static void printStatistics() {
        float correct = 0;
        float incorrect = 0;
        for (Boolean result : results) {
            if (result.booleanValue()) {
                correct++;
            } else {
                incorrect++;
            }
        }

        float total = correct + incorrect;
        int percentageCorrect = Math.round(correct/total * 100);
        System.out.println("============================");
        System.out.println("Total: " + Math.round(total));
        System.out.println("Percentage Correct: " + percentageCorrect);
        System.out.println("============================");
    }
}
