/*
Author: Jordan Ashe
Date: 07-7-21

Description: the original was made by Y. Daniel Yiang.
 */
public class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  /** Create a default heap */
  public Heap() {
  }

  /** Create a heap from an array of objects */
  public Heap(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  /** Add a new object into the heap */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    
    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int tiny = currentIndex; // Initialize smallest as root
      int l = 2 * currentIndex + 1; // left = 2*i + 1
      int r = 2 * currentIndex + 2; // right = 2*i + 2
      boolean switch1 = false;
      
      // If left child is smaller than root
      if (l < list.size()-1 && list.get(l).compareTo(list.get(tiny)) < 0){
        switch1 = true;
        tiny = l;
      }
      
      //if right smaller still
      if (r < list.size()-1 && list.get(r).compareTo(list.get(tiny)) < 0)
        tiny = r;
      
      // Swap if the current object is lnot the current one
      if (tiny != currentIndex) {
          E temp = list.get(tiny); 
          list.set(tiny, list.get(currentIndex));
          list.set(currentIndex, temp);
          currentIndex = tiny;
      }
      else
        break; // the tree is a heap now
        
      //ensureSecurity(currentIndex, switch1);
    } 
  }

  /** Remove the root from the heap */
  public E remove() {
    if (list.size() == 0) return null;

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int tiny = currentIndex; // Initialize smallest as root
      int l = 2 * currentIndex + 1; // left = 2*i + 1
      int r = 2 * currentIndex + 2; // right = 2*i + 2
      boolean switch1 = false;
      
      // If left child is smaller than root
      if (l < list.size()-1 && list.get(l).compareTo(list.get(tiny)) < 0){
        switch1 = true;
        tiny = l;
      }
      
      //if right smaller still
      if (r < list.size()-1 && list.get(r).compareTo(list.get(tiny)) < 0)
        tiny = r;
      
      // Swap if the current object is less than the other
      if (tiny != currentIndex) {
          E temp = list.get(tiny); 
          list.set(tiny, list.get(currentIndex));
          list.set(currentIndex, temp);
          currentIndex = tiny;
      }
      else
        break; // the tree is a heap now
        
      //ensureSecurity(currentIndex, switch1);
    } 
    
    return removedObject;
  }

  //fixes the l and r being out of sequencial order (?)
  /*public void ensureSecurity(int cI, boolean isLeft){
    if (isLeft){
      if (list.get(cI).compareTo(list.get(cI+1)) < 0){
        E temp = list.get(cI); 
        list.set(cI, list.get(cI+1));
        list.set(cI+1, temp);
      }
    }
    else{
      if (list.get(cI-1).compareTo(list.get(cI)) < 0){
        E temp = list.get(cI); 
        list.set(cI, list.get(cI-1));
        list.set(cI-1, temp);
      }
    }
  }*/


  /** Get the number of nodes in the tree */
  public int getSize() {
    return list.size();
  }
  
  /** Return true if heap is empty */
  public boolean isEmpty() {
    return list.size() == 0;
  }
}