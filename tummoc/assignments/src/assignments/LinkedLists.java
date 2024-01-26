package assignments;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedLists {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void printReverse(Node node) {
        if (node == null) {
            return;
        }

        printReverse(node.next);
        System.out.print(node.data + " ");
    }

    public void printReverseList() {
        System.out.print("Reversed List: ");
        printReverse(head);
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();

        // Adding elements to the linked list
        linkedLists.addNode(1);
        linkedLists.addNode(2);
        linkedLists.addNode(3);
        linkedLists.addNode(4);
        linkedLists.addNode(5);

        // Printing the linked list in reverse order
        linkedLists.printReverseList();
    }
}
