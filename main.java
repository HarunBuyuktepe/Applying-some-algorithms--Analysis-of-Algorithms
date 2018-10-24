package cse2036;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class main {
	static ArrayList<Long> timesInsertion = new ArrayList<Long>();
	static ArrayList<Integer> comparetionInsertion = new ArrayList<Integer>();
	static ArrayList<Long> timesMerge = new ArrayList<Long>();
	static ArrayList<Integer> comparetionMerge = new ArrayList<Integer>();
	static ArrayList<Long> timesQuickSelect = new ArrayList<Long>();
	static ArrayList<Integer> comparetionQuickSelect = new ArrayList<Integer>();
	static ArrayList<Long> timesMedian = new ArrayList<Long>();
	static ArrayList<Integer> comparetionMedian = new ArrayList<Integer>();
	static ArrayList<Integer> size = new ArrayList<Integer>();
	public static void main(String[] args) {
		for(int f=25;f<775;f+=25){
			calculation(f);
			size.add(f);
		}
		generateStatistic();

	}
	public static void calculation(int a){
int arr[]=RandomArray(a);
		
		System.out.println("\n");
		
		int Insertation[]=arr.clone();
		int Merge[]=arr.clone();
		int QuickSelectPartitioning[]=arr.clone();
		int MedianOfThree[]=arr.clone();
		
		
		double startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			insertationSort(Insertation, 1);
			Insertation=arr.clone();
		}
		double finishTime = System.nanoTime();
		double time = finishTime - startTime;
		System.out.print("\nwhen using Insertation for smallest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Insertation=arr.clone();
		timesInsertion.add((long) time);
		comparetionInsertion.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			mergeSort(Merge, 1);
			Merge=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Merge Sort for smallest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Merge=arr.clone();
		timesMerge.add((long) time);
		comparetionMerge.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			selectRecursive(QuickSelectPartitioning, 1);
			QuickSelectPartitioning=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Quick Select Sort for smallest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		QuickSelectPartitioning=arr.clone();
		timesQuickSelect.add((long) time);
		comparetionQuickSelect.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			quickSort(MedianOfThree, 1);
			MedianOfThree=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Median of three for smallest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		MedianOfThree=arr.clone();
		timesMedian.add((long) time);
		comparetionMedian.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			insertationSort(Insertation, Insertation.length/2);
			Insertation=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Insertation for median of serie time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Insertation=arr.clone();
		timesInsertion.add((long) time);
		comparetionInsertion.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			mergeSort(Insertation, Merge.length/2);
			Merge=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Merge Sort for median of serie  time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Merge=arr.clone();
		timesMerge.add((long) time);
		comparetionMerge.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			mergeSort(QuickSelectPartitioning, QuickSelectPartitioning.length/2);
			QuickSelectPartitioning=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Quick Select Sort for median of serie time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		QuickSelectPartitioning=arr.clone();
		timesQuickSelect.add((long) time);
		comparetionQuickSelect.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			quickSort(MedianOfThree, MedianOfThree.length/2);
			MedianOfThree=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Median of three for median of serie time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		MedianOfThree=arr.clone();
		timesMedian.add((long) time);
		comparetionMedian.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			insertationSort(Insertation, Insertation.length-1);
			Insertation=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Insertation for largest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Insertation=arr.clone();
		timesInsertion.add((long) time);
		comparetionInsertion.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			mergeSort(Merge, Merge.length-1);
			Merge=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Merge Sort for largest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		Merge=arr.clone();
		timesMerge.add((long) time);
		comparetionMerge.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			selectRecursive(QuickSelectPartitioning, QuickSelectPartitioning.length-1);
			QuickSelectPartitioning=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Quick Select Sort for largest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		QuickSelectPartitioning=arr.clone();
		timesQuickSelect.add((long) time);
		comparetionQuickSelect.add(Sort.counter);
		
		Sort.counter = 0;
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++){
			Sort.counter = 0;
			quickSort(MedianOfThree, MedianOfThree.length-1);
			MedianOfThree=arr.clone();
		}
		finishTime = System.nanoTime();
		time = finishTime - startTime;
		System.out.print("\nwhen using Median of three for largest number time : "+((time/1000000)*(0.001))+"\n"+Sort.counter+" number of executions ");
		MedianOfThree=arr.clone();
		timesMedian.add((long) time);
		comparetionMedian.add(Sort.counter);
		System.out.println("\nFor array size"+arr.length+"\nFirst Element : "+quickSort(MedianOfThree, 1)+"\nMiddle Element : "+quickSort(MedianOfThree, MedianOfThree.length/2)+"\nLast Element :"+quickSort(MedianOfThree, MedianOfThree.length-1)+"");
	}
	public static int selectRecursive(int[] array, int n) {
		return Sort.QuickSelect(array, 0, array.length - 1, n);
	}
	public static int mergeSort(int[] array, int n) {
		return Sort.Mergesort(array, 0,array.length-1,n);
	}
	public static int insertationSort(int[] array, int k) {
		return Sort.InsertationSort(array,k);
	}
	public static int quickSort(int[] array,int k) {
	    Sort.recQuickSort(array, 0, array.length - 1,k);
		return array[k];
	}
	public static int[] RandomArray(int length){
    	int arr[] = new int[length];
    	Random randNumGenerator = new Random();
    	for (int i=0; i<arr.length; i++){
               arr[i] = (randNumGenerator.nextInt(Integer.MAX_VALUE));
         }
    	return arr;
    }
    public static void printArray(int[] arr){
    	for(int i=0;i<arr.length;i++){
        	if(i%10==0){
    			System.out.println("");
    		}
        	System.out.print(arr[i]+" ");
        }
    }
    public static void writeToFile(String url, String text) {
		try{
			
			File file = new File(url);
			if(!file.exists())
				file.createNewFile();
		    PrintWriter writer = new PrintWriter(url, "UTF-8");
		    writer.println(text);
		    writer.close();
		    
		} catch (IOException e) {
		   System.err.println("The text cannot printed to txt file!");
		}
	}
    public static void generateStatistic(){
    	//timesMedian.add((long) time);
		//comparetionMedian.add(Sort.counter);
    	String Insert=""; 
    	int a=-1;
    	System.out.println("\nInsertion Sort   First 	Median	    Last	time");
    	Insert+="	First	Median	Last";
    	for(int y=0;y<timesInsertion.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Insert+="\n "+size.get(a);
    		}
    		System.out.print("		"+timesInsertion.get(y)/100000*(0.001));
    		Insert+="	 "+timesInsertion.get(y)/10000*(0.001);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Insert.txt",Insert);
    	Insert=""; 
    	a=-1;
    	System.out.println("\nInsertion Sort   First 	Median	    Last	comparison");
    	Insert+="	First	Median	Last";
    	for(int y=0;y<comparetionInsertion.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Insert+="\n "+size.get(a);
    		}
    		System.out.print("		"+comparetionInsertion.get(y));
    		Insert+=" 	"+comparetionInsertion.get(y);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Insert1.txt",Insert);
    	String Merge=""; 
    	a=-1;
    	System.out.println("\nMerge Sort   First 	Median	    Last	time");
    	Merge+="	First	Median	Last";
    	for(int y=0;y<timesMerge.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Merge+="\n "+size.get(a);
    		}
    		System.out.print("		"+timesMerge.get(y)/100000*(0.001));
    		Merge+="	 "+timesMerge.get(y)/10000*(0.001);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Merge.txt",Merge);
    	Merge=""; 
    	a=-1;
    	System.out.println("\nMerge Sort   First 	Median	    Last	comparison");
    	Merge+="	First	Median	Last";
    	for(int y=0;y<comparetionMerge.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Merge+="\n "+size.get(a);
    		}
    		System.out.print("		 "+comparetionMerge.get(y));
    		Merge+="	"+comparetionMerge.get(y);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Merge1.txt",Merge);
    	String Quick=""; 
    	a=-1;
    	System.out.println("\nQuick Select   First 	Median	    Last	time");
    	Quick+="	First	Median	Last";
    	for(int y=0;y<timesQuickSelect.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Quick+="\n "+size.get(a);
    		}
    		System.out.print("		"+timesQuickSelect.get(y)/100000*(0.001));
    		Quick+="	 "+timesQuickSelect.get(y)/10000*(0.001);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Quick.txt",Quick);
    	Quick=""; 
    	a=-1;
    	System.out.println("\nQuick Select   First 	Median	    Last	comparison");
    	Quick+="	First	Median	Last";
    	for(int y=0;y<comparetionQuickSelect.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Quick+="\n "+size.get(a);
    		}
    		System.out.print("		"+comparetionQuickSelect.get(y));
    		Quick+=" 	"+comparetionQuickSelect.get(y);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Quick1.txt",Quick);
    	String Median=""; 
    	a=-1;
    	System.out.println("\nMedian Of Three   First 	Median	    Last	time");
    	Median+="	First	Median	Last";
    	for(int y=0;y<timesMedian.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Median+="\n "+size.get(a);
    		}
    		System.out.print("		"+timesMedian.get(y)/100000*(0.001));
    		Median+="	 "+timesMedian.get(y)/10000*(0.001);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Median.txt",Median);
    	Median=""; 
    	a=-1;
    	System.out.println("\nMedian Of Three   First 	Median	    Last	comparison");
    	Median+="	First	Median	Last";
    	for(int y=0;y<comparetionMedian.size();y++){
    		if(y%3==0){
    			System.out.println();a++;Median+="\n "+size.get(a);
    		}
    		System.out.print("		"+comparetionMedian.get(y));
    		Median+="	 "+comparetionMedian.get(y);
    	}
    	writeToFile("D:/projects/cse2036/src/cse2036/Median1.txt",Median);
    }
		
}