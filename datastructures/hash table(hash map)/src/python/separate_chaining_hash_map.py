class Entry:

    def __init__(self, key: int, val: any):
        self.key = key
        self.val = val


class SeparateChainingHashMap:

    def __init__(self):
        self.size = 0
        self.load_threshold = 2.0 / 3.0
        self.capacity = 4
        self.buckets: list[[]:Entry] = [[] for _ in range(self.capacity)]

    def hash(self, key: int) -> int:
        return key % 10

    def load_factor(self) -> float:
        return self.size / self.capacity

    def get(self, key: any) -> any:
        index = self.hash(key)
        bucket = self.buckets[index]

        for entry in bucket:
            if entry.key == key:
                return entry.val
        return None

    def put(self, key: int, val: any):
        if self.load_factor() > self.load_threshold:
            self.extend()

        index = self.hash(key)
        bucket = self.buckets[index]

        entry = Entry(key, val)
        bucket.append(entry)
        self.size += 1

    def remove(self, key: int):
        index = self.hash(key)
        bucket = self.buckets[index]

        for entry in bucket:
            if entry.key == key:
                bucket.remove(entry)
                self.size -= 1
                return

    def extend(self):
        buckets = self.buckets
        current_capacity = len(buckets)

        self.capacity = current_capacity * 2
        self.size = 0
        self.buckets = [[] for _ in range(self.capacity)]

        for bucket in buckets:
            for entry in bucket:
                self.put(entry.key, entry.val)

    def print(self):
        for bucket in self.buckets:
            res = []
            for entry in bucket:
                res.append(str(entry.key) + "->" + str(entry.val))
            print(res)

# 초기화
hash_map = SeparateChainingHashMap()

print("===삽입===")
hash_map.put(1, "hello")
hash_map.put(11, "separate")
hash_map.put(21, "chaining")
hash_map.put(4, "hash")
hash_map.put(5, "table")
hash_map.put(6, "!!")

hash_map.print()

print("===검색(키 값: 1)===")
item = hash_map.get(1)

print(item)

print("===삭제(키 값: 11)===")
hash_map.remove(11)

hash_map.print()