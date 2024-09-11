package ch08_list.array_linked_list;

import java.util.Comparator;

public class ArrayLinkedList<E> {

    public class Node<E> {
        private E data;
        private int next;
        private int dnext;

        Node() {

        }

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] arr;
    private int size;
    private int max;
    private int head;
    private int crnt;
    private int deleted;
    private static final int NULL = -1;


    // 생성자
    public ArrayLinkedList(int capacity) {
        head=crnt=deleted=max=NULL;
        try {
            arr = new Node[capacity];
            for(int i=0; i<capacity; i ++) {
                arr[i] = new Node<E>();
            }
            size=capacity;
        } catch(OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    // 다음에 삽입하는 record의 인덱스 구하기
    private int getInsertIndex() {
        if(deleted == NULL) {
            if(max<size) {
                return ++max;
            } else {
                return NULL; // 배열이 꽉 참
            }
        } else {
            int temp = deleted;
            deleted = arr[temp].dnext;
            return temp;
        }
    }

    // 삭제한 인덱스를 프리리스트에 저장
    private void deleteIndex(int idx) {
        if(deleted == NULL) {
            deleted = idx;
        } else {
            int temp = deleted;
            deleted = idx;
            arr[deleted].dnext = temp;
        }
    }

    //노드 검색
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;

        while (ptr != NULL) {
            if(c.compare(obj,arr[ptr].data) == 0) {
                crnt = ptr;
                return arr[ptr].data;
            }
            ptr = arr[ptr].next;
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        int temp = head;

        int idx = getInsertIndex();
        if(idx !=NULL) {
            head = crnt = idx;
            arr[head].set(obj, temp);
        }
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        if(head == NULL) {
            addFirst(obj);
        } else {
            int ptr = head;
            while(arr[ptr].next != NULL) {
                ptr= arr[ptr].next;
            }
            int index = getInsertIndex();
            arr[index].set(obj,NULL);
            arr[ptr].next= crnt = index;
        }
    }

    // 머리 노드 삭제
    public void removeFirst() {
        if(head != NULL) {
            int temp = head;
            deleteIndex(head);
            head =crnt = arr[temp].next;
        }
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        if(head != NULL) {
            if(arr[head].next == NULL) {
                removeFirst();
            } else {
                int ptr = head;
                int pre = head;
                while(arr[ptr].next != NULL) {
                    pre = ptr;
                    ptr = arr[ptr].next;
                }
                arr[pre].next = NULL;
                deleteIndex(ptr);
                crnt=pre;
            }
        }
    }

    //record(index) P를 삭제
    public void remove(int p) {
        if(head != NULL) {
            if(head == p) {
                removeFirst();
            } else {
                int ptr = head;

                while(arr[ptr].next != p) {
                    ptr = arr[ptr].next;
                    if(ptr == NULL) {
                        return;
                    }
                    deleteIndex(p);
                    arr[ptr].next = arr[p].next;
                    crnt = ptr;
                }
            }
        }
    }

    // 현재 선택된 노드 crnt 위치 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드 삭제
    public void clear() {
        while(head!=NULL) {
            removeFirst();
        }
        crnt=NULL;
    }

    // 현재 선택 된 노드 출력
    public void printCurrentNode() {
        if (crnt ==NULL) {
            System.out.println("선택된 노드가 없다.");
        }else {
            System.out.println(arr[crnt].data);
        }
    }

    // 모든 노드 출력
    public void dump() {
        int ptr= head;
        if(ptr!=NULL) {
            System.out.print(arr[ptr].data+" ");
            ptr = arr[ptr].next;
        }
    }
}

