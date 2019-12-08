package algorithm.chapter1;

/**
 * ���ƶ��㡿����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳�� ʾ��: ����: [0,1,0,3,12] ���:
 * [1,3,12,0,0] ˵��: ������ԭ�����ϲ��������ܿ�����������顣 �������ٲ���������
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author chying
 *
 */
public class LeetCode_283_519 {
	public void moveZeroes(int[] nums) {
		int zeroCount = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			} else {
				nums[i - zeroCount] = nums[i];
				if (zeroCount != 0) {
					nums[i] = 0;
				}
			}
		}
	}
}
