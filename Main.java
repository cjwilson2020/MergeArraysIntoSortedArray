import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    //This program is just merging two arrays. I will implement the sorting of each array to improve time complexity
    int[] a1 = {9,3,6,31};
    int[] a2 = {4,8,30};
    print("Merging");
    print(a1);
    print("and");
    print(a2);
    
    a1 = sort(a1);
    a2 = sort(a2);
   
    int[] solution = merge(a1,a2);

    print("\nSolution:"); 
    print(solution);
  }

  //MergeSort  
  static int[] sort(int[] a){
    int len = a.length;
    //System.out.println("Length: "+ len);
    if (len > 2){
      int pivotIndex = len/2;
      int[] left = Arrays.copyOfRange(a, 0, pivotIndex);
      int[] right = Arrays.copyOfRange(a, pivotIndex, len);
      left = sort(left);
      right = sort(right);
      a = merge(left, right);
    }else if (len == 2){
      if (a[0] > a[1]){
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
      }
    }
    return a;
  }

  //Merge
  static int[] merge(int[] arr1, int[] arr2){
    int[] merged = new int[arr1.length + arr2.length];
    int i = 0; //arr1 index
    int j = 0; //arr2 index
    for (int mergedIndex = 0; mergedIndex < merged.length;mergedIndex++){
      if(i < arr1.length){
        if(j < arr2.length){
          if (arr1[i] < arr2[j]){
            merged[mergedIndex] = arr1[i];
            i++;
          }else{
            merged[mergedIndex] = arr2[j];
            j++;
          }
        }else{
          merged[mergedIndex] = arr1[i];
          i++;
        }

      }else{
        if(j < arr2.length){
          merged[mergedIndex] = arr2[j];
          j++;
        }
      }
    }
    return merged;
  }

  //PrintString
  static void print(String s){
    System.out.println(s);
  }

  //PrintIntArray
  static void print(int[] a){
    System.out.print("[");
    for (int i = 0;i < a.length;i++){
      System.out.print(" " + a[i]);
    }
    System.out.print("]\n");
  }
}