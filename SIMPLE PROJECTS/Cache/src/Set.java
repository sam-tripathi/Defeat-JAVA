package src;

public class Set {

    int S; /* Size */
    int CL;
    /** Cache Lines */
    int B;/* Block Size */

    int CurrentTag;
    int CurrentData;

    int offsetBit;
    int addresBit;

    int index;
    int block;

    /**
     * Assuming System is 32 bits
     */

    int offset;

    Set(int S, int CL, int B) {

        this.S = S;
        this.B = B;
        this.CL = CL;

        block = 2;

        Data.size = S;

        offset = Main.Log(B);

        index = Main.Log(CL) - block;

        int BlockAddress = Main.Log((int) (Math.pow(2, 32) / B));

        int Tag = BlockAddress - offset;

        TagArray = new DataPacket[(int) Math.pow(2, Tag)];
        DataArray = new DataPacket[(int) Math.pow(2, Tag)];

    }

    DataPacket[] TagArray;
    DataPacket[] DataArray;

    public void Load(String Add, int data) {
        String Index = Add.substring(offset + 1, offset + index + 1);
        int index = Main.BoolToInt(Index);
        if (TagArray[index] == null) {
            TagArray[index] = new DataPacket();
        }
        TagArray[index].insert(Add, data);
        System.out.println("HIT");
    }

    public void search(String Add) {
        String Index = Add.substring(offset + 1, offset + index + 1);
        int index = Main.BoolToInt(Index);

        if (TagArray[index] == null) {
            System.out.println("MISS");
            return;
        }
        TagArray[index].search(Add);

    }

}
