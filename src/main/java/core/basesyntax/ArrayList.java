package core.basesyntax;

public class ArrayList<T> implements List<T> {
    private Object[] elements;
    private int size;

    public ArrayList() {

        elements = new Object[10];
        size = 0;

    }

    @Override
    public void add(T value) {
        elements[size++] = value;
    }

    @Override
    public void add(T value, int index) {

        if (index < 0 || index > size) {

            throw new ArrayListIndexOutOfBoundsException("Out of the bounds exception!");

        }

        if (size == elements.length) {

            Object[] elements_new = new Object[elements.length + elements.length / 2 + 1];

            for (int i = 0; i < elements.length; i++) {

                elements_new[i] = elements[i];

            }

            elements = elements_new;
        }

        for (int i = size; i > index; i--) {

            elements[i] = elements[i - 1];
        }

        elements[index] = value;

        size++;

    }

    @Override
    public void addAll(List<T> list) {

        for (int i = 0; i < list.size(); i++) {

            this.add(list.get(i));

        }
    }

    @Override
    public T get(int index) {

        return (T) elements[index];
    }

    @Override
    public void set(T value, int index) {

        elements[index] = value;

    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("Out of the bounds exception!");
        }

        T removed = (T) elements[index];

        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;
        return removed;
    }

    @Override
    public T remove(T element) {

        for (int i = 0; i < size; i++) {

            if (elements[i] != null && elements[i].equals(element)) {

                return remove(i);
            }

        }

        return null;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;

    }
}
