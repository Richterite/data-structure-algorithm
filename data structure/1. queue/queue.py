


class QueueDataStructure():
    ERROR_EMPTY = "Queue is empty, FILL IT!"
    ERROR_FULL = "Queue is Full!"

    def __init__(self, queue_length) -> None:
        self.cap = queue_length - 1
        self.f_pointer = -1
        self.r_pointer = -1
        self.queue = [None] * queue_length

    def is_empty(self):
        if self.f_pointer < 0 and self.r_pointer < 0:
            return True
        else:
            return False
        

    def is_full(self):
        if self.r_pointer >= self.cap:
            return True
        else:
            return False

    def peek_front(self):
        if not self.is_empty():
            return self.queue[self.f_pointer]
        else:
            raise Exception(self.ERROR_EMPTY)

    def enqueue(self, element):
        if self.is_full():
            raise Exception(self.ERROR_FULL)
        elif self.f_pointer == -1:
            self.f_pointer = 0
            self.r_pointer = 0
            self.queue[self.r_pointer] = element
        else:
            self.r_pointer += 1
            self.queue[self.r_pointer] = element
        

    def dequeue(self):
        if self.is_empty():
            raise Exception(self.ERROR_EMPTY)
        elif self.f_pointer == self.r_pointer:
            temp = self.queue[self.f_pointer]
            self.f_pointer = -1
            self.r_pointer = -1
            return temp
        else:
            temp = self.queue[self.f_pointer]
            self.queue[self.f_pointer] = None
            self.f_pointer += 1
            return temp
        
    def print_queue(self):
        temp = []
        for queue in self.queue:
            if queue != None:
                temp.append(queue)
        print(temp)
