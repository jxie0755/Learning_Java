package Java_Classes;

import java.util.*;

class A08_Collection {

    /*
     * Module java.base
     * Package java.util
     * Interface Collection<E>
     * Collection上接Iterable父接口
     * Colection下接:
     * List接口
     * ArrayList、LinkedList、Vector、Stack
     * Set接口
     * HashSet、LinkedHashSet、TreeSet
     * Queue
     * Deque接口 既继承Collection也继承Queue
     * LinkedList 也继承于Deque和Queue
     */

    /*
     * Collection 常用方法
     * 因为Collection子类有Set是无序的, 所以Collection作为通用方法不带任何index参数
     * forEach                             来自Iterable,详见Java_Basics.C10b_For_each_Loop
     * size()
     * clear()                             清空
     * isEmpty()                           size==0?
     * add(E e)                            向集合中添加一个元素，若添加元素后集合发生了变化就返回boolean (方便Set)
     * addAll(Collection<?> c)             添加给定集合c中的所有元素到该集合中
     * remove(Object o)                    移除给定对象的一个实例（有的具体集合类型允许重复元素）
     * removeAll(Collection<?> c)          移除元素集合c
     * retainAll(Collection<?> c)          仅保留给定集合c中的元素
     * contains(Object o)                  判断该集合中是否包含指定对象
     * containsAll(Collection<?> c)
     * equals(Object o)
     * hashCode()
     * iterator()
     * toArray()
     */

}


class A08_Collection_zMethods {

    // 所有子接口都同样有这些方法
    public static void main(String[] args) {
        // 这里不实现这些方法,到子类具体再使用

        // 构造 也是要通过子类实现, 比如ArrayList, 但没必要, 这个interface太抽象了
        Collection<Object> objBox = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
    }
}


class A08b_List {
    /*
     * Module java.base
     * Package java.util
     * Interface List<E>
     * List代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。
     * List是一个接口, 不能被直接实现, 需要通过其他子类实现, 常用子类
     * 主要靠ArrayList实现
     * LinkedList
     * Stack
     * Vector (多线程, 一般不用)
     * 注意：
     * List集合默认按元素的添加顺序设置元素索引，例如第一次添加元素索引为0，第二次添加索引为1…
     * List是Collection的子接口，可以使用Collection接口里的全部方法。
     * 因为List是有序集合，所以它有一些根据索引来操作集合元素的方法。
     */

    /*
     * List 最基本的操作
     * 来自Iterable
     * forEach()
     * iterator()
     * 来自Collection
     * add(E e)                     相当于append, 附带return boolean
     * remove(Object o)             相当于del
     * addAll(Collection<?> c)      类并集
     * removeAll(Collection<?> c)   类差集
     * retainAll(Collection<?> c)   类交集
     * contains(Object o)           相当于x in lst
     * containsAll(Collection<?> c) 相当于 lst A is a subList of B
     * size()                       相当于len
     * equals(Object o)             相当于 == 但是更准确
     * clear()
     * isEmpty()
     * toArray()
     * hashcode()
     * 来自List
     * get(idx i)                        相当于lst[i]
     * set(idx i, item)                  相当于lst[i] = n
     * add(int index, E element)       相当于insert(重载)
     * addAll(idx, Collection<?>)      指定index(重载)
     * remove(int index)                     相当于pop
     * subList(int fromIndex, int toIndex)   相当于切片list[i:j]
     * indexOf(Object o)
     * lastIndexOf(Object o)
     * containsAll(Collection<?> c)          相当于 c is a subList of this
     * copyOf(Collection<? extends E> coll) (inmutable)
     * of (build a tuple)
     * listIterator()
     * listIterator(int index)                starting at a specific index
     */
}


class A08b_List_zMethods {


