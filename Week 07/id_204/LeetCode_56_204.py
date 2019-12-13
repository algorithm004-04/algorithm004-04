class Solution:
    def overlap(self, a, b):
        return a.start <= b.end and b.start <= a.end

    # generate graph where there is an undirected edge between intervals u
    # and v iff u and v overlap.
    def build_graph(self, intervals):
        graph = collections.defaultdict(list)

        for i, interval_i in enumerate(intervals):
            for j in range(i+1, len(intervals)):
                if self.overlap(interval_i, intervals[j]):
                    graph[interval_i].append(intervals[j])
                    graph[intervals[j]].append(interval_i)

        return graph

    # merges all of the nodes in this connected component into one interval.
    def merge_nodes(self, nodes):
        min_start = min(node.start for node in nodes)
        max_end = max(node.end for node in nodes)
        return Interval(min_start, max_end)

    # gets the connected components of the interval overlap graph.
    def get_components(self, graph, intervals):
        visited = set()
        comp_number = 0
        nodes_in_comp = collections.defaultdict(list)

        def mark_component_dfs(start):
            stack = [start]
            while stack:
                node = stack.pop()
                if node not in visited:
                    visited.add(node)
                    nodes_in_comp[comp_number].append(node)
                    stack.extend(graph[node])

        # mark all nodes in the same connected component with the same integer.
        for interval in intervals:
            if interval not in visited:
                mark_component_dfs(interval)
                comp_number += 1

        return nodes_in_comp, comp_number

    def merge(self, intervals):
        graph = self.build_graph(intervals)
        nodes_in_comp, number_of_comps = self.get_components(graph, intervals)

        # all intervals in each connected component must be merged.
        return [self.merge_nodes(nodes_in_comp[comp]) for comp in range(number_of_comps)]


