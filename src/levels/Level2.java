package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(t -> t.getName().startsWith("s")).count();
        System.out.println("Nombre des enseignants dont le nom commence avec 's': " + nbr);

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream()
                .filter(t -> t.getSubject() == Subject.FLUTTER)
                .mapToLong(Teacher::getSalary)
                .sum();
        System.out.println("Somme salaire du profs Flutter: " + sum);

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        OptionalDouble average = teachers.stream()
                .filter(t -> t.getName().startsWith("a"))
                .mapToDouble(Teacher::getSalary)
                .average();
        System.out.println("Salaire moyenne des enseignants dont le nom commence avec 's' " + average.orElse(0.0));

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachersF = teachers.stream()
                .filter(t -> t.getName().startsWith("f"))
                .toList();
        System.out.println("Liste de enseignants dont le nom commence par 'f'" + teachersF);

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachersS = teachers.stream()
                .filter(t -> t.getName().startsWith("s"))
                .toList();
        System.out.println("Liste de enseignants dont le nom commence par 'f' " + teachersS);

        /* TO DO 5: Retourner true si il y a au moins un enseignant dont le salaire > 100000, false sinon */
        boolean test = teachers.stream().anyMatch(t -> t.getSalary() > 100000);
        System.out.println("Il y a un enseignant dont le salaire > 100000? " + test);

        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /* filter avec findfirst */
        teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .findFirst()
                .ifPresent(System.out::println);

        /* filter avec limite */
        teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .limit(1)
                .forEach(System.out::println);

        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream()
                .filter(t -> t.getName().startsWith("s"))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
