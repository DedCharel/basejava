import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0; //размер заполненого массива
    private int maxSize = 10000; //размер всего массива

    Resume[] storage = new Resume[maxSize];

    void clear() {
        Arrays.fill(storage, 0, size, null); //заполняем массив null
        size = 0;
    }

    void save(Resume r) {
        if (size < maxSize) { //проверим переполнение массива
            storage[size] = r;
            size++;
        } else
            System.out.println("Превышен размер массива");
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {  //обход заполненой части массива
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;

    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) { //ищем нужный элемент и сдвигаем элементы на 1 начиная с найденного
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                    storage[j + 1] = null;
                }
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
