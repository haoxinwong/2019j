/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionTest.MapTest;

/**
 *
 * @author WarSpite
 */
public class InformationHash {
    /**
     * 将”key-value两个对象”成对存放到HashMap的Entry[]数组
     * 1)获得key对象的hashcode
     *   首先调用key对象的hashcode()方法，获得hashcode。
     * 2)根据hashcode计算出hash值
     * 3)生成Entry对象
     *   一个Entry对象包含4部分：key对象、value对象、
     *                        hash值、指向下一个Entry对象的引用。
     * 4)将Entry对象放到table数组中
     *   - 如果本Entry对象对应的数组索引位置还没有放Entry对象，
     *     则直接将Entry对象存储进数组
     *   - 如果对应索引位置已经有Entry对象，
     *     则将已有Entry对象的next指向本Entry对象，
     *     形成链表。
     * 
     * 总结：当添加一个元素(key-value)时，首先计算key的hash值，以此确定插入数组中的位置
     *      但是可能存在同一hash值的元素已经被放在数组同一位置了，
     *      这时就添加到同一hash值的元素的后面
     *      们在数组的同一位置，就形成了链表，
     *      同一个链表上的Hash值是相同的，所以说数组存放的是链表。
     *      JDK8中，当链表长度大于8时，
     *      链表就转换为红黑树，这样又大大提高了查找的效率。
     *     
     */
    
}
