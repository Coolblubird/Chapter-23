/*
Author: Jordan Ashe 
Date: 07-7-21

Description: This is the only file I've modified so I didn't see it fair to place my name in the other ones. I am not sure what this other error is as it cannot happen on any of the computers in the lab, whether my friend does it or me.
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
  
    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),new Circle(5), new Circle(6), new Circle(1), new Circle(2),new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }

  public static <E extends Comparable<E>> void quickSort(E[] list){
    quickSort(list,0,list.length-1);
  }
  
  public static <E extends Comparable<E>> void quickSort(E[] list,int first, int last){
    if (last > first) {
      int index = part(list, first,last);
      quickSort(list,first,index-1);
      quickSort(list,index+1,last);
    }
  }
  
  public static <E extends Comparable<E>> int part(E[] list, int first, int last) {
    E pivot = list[first];
    int low = first+1; 
    int high = last; //exclude the pivot
    
    while (high > low){
      //meetup in the middle
      while (low <= high && list[low].compareTo(pivot) <= 0){
        low++;
      }
      
      while (low <= high && list[high].compareTo(pivot) > 0){
        high--; 
      }
      
      //swap
      if (high > low){
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    while (high > first && list[high].compareTo(pivot) >= 0){
      high--;
    }
    
    if (pivot.compareTo(list[high]) > 0){
      list[first]=list[high];
      list[high] = pivot;
      return high;
    }
    else{
      return first;
    }
  }

  public static <E> void quickSort(E[] list, Comparator<E> comparator){
    quickSort(list,0,list.length-1,comparator);
  }
  
  public static <E> int part(E[] list, int first, int last,Comparator<E> comparator) {
    E pivot = list[first];
    int low = first+1; 
    int high = last; //exclude the pivot
    
    while (high > low){
      //meetup in the middle
      while (low <= high && comparator.compare(list[low],pivot) <= 0){
        low++;
      }
      
      while (low <= high && comparator.compare(list[high],pivot) > 0){
        high--; 
      }
      
      //swap
      if (high > low){
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    while (high > first && comparator.compare(list[high],pivot) >= 0){
      high--;
    }
    
    if (comparator.compare(pivot,list[high]) > 0){
      list[first]=list[high];
      list[high] = pivot;
      return high;
    }
    else{
      return first;
    }
  }
  
  public static <E> void quickSort(E[] list, int first, int last, Comparator comparator){
    if (last > first) {
      int index = part(list, first, last, comparator);
      quickSort(list,first,index-1,comparator);
      quickSort(list,index+1,last,comparator);
     }
  }
}