    public static void main(String[] args) {
        // 构造方法
        List<Object> LO1 = new ArrayList<>();  // 空列表   // 不要省略泛型
        // 参数可以是任何一个Collection子类


        // 快速构建
        // List<Integer> L2 = [1, 2, 3, 2, 1];  不行
        // List<Integer> L2 = Arrays.asList(1,2,3,4,5);   // [1, 2, 3, 2, 1]
        // 可行但是这样是固定长度了(参见Arrays.asList)
        // 正确方法
        List<Integer> L2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        List<Object> LO2 = new ArrayList<>(Arrays.asList("a", "b", "c"));   // 不限定类型, List后不要<>

        // 通用方法
        System.out.println(LO1.isEmpty());  // >>> true

        // L2.clear();  // 清空

        // contains 和 containsAll (代替in)
        System.out.println(L2.contains(3));  // >>> true
        System.out.println(LO2.containsAll(L2)); // >>>  true

        List<Object> LO3 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));   // 注意, L3和L2有一点点不同,L3不限类型
        System.out.println(LO3.equals(L2)); // >>> true         // 只要内容相等即可, 不在乎类型
        // System.out.println(LO3 == L2);  就不行


        // List接口的专有方法 (除了Collection通用方法多出来的方法)

        // get and set
        List<Object> LO6 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        LO6.set(1, "x");  // [c, x, e]
        System.out.println(LO6.get(1)); // >>>  x  (this is a copy)


        // indexOf and lastIndexOf 从两端找index
        List<Object> LO7 = new ArrayList<>(Arrays.asList("c", "d", "e", "d"));
        System.out.println(LO7.indexOf("d"));          // >>> 1
        System.out.println(LO7.lastIndexOf("d"));   // >>> 3

        // subList
        // 返回的是一个view of SubList
        List<Object> LO8 = new ArrayList<>(LO7.subList(1, 4));  // always New一个对象避免冲突
        System.out.println(LO8);  // >>>  [d, e, d]
        // 也可以用来批量修改和删除一个list

        List<Integer> L3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> L3sub = L3.subList(0, 3);
        L3sub = List.of(7, 8, 9);
        System.out.println(L3); // >>>  [1, 3, 4, 5]

        // 其他注意点, 详见zLearnings.Java_View

        // sort(Comparator<? super E> c)
        // 使用List.sort()传入自己实现Commparator接口的类的对象，实现自定义排序
        // 这里涉及到自行设计一个Comparator所以此方法不常用, 更多的是用java.util.Collections.sort
        // 参见Java_101/Java_Classes/A11_Comparator

        // iterator()
        // listIterator()
        // listIterator(int index)  starting at a specific index
        // 把list变成一个Iterator或者是ListIterator
        // 详见 A09_Iterator

        // forEach loop
        // 详见Java_Basics.C10b_For_each_Loop

        // List.of()  相当于一个不可变List, 如同一个python的tuple
        List<Integer> tuple = List.of(1, 2, 3, 4);
        System.out.println(tuple); // >>>  [1, 2, 3, 4]
    }
}

class A08b_List_as_set {

    public static void main(String[] args) {

        // List同样支持Collectin中给Set的方法, 只是比较相似

        // 类交集
        // retainAll
        List<Object> LO1 = new ArrayList<>(Arrays.asList("a", "b", "c", "c", "d", "e"));
        List<Object> LO2 = new ArrayList<>(Arrays.asList("c", "d"));
        LO1.retainAll(LO2);  // >>>  [c, c, d]  // 类似求交集,但是不去重

        // 类并集
        List<Object> LO3 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        List<Object> LO4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        LO3.addAll(LO4);   // [1, 2, 3, 2, 1 a, b, c]  // 默认是末尾

        // 类差集
        List<Object> LO5 = new ArrayList<>(Arrays.asList("a", "b", "c", 1, 2, 3, 2, 1));
        List<Object> LO6 = new ArrayList<>(Arrays.asList("a", 1, 2, 3));
        LO5.removeAll(LO6);        //     变成: [b, c]   (两个1都被删)


        // 把一个list去重怎么办? 类型转换
        // 相当于pythong中 lst1 = list(set(lst2))
        List<Object> LOX = new ArrayList<>(Arrays.asList(1, 2, "A", 1, 3, "A"));
        List<Object> LOXsetList = new ArrayList<>(new HashSet<>(LOX));
        System.out.println(LOXsetList);  // >>> [1, A, 2, 3]  注意顺序奇怪

    }
}


