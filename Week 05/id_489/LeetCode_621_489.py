class Solution:
    def leastInterval(self, tasks, n):
        length = len(tasks)
        if length <= 1:
            return length

        # 用于记录每个任务出现的次数
        task_map = dict()
        for task in tasks:
            task_map[task] = task_map.get(task, 0) + 1
        # 按任务出现的次数从大到小排序
        task_sort = sorted(task_map.items(), key=lambda x: x[1], reverse=True)

        # 出现最多次任务的次数
        max_task_count = task_sort[0][1]
        # 至少需要的最短时间
        res = (max_task_count - 1) * (n + 1)

        for sort in task_sort:
            if sort[1] == max_task_count:
                res += 1

        # 如果结果比任务数量少，则返回总任务数
        return res if res >= length else length


if __name__ == "__main__":
    solution = Solution()
    tasks = ["A","A","A","B","B","B"]
    n = 2
    print(solution.leastInterval(tasks, n))