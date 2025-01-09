# 초기화
hmap: dict = {}

# 삽입
hmap["hello"] = 1
hmap["hash"] = 2
hmap["table"] = 3
hmap["good"] = 4

# 순회는 3가지 방법이 있음
# 키-값, 키, 값
print("===순회===")

print("- 키-값 순회")
for key, val in hmap.items():
    print(key, "->", val)

print("- 키 순회")
for key in hmap.keys():
    print(key)

print("- 값 순회")
for val in hmap.values():
    print(val)

print("===검색===")

hash: str = hmap["hash"]

print(hash)

print("===삭제===")

pop = hmap.pop("table")

print(hmap)

