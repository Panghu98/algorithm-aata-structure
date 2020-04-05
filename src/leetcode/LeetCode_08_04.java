package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panghu
 *
 *
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_08_04 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(),A,B,C);
    }

    public void hanota(int n,List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            // 注意这里的Index必须是动态的A.size -1,也就是取顶部的
            C.add(A.remove(A.size()-1));
        }else {
            hanota(n-1,A,C,B);
            hanota(1,A,B,C);
            hanota(n-1,B,A,C);
        }
    }

    @Test
    public void test() {
        List<Integer> listA = new ArrayList<>(10);
        listA.add(0);
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        List<Integer> listB = new ArrayList<>(10);
        List<Integer> listC = new ArrayList<>(10);

        hanota(listA,listB,listC);
        System.out.println(Arrays.toString(listC.toArray()));
    }

}
