package com.cochabamba.interview.exagens;

class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {

        int leftCounter=0;
        Node pivot=this;
        while(pivot!=null && pivot.leftChild!=null) {
            leftCounter++;
            pivot = pivot.leftChild;
        }

        int rightCounter=0;
        Node pivot2=this;
        while(pivot2!=null && pivot2.rightChild!=null) {
            rightCounter++;
            pivot2 = pivot2.rightChild;
        }

        return leftCounter>rightCounter?leftCounter:rightCounter;
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height());
    }
}
