package repository;

import model.Group;
import java.util.Collections;

public class GroupRepository extends GenericRepository<Group> {

    public void sortByYear(boolean ascending) {
        logger.info("Сортування груп за роком");
        if (ascending)
            Collections.sort(items, Group.BY_YEAR);
        else
            Collections.sort(items, Group.BY_YEAR.reversed());
    }

    public void sortByStudentCount() {
        logger.info("Сортування груп за кількістю студентів (зростання)");
        items.sort(Group.BY_COUNT);
    }
}
