package algorithm.chapter1;

/**
 * ��ɾ�����������е��ظ������һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ� ���� nums =
 * [0,0,1,1,1,2,2,3,3,4],
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author chying
 *
 */
public class LeetCode_26_519 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
