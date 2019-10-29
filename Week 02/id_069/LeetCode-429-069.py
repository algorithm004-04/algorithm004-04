#20191024


# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

"""
这两个解法均从其他人那边复制过来
"""

"""
    解法1：
        1. 维护一个数组，将本层节点进行保存
        2. 将本层节点的val保存到res中
        3. 扫描本层节点的所有子节点，并替换原先数组
        4. 重复2直到 数组为空
"""
class Solution:
	def levelOrder(self, root: 'Node') -> List[List[int]]:
		queue = [root] if root else []      # set first node or None in case of empty tree
		result = []     # results will be stored here

		while queue:        # as long as there are any items in queue
			result.append([node.val for node in queue])     # add value of every node in queue
			queue = [child for node in queue for child in node.children]        # for every node in queue add its children - nested list comprehension

		return result


"""
    解法2：
        这个解法很取巧的是，将每层都设定为一个数组，并使用前序进行扫描，把不同层的数据放入不同的数组中
"""
class Solution:
	def levelOrder(self, root) -> List[List[int]]:
		output = []
		if root is not None:
			output.append([root.val])
			self.trav(root.children, 0, output)
			output.pop()
		return output

	def trav(self, node, deep, output):
		deep += 1
		if (len(output) - 1 < deep): output.append([])
		for x in node:
			output[deep].append(x.val)
			if x.children is not None:
				self.trav(x.children, deep, output)
