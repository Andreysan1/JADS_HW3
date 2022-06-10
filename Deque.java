package jads.lesson3.HW;

import jads.lesson3.CW.Queue;

public class Deque extends Queue {
    public Deque(int size) {
        super(size);
    }

    public void enqueueTail(int i) {
        super.insert(i);
    }

    public void enqueueHead(int i) {
        if (isFull())
            throw new RuntimeException("Queue is full");

        if (getHead() == 0)
            setTail(getSize());

        setHead(getHead() - 1);
        getQueue()[getHead()] = i;
        setCapacity(getCapacity() + 1);
    }

    public int dequeueHead() {
        return super.remove();
    }

    public int dequeueTail() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        setTail(getTail()); // exceptional case of enqueue head
        int temp = getQueue()[getTail()];
        setTail(getTail() - 1);
        if (getTail() == getSize())
            setTail(0);

        setCapacity(getCapacity() - 1);
        return temp;
    }



}
