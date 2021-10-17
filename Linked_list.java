public class Linked_list {

    public static class Node
    {
        int data;
        Node next;
    }

    public static class Linklist
    {
        Node front;
        int size;

        
      
        public  void insert(int d,int pos)
        {
            Node temp = new Node();
            temp.data = d;
            
            Node other = front;
            
            for(int i=0;i<pos-1;i++)
            {
                other=other.next;
            }

            other.next = temp;
            temp.next = temp;

            size++;

        }

        public  Node delete(int pos)
        {
 
            Node other = front;
            
            for(int i=0;i<pos-1;i++)
            {
                other=other.next;
            }

            Node save = other.next;
            save.next = null;
            Node temp = other.next.next;
            other.next = null;
            other.next = temp;

            size--;

            return save;

        }





    }
    
}