class A08b_List_add {
    public static void main(String[] args) {

        List<Object> LO1 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        // add    被重载了, 支持选择插入位置
        LO1.add(99);                   // [1, 2, 3, 2, 1, 99]  // 默认是末尾
        LO1.add(2, 99);   // [1, 2, 99, 3, 2, 1, 99]

        // addAll 有两种方式, 无index或者index
        // 无index是类并集方法, 参见A08b_List_as_set
        // addAll 被重载了, 支持选择一个index位置加
        List<Object> LO2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<Object> LO3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        LO2.addAll(1, LO3);  // [a, 1, 2, 3, b, c]
    }

}

class A08b_List_remove {
    public static void main(String[] args) {

        List<Object> L2 = new ArrayList<>(Arrays.asList("a", "b", "c", 1, 2, 3, 2, 1));
        List<String> LO2 = new ArrayList<>(Arrays.asList("a", "b", "c", "c", "c"));
        List<String> LO3 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        List<Integer> LO4 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 4, 1, 5, 1, 6));

        // remove (object)
        // return true if the element is removed
        System.out.println(LO4.remove(Integer.valueOf(1)));
        // true:  now [2, 1, 3, 1, 4, 1, 5, 1, 6] 从头开始找, 只删1个
        System.out.println(LO4.remove(Integer.valueOf(99)));
        // false: now still [2, 1, 3, 1, 4, 1, 5, 1, 6] 找不到就不删

        // 特殊方法是remove index, remove (重载)
        // 自带return被删去的值,相当于python的pop()!!!!
        Integer a = LO4.remove(0);
        //     [1, 3, 1, 4, 1, 5, 1, 6]
        System.out.println(a);
        System.out.println(LO4);  // >>>  [1, 3, 1, 4, 1, 5, 1, 6]

        // removeAll
        // 类差集, 参见A08b_List_as_set
        // 删掉所有1?
        LO4.removeAll(List.of(1));  // [3, 4, 5, 6]   //巧用 或者List.of
    }
}

class A08b_List_toArray {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Object[] objs = l.toArray();     // 可以
        // String[] strs = l.toArray();  // 不行, throw ClassCastException

        // 或者使用转型?
        // String[] strs = (String[]) objs;
        // System.out.println(Arrays.toString(strs));  // 还是不行!

        // 正确做法, 分两步:
        String[] strs = new String[l.size()];
        l.toArray(strs);
        // 或者一步
        String[] strs_b = l.toArray(new String[l.size()]);
        // 这样可以得到一个 String[]  [A, B, C]

        // 如果创建的额String[]比l还长很多会如何?
        String[] strs2 = new String[5];
        l.toArray(strs2);   // [A, B, C, null, null]  // 多出两个null
    }
}

class A08b_List_copy {
    public static void main(String[] args) {

        // CopyOf  // 注意,这个copy是imutable
        List<Object> LO1 = new ArrayList<>(Arrays.asList("a", 1, 2, 3, "b", "c"));
        List<Object> LO10 = List.copyOf(LO1);  // [a, 1, 2, 3, b, c]
        // 解决方案, 直接代入到new instance (相当于浅copy)
        List<Object> LO11 = new ArrayList<>(LO1);  // [a, 1, 2, 3, b, c]
        System.out.println(LO11.equals(LO1)); // >>> true

        // 若是多维数组可以吗?
        List<Integer> LL1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> LL2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> LL3 = new ArrayList<>(Arrays.asList(7, 8, 9));

        List<List<Integer>> Lgrid = new ArrayList<>(Arrays.asList(LL1, LL2, LL3));
        System.out.println(Lgrid);  // >>> [[1, 2], [4, 5, 6], [7, 8, 9]]
        LL1.add(3);
        System.out.println(Lgrid);  // >>> [[1, 2, 3], [4, 5, 6], [7, 8, 9]]  // impacted by LL1

        // 如果直接new对象. 能否是deep copy? 不行!
        List<List<Integer>> Lgrid2 = new ArrayList<>(Lgrid);
        LL1.add(3);
        System.out.println("before: " + Lgrid2); // >>> [[1, 2, 3, 3], [4, 5, 6], [7, 8, 9]]  // impacted by LL1
        Lgrid.get(0).add(3);
        System.out.println("after:  " + Lgrid2);
        // Lgrid2 changed, so it is still a shallow copy
        // copy from Collections
    }
}


