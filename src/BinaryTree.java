import org.w3c.dom.Node;

import java.util.Comparator;

public class BinaryTree {

    DogNode root;

    Comparator<DogNode> comparator;

    public BinaryTree(Comparator<DogNode> comparator){
        this.comparator = comparator;
        root = null;
    }

    public void add(DogNode currentNode, DogNode newNode) {

        if(root == null){
            root = newNode;
        }else {

            int comparisonResult = comparator.compare(currentNode, newNode);

            if (comparisonResult > 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                } else {
                    add(currentNode.getLeft(), newNode);
                }
            } else if (comparisonResult <= 0) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                } else {
                    add(currentNode.getRight(), newNode);
                }
            }
        }
    }

    public void printContent(DogNode dogNode){
        if(dogNode != null){
            printContent(dogNode.getRight());
            System.out.println((dogNode.getRight() != null) ? dogNode.getRight().getName() +" to the right" : "Nothing to the right");
            System.out.println("Dog name: " + dogNode.getName() + " || Tail length: " + dogNode.getTailLength());
            System.out.println((dogNode.getLeft() != null) ? dogNode.getLeft().getName() + " to the left" : "Nothing to the left");
            printContent(dogNode.getLeft());
        }
    }
}
