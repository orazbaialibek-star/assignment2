public class ArrayIntersection {
    /// Returns array intersection of two arrays.
    public static IntArray intersect(IntArray A, IntArray B){
        IntArray C = new IntArray();

        for (int i = 0; i < A.size(); i++){
            for (int j = 0; j < B.size(); j++){
                if(A.get(i) ==  B.get(j)){
                    C.add(A.get(i));
                }
            }
        }
        return C;
    }

    /// main methods that tests the class.
    static void main() {
        IntArray A = new IntArray(new int[]{1, 67, 3, 76, 2});
        IntArray B = new IntArray(new int[]{1, 412, 3, 12, 6});
        System.out.println(intersect(A, B));
    }
}
