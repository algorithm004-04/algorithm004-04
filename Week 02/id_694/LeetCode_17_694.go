var phone = map[string]string{
	"2": "abc",
	"3": "def",
	"4": "ghi",
	"5": "jkl",
	"6": "mno",
	"7": "pqrs",
	"8": "tuv",
	"9": "wxyz",
}

var output []string

func letterCombinations(digits string) []string {
    output = []string{}
    if len(digits) != 0 {
		backtrack("", digits)
	}
    return output
}

func backtrack(combination, nextDigits string) {
	if len(nextDigits) == 0 {
		output = append(output, combination)
	} else {
		digit := nextDigits[0]
        letters := phone[string(digit)]
		for i := 0; i < len(letters); i++ {
            letter := string(letters[i:i+1])
            backtrack(combination + letter, string(nextDigits[1:]))
		}
	}
}
