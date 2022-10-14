package src;

public class DataPacket {
    Data[] data = new Data[4];
    int Current;
    int S;

    public void insert(String Add, int data) {
        if (S <= 0) {
            S = 1;
        }
        if (this.data[Current / S] == null) {
            this.data[Current / S] = new Data();
        }
        this.data[Current / S].insert(Add, data);
    }

    public void search(String Add) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            if (data[i].find(Add) != -1) {
                System.out.println(data[i].find(Add) + " At Address -->" + Add);
                return;
            }
        }
        System.out.println("MISS!! Data not found at Address --> " + Add);

    }

}
