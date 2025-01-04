## List Interface:

The List interface in Java is a apart of java.util package and is a sub-interface of Collection interface. It provides a way to store an ordered Collection of elements (known as a sequence). Lists allow for precise control over where elements are inserted and ca contain duplicate elements.

The List interface is implemented by several classes in the Java Collection Framework, such as ArrayList, LinkedList, Vector, and Stack.

## Key Features of List Interface:

Order Preservation

Index-Based Access

Allows Duplicates

## ArrayList Class:

An ArrayList is a resizable array implementation of the List interface. Unlike arrays in Java, which have a fixed size, an ArrayList can change its size dynamically as elements are added or removed. This flexibility makes it a popular choice when the number of elements in a list isn’t known in advance.

ArrayList Methods:

indexOf()         lastIndexOf()           clone()             get()

getFirst()         getLast()                   set()                  add()

addFirst()        addLast()                  removeFirst()  removeLast()

equalsRange() listIterator()             hasNext()         subList(from, to)

nextIndex()      previousIndex()       reversed()        stream()

toArray()          toString()

## Internal Working of ArrayList:

Unlike a regular array, which has a fixed size, an arrayList can grow and shrink as elements are added or removed. This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.

Internally, the ArrayList is implemented as an arreay of Object references.  When you add elements to an arrayList, you’re essentially storing these elements in this internal array.

When you create an ArrayList, it has an initial capacity (default is 10). The capacity ireferes to the size of internal array that can hold elements before needing to resize.

## When we add element:

Check Capacity: Before adding the new element, ArrayList checks if there is enough space in the internal array (elementData). If the array is full needs to be resized.

Resize if Necessary: If the internal array is full, the ArrayList will create a new array with a larger capacity (usually 1.5 times the current capacity) and copy the elements from the old array to new array.

Add the Element: The new element is then added to the internal array at the appropriate index, and the size is incremented.

## Resizing the Array:

Initial Capacity: By default capacity is 10.

Growth Factor: When internal array is full, a new array is created with a size 1.5 times the old size

Copying Elements: all elements from old array are copied to new array, which is an O(n) operation, where n is the number of elements in the ArrayList.

## Removing Elements:

Check Bounds: arraylist first checks if the index is within the valid range.

Remove the Element: element is removed, and all elements to te right of the removed element are shifted one position to the left to fill the gap.

Reduce Size: The size is decremented by 1.

## Time Complexity:

Access by index is O(1)

Adding an element is O(n) in the worst case when resizing occurs.

Removig elements can be O(n) because it may involve shifting elements.

Iteration is O(n)

```java
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
```