class A08c_Queue {

    /*
     * Module java.base
     * Package java.util
     * Interface Queue<E>
     */

    // 注意Queue没有index, 没有get和set

    /*
     * Queue常用方法
     * 来自Iterable
     * forEach                             来自Iterable,详见Java_Basics.C10b_For_each_Loop
     * iterator
     * 来自Collection
     * add(E e)                            向集合中添加一个元素，若添加元素后集合发生了变化就返回boolean (方便Set)
     * addAll(Collection<?> c)             添加给定集合c中的所有元素到该集合中
     * clear
     * contains                           判断该集合中是否包含指定对象
     * containsAll
     * equals
     * hashCode
     * isEmpty
     * size
     * toArray
     * remove(Object o)                    移除给定对象的一个实例（有的具体集合类型允许重复元素）若不存在返回null
     * removeAll(Collection<?> c)          移除元素集合c
     * removeIf
     * retainAll(Collection<?> c)          仅保留给定集合c中的元素
     * 来自Queue
     * element()                           Retrieves, but does not remove, the head of this queue.
     * peek()	                         与element相同, 但是如果为空,则返回null而不会报错
     * poll()	                         在peek()基础上,再移除head, 安全型
     * offer(E e)                         如Capacity允许就添加. 返回boolean指示是否成功
     * remove                             砍头(重载), 并返回head的value
     */
}

class A08c_Queue_zMethods {

    public static void main(String[] args) {

        // 构造方法 (通过LinkedList)
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Queue<Integer> empt = new LinkedList<>();

        // Queue的独特方法
        // element
        System.out.println(q1.element()); // >>>  1
        // System.out.println(empt.element()); error

        // peek
        System.out.println(q1.peek());    // >>>  1
        System.out.println(empt.peek());  // >>>  null

        // poll
        System.out.println(q1.poll());    // >>>  1
        System.out.println(q1);           // [2, 3, 4, 5]
        System.out.println(empt.poll());  // >>>  null

        // offer
        // add to the end if capacity allows
        System.out.println(q1.offer(9));
        System.out.println(q1); // >>>  [2, 3, 4, 5, 9]

        // remove
        System.out.println(q1.remove());  // >>>  2
        // System.out.println(empt.remove());  // error
    }

}


class A08d_Deque {

    /*
     * Module java.base
     * Package java.util
     * Interface Deque<E>
     */

    /*
     * Deque上同时接Collection和Queue

     * Deque虽然也是Collection旗下, 和List平级
     * 但是LinkedList同时继承List接口和Deque接口,功能更强大
     * 而ArrayList只继承List接口
     */

    // 注意Deque没有index, 没有get和set

