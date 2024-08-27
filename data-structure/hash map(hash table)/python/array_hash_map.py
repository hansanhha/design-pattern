class Entry:

    def __init__(self, key: any, val: any):
        self.key = key
        self.val = val

class ArrayHashMap:

    def __init__(self):
        self.buckets: list[Entry | None] = [None] * 100

    def hash(self, key: any) -> int:
        # 해시 충돌 발생 가능
        index = hash(key) % 100
        return index

    def get(self, key: any) -> any:
        index = self.hash(key)
        entry: Entry = self.buckets[index]
        if Entry is None:
            return None
        return entry.val

    def put(self, key: any, val: any):
        entry = Entry(key, val)
        index = self.hash(key)
        self.buckets[index] = entry

    def remove(self, key: any):
        index = self.hash(key)
        self.buckets[index] = None

    def items(self) -> list[Entry]:
        result: list[Entry] = []
        for entry in self.buckets:
            if entry is not None:
                result.append(entry)
        return result

    def keys(self) -> list[int]:
        result = []
        for entry in self.buckets:
            if entry is not None:
                result.append(entry.key)
        return result

    def values(self) -> list[str]:
        result = []
        for entry in self.buckets:
            if entry is not None:
                result.append(entry.val)
        return result

    def print(self):
        for entry in self.buckets:
            if entry is not None:
                print(entry.key, "->", entry.val)

# 초기화
array_hash_map: ArrayHashMap = ArrayHashMap()

print("===삽입===")
array_hash_map.put("hello", "hello")
array_hash_map.put(12, "array")
array_hash_map.put("해시", "hash")
array_hash_map.put("&^", "table")

array_hash_map.print()

print("===검색(키 값: &^)===")
item = array_hash_map.get("&^")

print(item)

print("===삭제(키 값: hello)===")
array_hash_map.remove("hello")

array_hash_map.print()