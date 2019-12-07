class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        length = len(tasks)
        if length <= 1: return length

        task_map = dict()
        for task in tasks:
            task_map[task] = task_map.get(task,0) + 1
        
        task_sorted = sorted(task_map.items(), key=lambda x:x[1], reverse=True)
        task_max_count = task_sorted[0][1]
        res = (task_max_count-1)*(n+1)
        for sort in task_sorted:
            if sort == task_max_count:
                res += 1
        return res if res >= length else length