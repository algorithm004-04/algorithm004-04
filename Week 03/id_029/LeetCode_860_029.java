public class LeetCode_860_029 {
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int i = 0; i < bills.length; i++) {
			int bill = bills[i];
			switch (bill) {
			case 5:
				five++;
				break;
			case 10:
				if (five > 0) {
					five--;
					ten++;
				} else {
					return false;
				}
				break;
			case 20:
				if (five >= 1 && ten >= 1) {
					five--;
					ten--;
				} else if (five >= 3) {
					five -= 3;
				} else {
					return false;
				}
				break;
			}
		}
		return true;
	}
}
