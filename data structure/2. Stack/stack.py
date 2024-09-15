

class StackDataStucture:

    def __init__(self, cap) -> None:
        self.cap = cap
        self.pointer = -1
        self.stack = [None] * cap

    def push(self, element):
        self.pointer += 1
        print(self.pointer, self.cap)
        if self.pointer == self.cap:
            raise Exception('Stack is full and there is no empty slot')
        self.stack[self.pointer] = element

    def pop(self):
        if self.pointer < 0:
            raise Exception("Stack is empty")
        temp = self.stack[self.pointer]
        self.stack.pop(self.pointer)
        return temp




