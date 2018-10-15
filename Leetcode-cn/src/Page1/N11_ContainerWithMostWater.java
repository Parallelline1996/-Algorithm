package Page1;

/*
* 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
* 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
* 说明：你不能倾斜容器，且 n 的值至少为 2。
*
* 思路：从两侧向中间遍历，初始值底最长，向内遍历若要有更大的面积，只有最短边取得更长的值才有可能
* 因此，将两边中短边向中间移动一位，再进行比较，直到两个“指针”相遇
* */
public class N11_ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
