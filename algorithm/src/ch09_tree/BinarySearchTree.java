package ch09_tree;

import java.util.Comparator;

public class BinarySearchTree<K, V> {

    static class Node<K, V> {
        K key;
        V data;
        Node<K, V> lChild;
        Node<K, V> rChild;


        public Node(K key, V data, Node<K, V> lChild, Node<K, V> rChild) {
            this.key = key;
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) {
                return null;
            }
            int res = comp(key, p.getKey());
            if (res == 0) {
                return p.getValue();
            } else if (res < 0) {
                p = p.lChild;
            } else {
                p = p.rChild;
            }
        }
    }

    // node를 루트로 하는 서브트리에 노드를 삽입
    private void addNode(Node<K, V> node, K key, V value) {
        int compare = comp(key, node.getKey());
        if (compare == 0) {
            return;
        } else if (compare < 0) {
            if (node.lChild == null) {
                node.lChild = new Node<K, V>(key, value, null, null);
            } else {
                addNode(node.lChild, key, value);
            }
        } else {
            if (node.rChild == null) {
                node.rChild = new Node<K, V>(key, value, null, null);
            } else {
                addNode(node.rChild, key, value);
            }
        }
    }

    // 노드를 삽입
    public void add(K key, V value) {
        if (root == null) {
            root = new Node<K, V>(key, value, null, null);
        } else {
            addNode(root, key, value);
        }
    }

    // 키값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        Node<K, V> delNode = null;
        boolean isLeft = false;

        if (root == null) {
            return false;
        }
        parent = root;

        // 삭제할 노드 찾기.
        while (true) {
            int compare = comp(key, p.getKey());

            if (compare == 0) {
                delNode = p;
                break;
            } else if (compare < 0) {
                if (p.lChild != null) {
                    parent = p;
                    p = p.lChild;
                    isLeft = true;
                } else {
                    return false;
                }
            } else {
                if (p.rChild != null) {
                    parent = p;
                    p = p.rChild;
                    isLeft = false;
                } else {
                    return false;
                }
            }

        }

        if (delNode.lChild == null && delNode.rChild == null) {
            if (isLeft) {
                parent.lChild = null;
            } else {
                parent.rChild = null;
            }
        } else if(delNode.lChild ==null) {
            if (isLeft) {
                parent.lChild = delNode.rChild;
            } else {
                parent.rChild = delNode.rChild;
            }
        } else if(delNode.rChild == null) {
            if (isLeft) {
                parent.lChild = delNode.lChild;
            } else {
                parent.rChild = delNode.lChild;
            }
        } else {
            Node<K, V> changeNode = findMaxNode(delNode);
            changeNode.lChild = delNode.lChild;
            changeNode.rChild = delNode.rChild;
            if(isLeft) {
                parent.lChild = changeNode;
            } else {
                parent.rChild= changeNode;
            }
        }
        return true;
    }

    private Node<K, V> findMaxNode(Node<K, V> p) {
        Node<K, V> parent = p;
        Node<K,V>  find = p.lChild;

        while(find.rChild != null) {
            parent = find;
            find = find.rChild;
        }
        if(find.lChild != null) {
            p.lChild =find.lChild;
        }

        return find;
    }

    private void printSubTree(Node node) {
        if(node.lChild != null) {
            printSubTree(node.lChild);
        }
        System.out.print("{"+node.key + "," +node.data+"}" + " / ");

        if(node.rChild != null) {
            printSubTree(node.rChild);
        }
    }

    public void print() {
        printSubTree(root);
        System.out.println();
    }
}
