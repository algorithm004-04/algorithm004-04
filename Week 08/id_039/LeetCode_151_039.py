class Solution:
    def reverseWords(self, s):
        word = ""
        words = ""
        s = s[::-1]
        for j, i in enumerate(s):
            if i != " " and word != "" and s[j-1] == " ":
                words += (word + " ")
                word = i
            elif i != " ":
                word = i + word
            else:
                continue
        words += word
        return(words)