from typing import Union    

class Node:

    def __init__(self, content) -> None:
        self.content = content
        self.next_node = None



class LinkedList:
    
    def __init__(self, content: Union[list[any], any]):
        self.node_list = []
        if isinstance(content, list):
            self.node_list = [Node(node) for node in content]
            self.head = self.node_list[0]

            del self.node_list[0]
            self.connect_node(self.node_list)
        else:
            self.head = Node(content)
        

    def connect_node(self, nodes: list[Node]):
        N = len(nodes)
        pivot = 0
        for idx in range(N):
            if idx == 0:
                self.head.next_node = nodes[idx]
            else:
                nodes[pivot].next_node = nodes[pivot + 1]
                if not self.node_list:
                    self.node_list.append(nodes[pivot])
                pivot += 1



    def show_connected_nodes(self):
        N = len(self.node_list)
        content = []
        for node in range(N + 1):
            if node == 0:
                content.append(self.head.content)
            else:
                content.append(self.node_list[node - 1].content)
        print(content)
            




obj = LinkedList(["a", 5,7])

obj.show_connected_nodes()
