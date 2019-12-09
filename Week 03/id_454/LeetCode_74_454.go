//这只是一个随手的foolish solution，yangwuqi
//8ms，faster than 100%

func searchMatrix(matrix [][]int, target int) bool {//没什么好说的，我是直接把二维数组变成一维数组然后二分，然后就完事了
    if len(matrix)==0||len(matrix[0])==0{
        return false
    }
    var line []int
    for i:=0;i<len(matrix);i++{
        for j:=0;j<len(matrix[0]);j++{
            line=append(line,matrix[i][j])
        }
    }
    return binary_search(0,len(line)-1,target,line)
}

func binary_search(left int,right int,target int,line []int)bool{
    if left>right{
    	return false
	}
    if left==right{
        if line[left]==target{
            return true
        }else{
            return false
        }
    }
    if line[(left+right)/2]==target{
        return true
    }else if line[(left+right)/2]>target{
        return binary_search(left,(left+right)/2-1,target,line)
    }else if line[(left+right)/2]<target{
        return binary_search((left+right)/2+1,right,target,line)
    }
    return  false
}