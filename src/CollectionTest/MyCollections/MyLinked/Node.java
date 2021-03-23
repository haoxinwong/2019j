/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MyCollections.MyLinked;

/**
 *
 * @author WarSpite
 */
public class Node {
    Node previous;//上一个元素
    Node next;//下一个元素
    Object element;//元素数据

    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        super();
        this.element = element;
    }
    
    
}
