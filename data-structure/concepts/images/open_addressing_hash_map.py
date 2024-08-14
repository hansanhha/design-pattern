class Entry:

    def __init__(self, key: int, val: any):
        self.key = key
        self.val = val

class OpenAddressingHashMap:

    def __init__(self):
        self.size = 0
        self.capacity = 4
        self.load_threshold = 2.0 / 3.0
        self.buckets: list[Entry | None] = [None] * self.capacity
        self.TOMBSTONE = Entry(-1, "-1")

    def hash(self, key:any) -> :
