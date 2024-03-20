import sys

input = sys.stdin.readline

M = int(input())
stack = []
for _ in range(M):
    command = input().split()
    if command[0] == "add":
        if int(command[1]) not in stack:
            stack.append(int(command[1]))
    elif command[0] == 'check':
        print(1 if int(command[1]) in stack else 0)
    elif command[0] == 'remove':
        if int(command[1]) in stack:
            stack.remove(int(command[1]))
    elif command[0] == 'all':
        stack = [_ for _ in range(1, 21)]
    elif command[0] == 'empty':
        stack.clear()
    elif command[0] == 'toggle':
        if int(command[1]) in stack:
            stack.remove(int(command[1]))
        else:
            stack.append(int(command[1]))
