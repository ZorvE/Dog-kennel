import java.util.*;

public class Main {

    private Random random = new Random();

    private Scanner scanner = new Scanner(System.in);

    private KennelSorter kennelSorter = new KennelSorter();

    private DogTailComparator dogTailComparator = new DogTailComparator();

    private HashMap<String, Integer> dogMap = new HashMap<>();
    private List<String> dogKeys = new ArrayList<>(dogMap.keySet());

    private ArrayList<DogNode> dogCollection = new ArrayList<>();

    public static void main(String[] args) {
        new Main().start();
    }

    public void dogNamesSetup(){

        dogMap.put("Max", 0);
        dogMap.put("Fido", 0);
        dogMap.put("Buster", 0);
        dogMap.put("Alban", 0);
        dogMap.put("Felix", 0);

        dogKeys = new ArrayList<>(dogMap.keySet());
    }

    private void start(){

        System.out.println("This is the start of the program!");

        dogNamesSetup();

        System.out.println("How many dogs do you want to create?");
        int dogCount = scanner.nextInt();
        createDogs(dogCount);
        scanner.close();


        /*System.out.println("How do you want to sort them? By tail length (tl), name(n), weight(w) or age(a)?");
        String input = scanner.nextLine();
        System.out.println("This is input: " + input + "!");*/


        //System.out.println("The dog name: " + dogNodeOne.getName() + " || Child to the left: " + ((dogNodeOne.getLeft() != null) ? dogNodeOne.getLeft().getName() : "Is null") + " || Child to the right: " + ((dogNodeOne.getRight() != null) ? dogNodeOne.getRight().getName() : " Is null ") + " || Tail length is: " + dogNodeOne.getTailLength());
        //System.out.println("The dog name: " + dogNodeTwo.getName() + " || Child to the left: " + ((dogNodeTwo.getLeft() != null) ? dogNodeTwo.getLeft().getName() : "Is null") + " || Child to the right: " + ((dogNodeTwo.getRight() != null) ? dogNodeTwo.getRight().getName() : "Is null") + " || Tail length is: "+ dogNodeTwo.getTailLength());
        //System.out.println("The dog name: " + dogNodeThree.getName() + " || Child to the left: " + ((dogNodeThree.getLeft() != null) ? dogNodeThree.getLeft().getName() : "Is null") + " || Child to the right: " + ((dogNodeThree.getRight() != null) ? dogNodeThree.getRight().getName() : "Is null") + " || Tail length is: " + dogNodeThree.getTailLength());
        //System.out.println("The dog name: " + dogNodeFour.getName() + " || Child to the left: " + ((dogNodeFour.getLeft() != null) ? dogNodeFour.getLeft().getName() : "Is null") + " || Child to the right: " + ((dogNodeFour.getRight() != null) ? dogNodeFour.getRight().getName() : "Is null") + " || Tail length is: " + dogNodeFour.getTailLength());

        for(DogNode dogNode: dogCollection){
            addNode(dogCollection.getFirst(),dogNode);
        }

        printDogs(dogCollection.getFirst());

    }

    public void createDogs(int dogAmount){
        int dogsCreated = 0;

        while(dogsCreated < dogAmount) {

            int randomIndex = random.nextInt(dogMap.size());

            String newDogName = dogKeys.get(randomIndex);
            int timesNameUsed = dogMap.get(newDogName);

            timesNameUsed++;
            if (timesNameUsed > 1) {
                newDogName = newDogName + timesNameUsed;
            }

            dogCollection.add(new DogNode(newDogName, Math.round((1 + (9 * random.nextDouble()))* 100.0) / 100.0));
            dogMap.put(dogKeys.get(randomIndex), timesNameUsed);

            dogsCreated++;
        }
    }

    public void printDogs(DogNode dogNode){
        if(dogNode != null){
            printDogs(dogNode.getRight());
            System.out.println("Dog name: " + dogNode.getName() + " || Tail length: " + dogNode.getTailLength());
            printDogs(dogNode.getLeft());
        }
    }

    public DogNode addNode(DogNode currentNode, DogNode newNode) {
        if (currentNode == null) {
            return newNode; // Return new node
        }

        if (newNode.getTailLength() < currentNode.getTailLength()) { //compare value - current and new node
            currentNode.setLeft(addNode(currentNode.getLeft(), newNode));
        } else if (newNode.getTailLength() > currentNode.getTailLength()) {
            currentNode.setRight(addNode(currentNode.getRight(), newNode));
        }

        /*if(1 < kennelSorter.sortTwoDogs(dogTailComparator, currentNode, newNode)){ /compare value - current and new node
            currentNode.setLeft(addNode(currentNode.getLeft(), newNode));
        } else if (1 > kennelSorter.sortTwoDogs(dogTailComparator, currentNode, newNode)) {
            currentNode.setRight(addNode(currentNode.getRight(), newNode));
        }*/

        return currentNode; //return current nude
    }

    public void depthFirstSearch(){

    }

    public void breathFirstSearch(){

    }
}