    /*
     * Deque常用方法
     * 来自Iterable
     * forEach                             来自Iterable,详见Java_Basics.C10b_For_each_Loop
     * iterator
     * 来自Collection
     * add(E e)                            向集合中添加一个元素，若添加元素后集合发生了变化就返回boolean (方便Set)
     * addAll(Collection<?> c)             添加给定集合c中的所有元素到该集合中
     * clear
     * contains                            判断该集合中是否包含指定对象
     * containsAll
     * equals
     * hashCode
     * isEmpty
     * size
     * toArray
     * remove(Object o)                    移除给定对象的一个实例（有的具体集合类型允许重复元素）若不存在返回null
     * removeAll(Collection<?> c)          移除元素集合c
     * removeIf
     * retainAll(Collection<?> c)          仅保留给定集合c中的元素
     * 来自Queue
     * element()                          Retrieves, but does not remove, the head of this queue.
     * peek()	                          与element相同, 但是如果为空,则返回null而不会报错
     * poll()	                          在peek()基础上,再移除head, 安全型
     * offer(E e)                         如Capacity允许就添加. 返回boolean指示是否成功
     * remove                             砍头(重载), 并返回head的value
     * 来自Deque
     * addFirst (E e)             insert at idx0    with capacity allowance
     * addLast(E e)               insert at the end with capacity allowance
     * push                       与addFirst完全相同
     * offerFirst                 addFirst with capacity allowance (boolean确认)
     * offerLast                  addLast with capacity allowance (boolean确认)
     * descendingIterator()
     * element()                  取head值,但是不去掉head   (non-empty)
     * getFirst()                 get the first elmement (non-empty) 与element()相同
     * getLast()                  get the last element   (non-empty)
     * peekFirst()                安全型getFirst, 防止空表
     * peekLast()                 安全型getLast, 防止空表
     * pollFirst()                在peekFirst()基础上,再移除head, 安全型
     * pollLast()                 在peekLast()基础上, 再移除tail, 安全型
     * pop()                      非安全型pollFirst
     * removeFirst()              非安全型pollFirst, 与pop完全相同
     * removeLast()               非安全型pollLast
     * removeFirstOccurrence(Object o)    从头开始找,直接去值. boolean确认, 非安全型
     * removeLastOccurrence(Object o)     从尾开始找,直接去值. boolean确认, 非安全型
     */
}


class A08d_Deque_zMethods {

    public static void main(String[] args) {

        //构造方法
        Deque<Integer> d1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Deque<Integer> empt = new LinkedList<>();

        // addFirst
        // addLast
        d1.addFirst(0);
        d1.addLast(6);
        System.out.println(d1); // >>>  [0, 1, 2, 3, 4, 5, 6]


        // descendingIterator()
        // 逆序Iterator
        Iterator<Integer> iter = d1.descendingIterator();


        // element()
        // must be non-empty list
        System.out.println(d1.element()); // >>> 0
        // System.out.println(empt.element());  // error

        // getFirst  // same as element()
        // getLast
        // must be non-empty list
        System.out.println(d1.getFirst()); // >>>  0
        System.out.println(d1.getLast());  // >>>  7
        // System.out.println(empt.getFirst()); // error
        // System.out.println(empt.getLast());  // error

        // offerFirst
        // offerLast
        // offer also linked to capacity
        d1.offerFirst(-1);
        d1.offerLast(8);
        System.out.println(d1); // >>>  [-1, 0, 1, 2, 3, 4, 5, 6, 8]

        // peekFirst
        // peekLast
        // 安全型get, 防止空表, 空表给null
        System.out.println(d1.peekFirst());  // >>> -1
        System.out.println(d1.peekLast());   // >>> 8

        // pollFirst
        // pollLast
        // 安全型get, 防止空表, 空表给null
        System.out.println(d1.pollFirst());  // >>> -1
        System.out.println(d1.pollLast());   // >>> 8
        System.out.println(d1);              // >>> [0, 1, 2, 3, 4, 5, 6]

        // pop
        System.out.println(d1.pop());       // >>> 0
        System.out.println(d1);             // >>> [1, 2, 3, 4, 5, 6]

        // push
        d1.push(0);
        System.out.println(d1);             // >>>  [0, 1, 2, 3, 4, 5, 6]

        // removeFirst
        // removeLast()
        // Retrieves and removes the first element of this deque
        System.out.println(d1.removeFirst()); // >>>  0
        System.out.println(d1);               // >>>  [1, 2, 3, 4, 5, 6]
        System.out.println(d1.removeLast());  // >>>  6
        System.out.println(d1);               // >>>  [1, 2, 3, 4, 5]

        // removeFirstOccurrence(Object o)
        // removeLastOccurrence(Object o)   // boolean确认
        Deque<Integer> d2 = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println(d2.removeFirstOccurrence(1)); // >>> true
        System.out.println(d2);                             // >>> [2, 3, 2, 1]
        System.out.println(d2.removeLastOccurrence(1));  // >>> true
        System.out.println(d2);                             // >>> [2, 3, 2]
    }
}


