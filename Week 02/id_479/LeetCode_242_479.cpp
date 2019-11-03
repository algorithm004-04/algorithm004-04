class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()){
            return false;
        }
        map<char,int> lettersA;
        map<char,int> lettersB;
        for(auto c:s){
            lettersA[c]++;
        }
        for(auto c:t){
            lettersB[c]++;
        }
        return (lettersA==lettersB);
        
        /*
        int table[26]={0};
        for(auto c:s){
            table[c-'a']++;
        }
        for(auto c:t){
            table[c-'a']--;
        }
        for(int count:table){
            if(count){
        }
        for(int i= 0;i<26;++i){
            if(table[i]){
                return false;
            }
        }
        return true;
        // */
    }
};