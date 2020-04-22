package sort;


public class Sort {

    public void bubbleSort(int[] data) {
        int size = data.length;
        for (int i = 0; i < size; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                return;
            }
        }
    }


    public void insertSort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    public void selectSort(int[] data) {
        int size = data.length;
        for (int i = 0; i < size; i++) {
            int minValue = data[i];
            int minIndex = i;
            for (int j = i; j < size; j++) {
                if (data[j] < minValue) {
                    minValue = data[j];
                    minIndex = j;
                }
            }
            swap(data, minIndex, i);
        }

    }


    public void mergeSort(int[] data) {
        mergeSortPartition(data, 0, data.length - 1);
    }

    private void mergeSortPartition(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSortPartition(data, start, middle);
        mergeSortPartition(data, middle + 1, end);
        mergeSortMerge(data, start, end, middle);
    }

    private void mergeSortMerge(int[] data, int start, int end, int pivot) {
        int size = end - start + 1;
        int[] tmpList = new int[size];
        int indexA = start;
        int indexB = pivot + 1;
        int indexTmp = 0;
        while (indexA <= pivot && indexB <= end) {
            if (data[indexA] <= data[indexB]) {
                tmpList[indexTmp++] = data[indexA++];
            } else {
                tmpList[indexTmp++] = data[indexB++];
            }
        }
        int indexCopyStart = indexA;
        int indexCopyEnd = pivot;
        if (indexB <= end) {
            indexCopyStart = indexB;
            indexCopyEnd = end;
        }
        while (indexCopyStart <= indexCopyEnd) {
            tmpList[indexTmp++] = data[indexCopyStart++];
        }

        indexTmp = 0;
        for (; indexTmp < size; indexTmp++) {
            data[start++] = tmpList[indexTmp];
        }


    }

    public void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = quickSortPartition(data, start, end);
        quickSort(data, start, partition - 1);
        quickSort(data, partition + 1, end);
    }

    private int quickSortPartition(int[] data, int start, int end) {
        int pivot = data[end];
        int index = start;
        for (int i = start; i < end; i++) {
            if (data[i] <= pivot) {
                swap(data, index, i);
                index++;
            }
        }
        swap(data, index, end);
        return index;
    }


    private void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }
}
