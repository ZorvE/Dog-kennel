import java.util.*;

public class Main {

    private Random random = new Random();

    private Scanner scanner = new Scanner(System.in);

    private HashMap<String, Integer> nameUsage = new HashMap<>();
    private List<String> dogNames = new ArrayList<>(nameUsage.keySet());

    private BinaryTree binaryTree;

    private DogNode root = null;

    private boolean askForCommand = true;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){

        System.out.println("This is the start of the program!");

        dogNamesSetup();

        System.out.println("How many dogs do you want to create?");
        int dogCount = scanner.nextInt();
        scanner.nextLine();

        while(askForCommand) {
            System.out.println("How do you want to sort them? By tail length (tl), name(n)?");
            String input = scanner.nextLine();

            if (input.equals("tl")) {
                binaryTree = new BinaryTree(new DogTailComparator());
                askForCommand = false;
            } else if (input.equals("n")) {
                binaryTree = new BinaryTree(new DogNameComparator());
                askForCommand = false;
            } else {
                System.out.println("Invalid input");
            }

        }
        scanner.close();

        createDogs(dogCount);

        printDogs();
    }

    public void createDogs(int amountOFDogsToCreate) {
        int dogsCreated = 0;

        while(dogsCreated < amountOFDogsToCreate) {

            if (root == null){
                root = new DogNode(createDogName(), createDogTailLength());
            }else {
                binaryTree.add(root, new DogNode(createDogName(), createDogTailLength()));
            }
            dogsCreated++;
        }
    }

    private void dogNamesSetup(){

        nameUsage.put("Max", 0);
        nameUsage.put("Fido", 0);
        nameUsage.put("Buster", 0);
        nameUsage.put("Luna", 0);
        nameUsage.put("Felix", 0);

        dogNames = new ArrayList<>(nameUsage.keySet());
    }

    public void printDogs(){
        binaryTree.printContent(root);
    }

    private double createDogTailLength(){
        return Math.round((1 + (9 * random.nextDouble())) * 100.0) / 100.0;
    }

    private String createDogName(){
        int randomIndex = random.nextInt(nameUsage.size());

        String newDogName = dogNames.get(randomIndex);
        int timesNameUsed = nameUsage.get(newDogName);

        timesNameUsed++;
        if (timesNameUsed > 1) {
            newDogName = newDogName + timesNameUsed;
        }

        nameUsage.put(dogNames.get(randomIndex), timesNameUsed);
        return newDogName;
    }
}