public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
    //虚拟头结点
    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表知否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表指定位置添加节点
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("参数错误！");
        }
        Node prev = dummyHead;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }

    /**
     * 末尾节点添加元素
     * @param e
     */
    public void addLast(E e){
        this.add(size,e);
    }

    /**
     * 首节点添加元素
     * @param e
     */
    public void addFirst(E e){
        this.add(0,e);
    }

    /**
     * 获取指定节点元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("非法参数");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }




}
