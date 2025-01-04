package Collections.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayListPractice{

    @Test
    public void arrayListPractice() {
        //how to create int array
        int[] arr = new int[10];

        //Resizable Array. Changes dynamically.
        //without generics
        ArrayList arrayList = new ArrayList<>();

        //with generics till Java 7
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();

        //with generics post Java 7. No need of type on right side
        ArrayList<Integer> list = new ArrayList<>();

        //declare a list ->
        List<Integer> arrayList4 = Arrays.asList(1,2,3,4,5,6);

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.contains(3));

        //List to ArrayList initialization.
        List<Integer> arrayList2 = new ArrayList<>();

        //copying overhead can be avoided by initializing with a capacity upfront.
        List<Integer> newList=  new ArrayList<>(1000);


        //creating arrayList using Arrays.asList. Remember when you use asList, it is an fixed sized list.
        //means you can't add or remove elements in this list. Only update elements if you want.
        List<String> anotherList = Arrays.asList("Apple", "Banana", "Orange");
        try{
            anotherList.add("Chickoo");
        } catch (UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        try{
            anotherList.remove(2);
        } catch (UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        //you can update
        anotherList.set(2, "Papaya");
        ArrayList<String> listFromCollection = new ArrayList<>(anotherList);
        System.out.println(listFromCollection.toString());

        //below add operation works as we are creating a new arrayList completely above.
        System.out.println(listFromCollection.add("Chickoo"));
        System.out.println(listFromCollection.toString());


        //creating arrayList using List.of. Remember this is unmodifiable list.
        //means you can't add or remove or update the elements.
        List<String> anotherList1 = List.of("Apple", "Banana", "Orange");
        //you can't update
        try{
            anotherList1.set(2, "Papaya");
        } catch (UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        //you can't resize
        try{
            anotherList1.add("Chickoo");
        } catch (UnsupportedOperationException e){
            System.out.println(e.toString());
        }
        System.out.println(anotherList1.toString());

        //convert list to array
        String[] array = anotherList.toArray(new String[0]);
    }





}
