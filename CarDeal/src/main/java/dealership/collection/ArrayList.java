package dealership.collection;

/*
 *
 * UNUSED
 *
 */
public class ArrayList<E> implements List<E> {
    protected E[] array;
    protected int currentIndex = 0;

    public ArrayList() {
        array = (E[])new Object[0];
    }

    public ArrayList(E[] array) {
        this.array = array;
    }

    @Override
    public E get(E e) {
        return null;
    }

    // Get User at index i of the internal array
    public E get(int i) {
        return array[i];
    }

    @Override
    public void add(E e) {
        E[] tempArray = (E[])new Object[array.length + 1];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        // add new element
        tempArray[array.length] = e;
        array = tempArray;
    }

    @Override
    public int size() {
        return array.length;
    }

    // removes any element of the internal array that matches o by making a new array of reduced size without those elements
    public void remove(E e) {
        E[] tempArray = (E[])new Object[array.length - 1];

        // Shifts all elements down 1 starting at the index of the removed element
        //      Equivalent for loop: (int i = indexOf(e); i < (array.length - 1); i++)
        System.arraycopy(array, indexOf(e) + 1, array, indexOf(e), array.length - 1 - indexOf(e));

        array[array.length - 1] = null;

        // Copies array elements to tempArray, which has 1 less index
        System.arraycopy(array, 0, tempArray, 0, tempArray.length);

        array = tempArray;

    }

    @Override
    public E next() {
        if (array[currentIndex + 1] != null) {
            return array[++currentIndex];
        }
        return null;
    }

    @Override
    public E previous() {
        if (array[currentIndex - 1] != null) {
            return array[--currentIndex];
        }
        return null;
    }

    @Override
    public String toString() {
        String[] strings = getStringArray();
        String result = "";
        for (String s : strings) {
            result = result.concat(s + System.lineSeparator());
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        for (E e : array) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }


    @Override
    public void order() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].toString().compareTo(array[j].toString()) > 0) {
                    E temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //Returns index of user in array or -1 if user isn't found
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    // returns the array
    public E[] toArray() {
        return array;
    }

    // returns a String array of the .toString() of each element
    public String[] getStringArray(){
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = array[i].toString();
        }
        return result;
    }
}
