class CircleArray {
    /*
    数组模拟环形队列
     */
    private int maxSize; // 表示数组的最大容量
    private int front;
    
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    private int nItem;  //计数器

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = -1;
        nItem = 0;
    }

    // 判断队列是否满
    public boolean isFull() {
	return nItem == maxSize;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return nItem == 0;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //将 rear 后移, 考虑取模
        rear = (rear + 1) % maxSize;
        //直接将数据加入
        arr[rear] = n;
        nItem++;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        nItem--;
        return value;

    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }

        for (int i = front; ; i = ++i % maxSize) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            if (i == rear) {
                break;
            }
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return nItem;
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}

