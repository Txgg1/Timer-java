import java.util.Scanner;

public class Main {
    public static String formatDuration(int secondes) {
        if (secondes == 0) {
            return "maintenant";
        }

        int[] unites = {365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1};
        String[] libellesUnites = {"an", "jour", "heure", "minute", "seconde"};

        StringBuilder resultat = new StringBuilder();

        for (int i = 0; i < unites.length; i++) {
            int count = secondes / unites[i];
            secondes %= unites[i];

            if (count > 0) {
                if (resultat.length() > 0) {
                    resultat.append(", ");
                }
                resultat.append(count).append(' ').append(pluralize(libellesUnites[i], count));
            }
        }

        return resultat.toString();
    }

    private static String pluralize(String unite, int count) {
        return count > 1 ? unite + "s" : unite;
    }

    public static void main(String[] args) {
        Scanner entree = new Scanner(System.in);
        System.out.println("Secondes : ");

        while (!entree.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre : ");
            entree.next();
        }

        int nombre = entree.nextInt();

        System.out.println(formatDuration(nombre));
    }
}
