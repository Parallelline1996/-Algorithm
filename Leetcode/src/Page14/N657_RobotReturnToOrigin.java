package Page14;

/*
* 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
* 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
* 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
* */
public class N657_RobotReturnToOrigin {

    public static void main(String[] args) {

    }

    private static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        char[] chars = moves.toCharArray();
        int R = 0, L = 0, U = 0, D = 0;
        for (char c : chars
             ) {
            switch (c) {
                case 'R': {
                    R++;
                    break;
                }
                case 'L': {
                    L++;
                    break;
                }
                case 'U': {
                    U++;
                    break;
                }
                    default: D++;
            }
        }
        return (R == L) && (U == D);
    }
}
