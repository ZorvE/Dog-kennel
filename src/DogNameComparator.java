import java.util.Comparator;

public class DogNameComparator implements Comparator<DogNode> {

    public int compare(DogNode firstDog, DogNode secondDog){
        return firstDog.getName().compareTo(secondDog.getName());
    }
}
