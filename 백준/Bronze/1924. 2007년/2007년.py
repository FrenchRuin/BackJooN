import sys, datetime

input = sys.stdin.readline

days= ["MON","TUE","WED","THU","FRI","SAT","SUN"]
M,D = map(int, input().split())

print(days[datetime.date(2007,M,D).weekday()])