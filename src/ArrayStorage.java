import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0; //индекс крайнего элемента

    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null); //заполняем массив null
        size = 0;
    }

    void save(Resume r) {
        if (size < 10000) { //проверим переполнение массива
            storage[size] = r;
            size++;
        } else
            System.out.println("Превышен размер массива");
    }

    Resume get(String uuid) {

        for (int i = 0; i < size; i++) {  //обход заполненой части массива
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];   //возвращаем найденый элемент;
            }
        }
        return null;

    }

    void delete(String uuid) {
        Boolean isDeleted = false;

        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) { //ищем нужный элемент
                for (int j = i; j < size; j++) { //обходим элементы от найденого до последнего заолненого
                    storage[j] = storage[j + 1]; // сдвигаем все элементы на один влево
                    storage[size] = null; //последний элемент замещаем на null
                    isDeleted = true;   //отмечаем что удлили элемент
                }
                break;
            }
        }
        if (isDeleted)  //если элемент нашли и удалили то уменьшаемразмер
            size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
