public class LinkedList <AnyType extends IDedObject>
{

    private Node<AnyType> head;

    public LinkedList() // constructor
    {
        head = null;
    }

    public void makeEmpty() // empties the list in its entirety
    {
        head = null;
    }

    public AnyType findID(int ID)
    {
        Node<AnyType> temp = head; // temporary node to traverse the list
        while (temp!=null)
        {
            if(temp.data.getID()==ID) // if we find a node with the target ID
            {
                return temp.data;
            }
            temp = temp.next;
        }
        return null; // if ID wasn't found
    }

    public boolean insertAtFront(AnyType X)
    {
        if (findID(X.getID()) != null) // if node/ID exists with an existing ID
        {
            return false;
        }

        Node<AnyType> newHead = new Node<>(X,head); // insert the new node pointing to the head
        head = newHead; // make the new node the new head

        return true;

    }

    public AnyType deleteFromFront()
    {
        if (head==null) // if list is empty
        {
            return null;
        }

        Node<AnyType> temp = head; // reference to head node to be deleted
        head = head.next; // new head node
        temp.next = null;
        return temp.data;

    }

    public AnyType delete(int ID)
    {

        if (head == null)
        {
            return null; // List is empty
        }

        if (head.data.getID() == ID) // if the head node contains the target ID
        {
            return deleteFromFront();
        }

        Node<AnyType> previous = null;
        Node<AnyType> current = head;
        while (current != null && current.data.getID() != ID) // traversing the list until target is reached
        {
            previous = current;
            current = current.next;

        }

        if (current == null) {
            return null; // ID not found
        }

        AnyType deletedData = current.data; // reference to the node we want to delete
        assert previous != null;
        previous.next = current.next; // redirect the linked list
        return deletedData;

    }

    public void printAllRecords()
    {
        Node<AnyType> temp = head;
        while (temp!=null)
        {
            temp.data.printID();
            temp = temp.next;
            System.out.println();
        }

    }

    public boolean isEmpty()
    {
        return head == null;
    }


    private static class Node<AnyType extends IDedObject>
    {
        AnyType data; // data such as ID, Name, Supplier
        Node<AnyType> next; // set the node that the current node will point to

        Node(AnyType data, Node<AnyType> next) // constructor
        {
            this.data = data;
            this.next = next;
        }
    }


}
