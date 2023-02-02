// sorting
//  1. Bubble Sort
//  2. Selection Sort
//  3. Insertion Sort
//  4. Merge Sort
//  5. Quick Sort
//  6. Radix Sort
//  7. Bucket Sort
//  8. Heap Sort
//  9. Counting Sort
//  10. Shell Sort
import java.util.*;
class Sort{
    static void display(int []a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    static void bubble(int []a){                //1
        int i,j,n,temp,cnt=0;
        n=a.length;
        for(i=0;i<n-1;i++){
            boolean swp=false;
            for(j=0;j<n-1-i;j++){
                cnt++;
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swp=true;
                }
            }
            if(swp==false)
                break;
        }
        System.out.println("\nloop count="+cnt);
    }
    static void selection(int[]a){              //2
        int i,j,temp,key,n,cnt=0;
        n=a.length;
        for(i=0;i<n-1;i++){
            key=i;
            for(j=i+1;j<n;j++){
                cnt++;
                if(a[key]>a[j])
                    key=j;
            }
            if(key!=i){
                temp=a[key];
                a[key]=a[i];
                a[i]=temp;
            }
        }
        System.out.println("\nloop count="+cnt);
    }
    static void insertion(int []a){             //3
        int i,j,temp,n,cnt=0,key;
        n=a.length;
        for(i=0;i<n-1;i++)
            for(j=i+1;j>0 && a[j]<a[j-1];j--){
                cnt++;        
                temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }
        //gfg code
        // for (i = 1; i < n; i++)
        // { 
        //     key = a[i]; 
        //     j = i - 1; 
            
        //     // Move elements of arr[0..i-1],  
        //     // that are greater than key, to one 
        //     // position ahead of their 
        //     // current position
        //     while (j >= 0 && a[j] > key)
        //     { 
        //         a[j + 1] = a[j]; 
        //         j = j - 1;
        //         cnt++; 
        //     } 
        //     a[j + 1] = key; 
        // }
        System.out.println("\nloop count="+cnt);
    }
    static void mix(int []a, int l, int h, int mid){
        int i=l,j=mid+1,k=0;
        int []b=new int [a.length];
        while(i<=mid && j<=h){
            if(a[i]>a[j])
                b[k++]=a[j++];
            else 
                b[k++]=a[i++];
        }
        while(i<=mid)
            b[k++]=a[i++];
        while(j<=h)
            b[k++]=a[j++];
        
        for(i=l,k=0;i<=h;i++,k++)
            a[i]=b[k];
    }
    static void mergeSort(int []a, int l, int h){
        if(l<h){
            int mid=(l+h)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,h);
            mix(a,l,h,mid);
        }
    }
    static void merge(int []a){                 //4
        mergeSort(a,0,a.length-1);
    }
    static int partition(int []a, int l,int h){
        int pivot=a[h],i=l-1,j,temp;

        for(j=l;j<=h;j++)
            if(a[j]<pivot){
                i++;
                temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        temp=a[i+1];
        a[i+1]=a[h];
        a[h]=temp;
        return i+1;
       
        /*easy to under stand approach\
        i=l;
        j=h;
        pivot=a[h];
        while(i<j){
            while(a[i]<=pivot)
                i++;
            while(a[j]>pivot)
                j--;
            if(i<j){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        return j;

        */
    }
    static void quickSort(int []a, int l, int h){
        if(l<h){
            int loc=partition(a,l,h);
            quickSort(a,0,loc-1);
            quickSort(a,loc+1,h);
        }
    }
    static void quick(int []a){                 //5
        quickSort(a,0,a.length-1);
    }
    static void bucket(int []a){                //6
        
    }
    static void radix(int []a){                 //7
        
    }
    static void count(int []a){                 //8
        int i,j,max;
        int []out=new int[a.length];

        max=a[0];
        for(i=0;i<a.length;i++)
            if(a[i]>max)
                max=a[i];
        
        int []count= new int[max+1];
        for(i=0;i<=max;i++)
            count[i]=0;
        
        for(i=0;i<a.length;i++)
            count[a[i]]++;
        
        for(i=1;i<count.length;i++)
            count[i]+=count[i-1];
        
        for(i=0;i<a.length;i++)
            out[--count[a[i]]]=a[i];
        
        for(i=0;i<a.length;i++)
            a[i]=out[i];
        
    }   
    static void heap(int []a){                  //9

    }
    static void shell(int []a){                 //10

    }
    public static void main(String args[]){
        int i,j,n,temp,ch;
        int []b={1};
        Scanner in=new Scanner(System.in);
        System.out.print("enter size of the array: ");
        n=in.nextInt();
        int []a= new int[n];
        System.out.println("enter values in the array: ");
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
        System.out.print("array before sorting: ");
        display(a);
        ch=8;
        switch(ch){
            case 1:
                bubble(a);                              //done
                break;
            case 2:
                insertion(a);                           //done
                break;
            case 3:
                selection(a);                           //done
                break;
            case 4:                                      
                merge(a);                               // done
                break;
            case 5:
                quick(a);                                   //done
                break;
            case 6:
                radix(a);
                break;
            case 7:
                bucket(a);
                break;
            case 8:
                count(a);                               //done
                break;
            case 9:
                heap(a);
                break;
            case 10:
                shell(a);
                break;
            default:
                System.out.println("invalid input");
        }
        System.out.print("\nArray after sorting: ");
        display(a);
    }
}