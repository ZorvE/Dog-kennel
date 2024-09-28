import java.util.Comparator;

public class KennelSorter {

    public int compareDogs(Comparator<DogNode> dogComparator, DogNode firstDog, DogNode secondDog){
        return dogComparator.compare(firstDog, secondDog);
    }
}
