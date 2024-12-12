package org.miu.lesson8.prob4;

public class DoublyLinkedList {

        Node header;
        DoublyLinkedList(){
            header = new Node();
        }
        //1. adds to the end of the list
        public void addLast(String item){
            //implement
            Node newNode = new Node();
            newNode.value = item;

            if (header.next == null) {
                header.next = newNode;
                newNode.previous = header;
            } else {
                Node current = header;
                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
                newNode.previous = current;
            }

        }

        public boolean remove(String item){
            if (header.next == null) {
                return false;
            }

            Node current = header.next;

            while (current != null) {
                // If item is found
                if (current.value.equals(item)) {

                    if (current.previous != header) {
                        current.previous.next = current.next;
                    } else {
                        // If removing the first node
                        header.next = current.next;
                    }

                    if (current.next != null) {
                        current.next.previous = current.previous;
                    }

                    return true;
                }
                current = current.next;
            }

            return false;
        }

        public boolean removeFirst() {
            if (header.next == null) {
                return false;
            }

            Node firstNode = header.next;

            header.next = firstNode.next;

            if (firstNode.next != null) {
                firstNode.next.previous = header;
            }

            return true;
        }


        public void printReverse() {
            if (header.next == null) {
                return;
            }

            Node current = header.next;
            while (current.next != null) {
                current = current.next;
            }

            while (current != header) {
                System.out.print(current.value + " ");
                current = current.previous;
            }
            System.out.println();
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            toString(sb, header);
            return sb.toString();

        }
        private void toString(StringBuilder sb, Node n) {
            if(n==null) return;
            if(n.value != null) sb.append(" " + n.value);
            toString(sb, n.next);
        }

        class Node {
            String value;
            Node next;
            Node previous;

            public String toString() {
                return value == null ? "null" : value;
            }
        }

        public static void main(String[] args){
            DoublyLinkedList list = new DoublyLinkedList();
            list.addLast("Bob");
            list.addLast("Harry");
            list.addLast("Steve");
            System.out.println(list);

            // Call all your implemented Methods
            // Test remove
            System.out.println("Removing Harry: " + list.remove("Harry"));
            System.out.println(list);

            // Test removeFirst
            System.out.println("Removing first node: " + list.removeFirst());
            System.out.println(list);

            // Test printReverse
            System.out.print("Reverse order: ");
            list.printReverse();
        }

}
