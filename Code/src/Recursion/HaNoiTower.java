package Recursion;

public class HaNoiTower {
    static void towerOfHanoi(int n, char src, char tmp, char des)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from " +  src + " to " + des);
            return;
        }
        towerOfHanoi(n-1, src, des, tmp);
        System.out.println("Take disk " + n + " from " +  src + " to " + des);
        towerOfHanoi(n-1, tmp, src, des);
    }

    public static void main(String args[])
    {
        int n = 3;
        towerOfHanoi(n,'A','B', 'C');
    }
}
