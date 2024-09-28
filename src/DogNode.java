public class DogNode {

    private DogNode left;

    private DogNode right;

    private int age;
    private int weight;
    private String breed;
    private String name;
    private double tailLength;

    public DogNode(String name, double tailLength){
        this.name = name;
        this.tailLength = tailLength;
    }

    public String getName(){
        return name;
    }

    public double getTailLength(){
        return tailLength;
    }

    public DogNode getLeft(){
        return left;
    }

    public DogNode getRight(){
        return right;
    }

    public void setRight(DogNode dog){
        this.right = dog;
    }

    public void setLeft(DogNode dog){
        this.left = dog;
    }
}
