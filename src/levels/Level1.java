package levels;

import models.Teacher;
import models.Subject;
import utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        System.out.println("TO DO 1:");
        /*
         * TO DO 1: Afficher tous les enseignants
         */
        teachers.forEach(System.out::println);

        System.out.println("TO DO 2:");
        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        teachers.stream().filter(t -> t.getName().startsWith("n")).forEach(System.out::println);


        System.out.println("TO DO 3:");
        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        teachers.stream().filter(t -> t.getName().startsWith("n") && t.getSalary() > 100000)
                .forEach(System.out::println);


        System.out.println("TO DO 4:");
        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        teachers.stream().filter(t -> t.getSubject() == Subject.JAVA)
                .distinct()
                .sorted(Comparator.comparingDouble(Teacher::getSalary))
                .forEach(System.out::println);


        System.out.println("TO DO 5:");
        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        System.out.println("TO DO 5:");

        /* En utilisant filter.foreach */
        teachers.stream().filter(t -> t.getSalary() > 60000).forEach(t -> System.out.println(t.getName()));

        System.out.println("TO DO 5(Second method):");

        /* En utilisant filter.map.foreach */
        teachers.stream().filter(t -> t.getSalary() > 60000).map(Teacher::getName).forEach(System.out::println);

        /*
         * TO DO 6: Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        Teacher highestPaidM = teachers.stream()
                .filter(t -> t.getName().startsWith("m"))
                .peek(t -> t.setSalary(t.getSalary() + 200))
                .max(Comparator.comparingDouble(Teacher::getSalary))
                .orElse(null);

        System.out.println("Le prof le plus payé dont leur nom commence par 'm': " + highestPaidM);
    }
}
