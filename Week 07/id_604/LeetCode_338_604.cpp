class Solution {
public:
	vector<int> countBits(int num){
		vector<int> res;
		for(int i = 0; i <= num; i++){
			res.push_back(hammingWeight(i));		
		}
		return res;
	}

private:
	int hammingWeight(uint32_t n){
		int count = 0;
		while(n){
			n &= (n-1);
			count++;
		}
		return count;
	}
};
