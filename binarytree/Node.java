package oop.binarytree;

public class Node<T>
{
    private T content;

    private Node<T> left, right;

    // Konstruktor mit Parametern für content, left und right
    public Node(T content, Node<T> left, Node<T> right)
    {
        this.content = content;
        this.left = left;
        this.right = right;
    }

    // Konstruktor nur mit Parameter für content (=> left, right null)
    public Node(T content)
    {
        this(content, null, null);
    }

    // Getter- und Setter-Methoden für content, left und right
    public T getContent()
    {
        return content;
    }

    public void setContent(T content)
    {
        this.content = content;
    }

    public Node<T> getLeft()
    {
        return left;
    }

    public void setLeft(Node<T> left)
    {
        this.left = left;
    }

    public Node<T> getRight()
    {
        return right;
    }

    public void setRight(Node<T> right)
    {
        this.right = right;
    }
}
