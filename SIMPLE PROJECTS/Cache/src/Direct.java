package src;

public class Direct {

    int S; /* Size */
    int CL;
    /** Cache Lines */
    int B;/* Block Size */

    int CurrentTag;
    int CurrentData;

    int index;

    int offsetBit;
    int addresBit;

    /**
     * Assuming System is 32 bits
     */

    int offset;
    int Tag;

    Direct(int S, int CL, int B) {

        this.S = S;
        this.B = B;
        this.CL = CL;

        Data.size = S;

        offset = Main.Log(B);

        index = Main.Log(CL);

        int BlockAddress = Main.Log((int) (Math.pow(2, 32) / B));

        Tag = BlockAddress - offset - index;

        TagArray = new Data[(int) Math.pow(2, Tag)];
        DataArray = new Data[(int) Math.pow(2, Tag)];

    }

    Data[] TagArray;
    Data[] DataArray;

    public void Load(String Add, int data) {
        String IndexAdd = Add.substring(Tag, Tag + index);

        int Index = Main.BoolToInt(IndexAdd);

        if (TagArray[Index] == null) {
            TagArray[Index] = new Data();

        }

        TagArray[Index].insert(Add, data);
        System.out.println("HIT");

    }

    public void search(String Add) {
        String IndexAdd = Add.substring(Tag, Tag + index);

        int Index = Main.BoolToInt(IndexAdd);

        if (TagArray[Index] == null) {
            System.out.println("MISS");
        }

        else {
            if (TagArray[Index].find(Add) == -1) {
                System.out.println("MISS");
            } else {
                System.out.println(TagArray[Index].find(Add) + " At address -->" + Add);
            }
        }
    }

}
