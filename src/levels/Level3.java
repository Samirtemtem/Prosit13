package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des enseignants en majuscules séparés par # */
        String names = teachers.stream()
                .map(Teacher::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining("#"));
        System.out.println("Noms en majuscule séparé par #: " + names);

        /* TO DO 2: Retourner un ensemble d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> javaTeachers = teachers.stream()
                .filter(t -> t.getSubject() == Subject.JAVA && t.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Profs java dont le salaire > 80k: " + javaTeachers);

        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> sortedTeachers = teachers.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(Teacher::getName)
                                .thenComparingDouble(Teacher::getSalary))));
        System.out.println("profs triée par nom, égalité en treeset " + sortedTeachers);

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Integer, List<Teacher>> teachersByModule = teachers.stream()
                .collect(Collectors.groupingBy(t -> t.getSubject().ordinal()));
        System.out.println("Enseignants par module :" + teachersByModule);

        /* TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire */
        Map<Integer, String> namesBySalary = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
        System.out.println("Noms par salaire: " + namesBySalary);

        /* TO DO 6: Afficher les noms des enseignants de chaque module */
        teachersByModule.forEach((module, teacherList) -> {
            System.out.println("Module " + module + ": " +
                    teacherList.stream().map(Teacher::getName).collect(Collectors.joining(", ")));
        });
    }
}
