class BinarySearch:
    def __init__(self, numbers: list[int]) -> None:
        self.number_list = numbers
    
    def middle_point(self, low_point: int, high_point: int) -> int:
        return (low_point + high_point) // 2
    
    def search_index(self, target: int) -> int:
        low_p = 0
        high_p = len(self.number_list) - 1
        while low_p <= high_p:
            ## Get Middle point index
            middle_point = self.middle_point(low_p, high_p)
            if target == self.number_list[middle_point]:
                return middle_point
            elif target < self.number_list[middle_point]:
                high_p = middle_point - 1
            else:
                low_p = middle_point + 1
            
        return None


