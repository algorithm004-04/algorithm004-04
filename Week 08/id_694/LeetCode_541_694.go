
func reverseStr(s string, k int) string {
	if k <= 0 {
		return s
	}
	var buf bytes.Buffer
	tmp := []rune{}

	if len(s) < k {
		for j := range s {
			buf.WriteRune(rune(s[len(s)-1-j]))
		}
		return buf.String()
	}

	for i, c := range s {
		if i%(2*k) < k {
			tmp = append(tmp, c)
			continue
		} else {
			if len(tmp) > 0 {
				for j := range tmp {
					buf.WriteRune(tmp[len(tmp)-1-j])
				}
				tmp = []rune{}
			}
			buf.WriteRune(c)
		}
	}

	if len(tmp) > 0 {
		for j := range tmp {
			buf.WriteRune(tmp[len(tmp)-1-j])
		}
	}

	return buf.String()
}
