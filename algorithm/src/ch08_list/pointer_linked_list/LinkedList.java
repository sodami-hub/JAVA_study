package ch08_list.pointer_linked_list;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> cur;


    // 생성자
    public LinkedList() {
        head = cur = null;
    }

    // 탐색
    public E search(E data, Comparator<? super E> c) {
        Node<E> ptr;
        ptr = head;
        if (ptr == null) {
            System.out.println("empty LinkedList");
            return null;
        }
        while (ptr != null) {
            if (ptr.data == data) {
                cur = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 머리에 노드 추가
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = cur = new Node<E>(obj, ptr);
    }

    // 꼬리에 노드 추가
    public void addLast(E obj) {
        Node<E> ptr = head;
        if (head == null) {
            addFirst(obj);
        } else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = cur = new Node<E>(obj, null);
        }
    }

    //머리 노드 삭제
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty LinkedList");
        } else {
            head = cur = head.next;
        }
    }

    //꼬리 노드 삭제
    public void removeLast() {
        Node<E> ptr = head;

        if (head == null) {
            System.out.println("Empty LinkedList");
        } else {
            while (ptr.next != null) {
                cur = ptr;
                ptr = ptr.next;
            }
            cur.next = null;
        }
    }

    // 전달 받은 노드를 삭제.
    public void remove(Node delNode) {
        Node<E> ptr;
        if (head != null) {
            if (delNode == head) {
                removeFirst();
            } else {
                ptr = head;
                while (ptr != delNode) {
                    cur = ptr;
                    ptr = ptr.next;
                    if (ptr == null) {
                        System.out.println("do not have the Node");
                        return;
                    }
                }
                cur.next = ptr.next;
            }
        }
    }

    public void removeCurrentNode() {
        Node<E> ptr = head;
        if(cur == head) {
            removeFirst();

        } else {
            while (ptr.next != cur) {
                ptr = ptr.next;
            }
            ptr.next = cur.next;
            cur = ptr;
        }
    }

    public void next() {
        if(cur.next != null) {
            cur = cur.next;
        }
    }

    public void printCurrentNode() {
        if(cur == null) {
            System.out.println("선택한 노드가 없다.");
        } else {
            System.out.println("currentNode : " + cur.data);
        }
    }

    // 모든 노드 삭제
    public void clear() {
        while (head != null) {
            removeFirst();
        }
        cur = head;
    }

    public void dump() {
        cur = head;
        if (head == null) {
            System.out.println("Empty LinkedList");
        } else {
            while (cur != null) {
                System.out.print(cur.data + " - ");
                cur = cur.next;
            }
        }

    }

}
