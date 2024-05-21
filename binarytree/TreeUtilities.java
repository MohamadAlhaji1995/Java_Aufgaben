package oop.binarytree;

import java.util.Stack;

public class TreeUtilities
{
    public static <T> String treeToString(Node<T> root)
    {
        StringBuilder sb = new StringBuilder();
        treeToStringHelper(root, 0, sb);
        return sb.toString();
    }

    private static <T> void treeToStringHelper(Node<T> node, int depth, StringBuilder sb)
    {
        if (node == null)
            return;
        sb.append("|__".repeat(depth)).append(node.getContent()).append("\n");
        treeToStringHelper(node.getLeft(), depth + 1, sb);
        treeToStringHelper(node.getRight(), depth + 1, sb);
    }

    public static <T> Node<T> cloneTree(Node<T> root)
    {
        if (root == null)
            return null;
        return new Node<>(root.getContent(), cloneTree(root.getLeft()), cloneTree(root.getRight()));
    }

    public static <T> boolean compareTrees(Node<T> a, Node<T> b)
    {
        if (a == null && b == null)
            return true;
        if (a != null && b != null && a.getContent().equals(b.getContent()))
            return compareTrees(a.getLeft(), b.getLeft()) && compareTrees(a.getRight(), b.getRight());
        return false;
    }

    public static int evaluateTree(Node<String> root)
    {
        if (root == null)
            throw new IllegalArgumentException("Node is null");
        String content = root.getContent();
        try
        {
            int value = Integer.parseInt(content);
            if (root.getLeft() != null || root.getRight() != null)
                throw new IllegalArgumentException("Leaf node with a number should not have children.");
            return value;
        }
        catch (NumberFormatException e)
        {
            if (root.getLeft() == null || root.getRight() == null)
                throw new IllegalArgumentException("Operator node must have two children.");
            int leftValue = evaluateTree(root.getLeft());
            int rightValue = evaluateTree(root.getRight());
            switch (content)
            {
                case "+":
                    return leftValue + rightValue;
                case "-":
                    return leftValue - rightValue;
                case "*":
                    return leftValue * rightValue;
                case "/":
                    return leftValue / rightValue;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + content);
            }
        }
    }

    public static void main(String[] args)
    {
        // Erstellen eines Beispiel-Ausdrucksbaums für den Ausdruck (1*2) +
        // ((3/(4-5))-6)
        Node<String> root = new Node<>("+", new Node<>("*", new Node<>("1"), new Node<>("2")), new Node<>("-", new Node<>("/", new Node<>("3"), new Node<>("-", new Node<>("4"), new Node<>("5"))), new Node<>("6")));

        // Test der treeToString-Methode
        System.out.println("Tree Representation:\n" + TreeUtilities.treeToString(root));

        // Test der cloneTree-Methode
        Node<String> clonedTree = TreeUtilities.cloneTree(root);
        System.out.println("Cloned Tree Representation:\n" + TreeUtilities.treeToString(clonedTree));

        // Test der compareTrees-Methode
        boolean isSame = TreeUtilities.compareTrees(root, clonedTree);
        System.out.println("Are both trees same? " + isSame);

        // Test der evaluateTree-Methode
        try
        {
            int result = TreeUtilities.evaluateTree(root);
            System.out.println("Evaluated Result: " + result);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error in evaluating tree: " + e.getMessage());
        }
    }
}
