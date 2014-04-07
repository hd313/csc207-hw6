package edu.grinnell.tranchri.cohnhann;

import java.util.Collection;
import java.util.Queue;

public class ArrayBasedQueue<T>
    implements
      Queue
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.
   */
  int front;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({ "unchecked" })
  // Handle array casting
  public ArrayBasedQueue(int capacity) throws Exception
  {
    if (capacity <= 0)
      {
        throw new Exception("Queues must have a positive capacity.");
      } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so
    // we use this hack.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public boolean isEmpty()
  {
    return this.size <= 0;
  } // isEmpty()

  @Override
  public boolean isFull()
  {
    return this.back() >= this.values.length;
  } // isFull()

  @Override
  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // this.isFull()
    this.values[this.back()] = val;
    ++this.size;
  } // put(T)

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front++] = null;
    // We're removing an element, so decrement the size
    --this.size;
    // And we're done
    return result;
  } // get(T)

  @Override
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  } // peek()

  @Override
  public T dequeue()
    throws Exception
  {
    return this.get();
  } // dequeue

  @Override
  public void enqueue(T val)
    throws Exception
  {
    this.put(val);
  } // enqueue

  @Override
  public Iterator<T> iterator()
  {
    return new ArrayBasedQueueIterator<T>(this);
  } // iterator()

  // +----------------+--------------------------------------------------
  // | Helper Methods |
  // +----------------+

  /**
   * Get the index of the back of the queue. The back is where we add the next
   * element.
   */
  int back()
  {
    return this.size;
  } // back()

  @Override
  public boolean addAll(Collection arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean contains(Object arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsAll(Collection arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean remove(Object arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Object[] toArray()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray(Object[] arg0)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(Object arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object element()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean offer(Object arg0)
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object poll()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object remove()
  {
    // TODO Auto-generated method stub
    return null;
  }

} // class ArrayBasedQueue<T>

class ArrayBasedQueueIterator<T>
    implements
      Iterator<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public ArrayBasedQueueIterator(ArrayBasedQueue<T> q)
  {
    // STUB
  } // ArrayBasedQueueIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    if (!this.hasNext())
      {
        throw new NoSuchElementException("no elements remain");
      } // if no elements
    // STUB
    throw new NoSuchElementException("unimplemented");
  } // next()

  @Override
  public boolean hasNext()
  {
    // STUB
    return false;
  } // hasNext()

  @Override
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  } // remove()
} // ArrayBasedQueueIterator<T>
