class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> req;

        vector<long> prime{2,3,5,7,11,13,17,19,23,29,31,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};
        map<long,vector<string>> primeMap;
        for(string str:strs){
            int result=1;
            for(auto c:str){
                result*=prime.at(c-'a');
            }
            primeMap[result].push_back(str);
        }
        map<long,vector<string>>::iterator i;
        for(i = primeMap.begin();i!=primeMap.end();++i){
            req.push_back((*i).second);
        }
        return req;
    }
};