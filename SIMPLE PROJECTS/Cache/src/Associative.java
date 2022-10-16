package src;

public class Associative {

    int S; /* Size */
    int CL;
    /** Cache Lines */
    int B;/* Block Size */

    int CurrentTag;
    int CurrentData;

    int offsetBit;
    int addresBit;

    /**
     * Assuming System is 32 bits
     */

    int offset;

    Associative(int S, int CL, int B) {

        this.S = S;
        this.B = B;
        this.CL = CL;

        Data.size = S;

        offset = Main.Log(B);

        int BlockAddress = Main.Log((int) (Math.pow(2, 32) / B));

        int Tag = BlockAddress - offset;

        TagArray = new Data[(int) Math.pow(2, Tag)];
        DataArray = new Data[(int) Math.pow(2, Tag)];

    }

    Data[] TagArray;
    Data[] DataArray;

    public void Load(String Add, int data) {

        String tagAddresString = Add.substring(offset, Add.length() - 1);
        int TagInt = Main.BoolToInt(tagAddresString);

        if (TagArray[CurrentTag / S] == null) {
            TagArray[CurrentTag / S] = new Data();
            TagArray[CurrentTag / S].insert(TagInt, data);
        } else {
            TagArray[CurrentTag / S].insert(Add, data);
        }

        CurrentTag++;

        System.out.println("HIT");

    }

    public void Search(String Add) {

        String tagAddresString = Add.substring(offset, Add.length() - 1);
        int TagInt = Main.BoolToInt(tagAddresString);

        Search(TagInt, Add);

    }

    private void Search(int address, String Add) {
        for (int i = 0; i < TagArray.length; i++) {
            if (TagArray[i] != null && TagArray[i].find(Add) != -1) {
                System.out.println(TagArray[i].find(Add) + " at Address -->" + Add);
                return;
            }
        }
        System.out.println("MISS!! Data not founnd at Address --> " + Add);

    }

}