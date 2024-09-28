import java.util.Comparator;

public class DogTailComparator implements Comparator<DogNode> {

    public int compare(DogNode firstDog, DogNode secondDog){
        if (firstDog.getTailLength() > secondDog.getTailLength()) {
            return 1;
        } else if (firstDog.getTailLength() < secondDog.getTailLength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