class A08e_Set {

    /*
     * Module java.base
     * Package java.util
     * Interface Set<E>

     * 集合, 不可重复性, 交集并集补集
     * 主要依靠HashSet实现
     * 另外还有 EventSet, NavigableSet<E>, SortedSet<E>
     */

    /*
     * Python set    不能重复, 无序
     * Java HashSet  不能重复, 无序
     * 所以非常对等

     * 注意:
     * HashSet允许包含值为null的元素，但最多只能有一个null元素
     * print一个Set每次显示顺序可能不同
     */

    /*
     * Set 最基本的操作
     * 来自Iterable:
     * forEach
     * iterator()
     * 来自Collection (所以Collection的方法不牵涉到任何index)
     * add(E e)                     相当于append, 附带return boolean
     * remove(Object o)             相当于del
     * addAll(Collection<? extends E> c)    // 并集
     * removeAll(Collection<?> c)           // 差集
     * retainAll(Collection<?> c)           // 交集
     * contains(Object o)           相当于x in Set
     * containsAll(Collection<?> c) 相当于 lst A is a subList of B
     * size()                       相当于len
     * equals(Object o)             相当于 == 但是更准确
     * clear()
     * isEmpty()
     * toArray()
     * 来自Set
     * of
     * copyOf
     */
}

class A08e_Set_zMethods {

    public static void main(String[] args) {

        // 构造方法
        Set<Object> S0 = new HashSet<>();  // 空列表   // 不要省略泛型
        // 参数可以是任何一个Collection子类

        // 快速构建  // 类似List, 从Arrays构建
        Set<Integer> S1 = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println(S1);  // >>>  [1, 2, 3] 自动消除重复元素
        System.out.println(S1.add(3)); // >>>  false

        // Collection中的常用方法这里跳过, 直接参考List, 注意Collection方法不带index


        // Set接口的专有方法 (除了Collections通用方法多出来的方法)

        // copyOf  (List也有) 浅Copy  (从另一个Collectin中的元素变成一个Set)
        // Returns an unmodifiable Set containing the elements of the given Collection.
        List<Integer> IL1 = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        Set<Integer> IS1 = Set.copyOf(IL1);
        Set<Integer> IS2 = new HashSet<>(IL1);  // 也可以不必copyOf来实现
        System.out.println(IS1.equals(IS2)); // >>> true  // 虽然这样mutable,但是二者内容目前相等


        // of (List 也有)
        // Returns an unmodifiable set
        Set<Integer> IS3 = Set.of(1, 2, 3);

        // forEach
        // 详见Java_Basics.C10b_For_each_Loop


        // Set的各种交集并集补集:

        // 交集 set1.retainAll(set2);
        Set<Integer> IS4 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> IS5 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> intersect = new HashSet<>(IS4);  // 先复制一份
        intersect.retainAll(IS5);
        System.out.println(intersect);  // >>>  [3, 4]

        // 并集 set1.addAll(set2);
        Set<Integer> union = new HashSet<>(IS4);      // 先复制一份
        union.addAll(IS5);
        System.out.println(union);     // >>>  [1, 2, 3, 4, 5, 6]

        // 差集 set1.removeAll(set2);
        Set<Integer> diff = new HashSet<>(IS4);        // 先复制一分
        diff.removeAll(IS5);
        System.out.println(diff);      // >>>  [1, 2]
    }
}
