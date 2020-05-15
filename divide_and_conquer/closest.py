#Uses python3
import sys
import math
import random


def partition3(x, y, l, r):
    pivotX = x[l]
    pivotY = y[l]
    k = l
    j = k
    for i in range(l + 1, r + 1):
        if (x[i] < pivotX):
            j += 1
            k += 1
            x[i], x[j] = x[j], x[i]
            y[i], y[j] = y[j], y[i]
        elif (x[i] == pivotX):
            k += 1
            x[i], x[k] = x[k], x[i]
            y[i], y[k] = y[k], y[i]
    x[l], x[j] = x[j], x[l]
    y[l], y[j] = y[j], y[l]
    return (j, k)


def quick_sort(x, y, l, r):
    if (l >= r):
        return
    k = random.randint(l, r)
    x[l], x[k] = x[k], x[l]
    y[l], y[k] = y[k], y[l]
    m1, m2 = partition3(x, y, l, r)
    quick_sort(x, y, l, m1 - 1)
    quick_sort(x, y, m2 + 1, r)


def distance(x1, y1, x2, y2):
    return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)


def minimum_in_center(x, y, min_distance):
    for i in range(len(y)):
        for j in range(i + 1, min(i + 8, len(y))):
            if (distance(0, y[i], 0, y[j]) >= min_distance):
                break
            min_distance = min(distance(x[i], y[i], x[j], y[j]), min_distance)
    return min_distance


def elems_in_center(x, y, left, right):
    a = []
    b = []
    for i in range(len(x)):
        if (x[i] >= left and x[i] <= right):
            a.append(x[i])
            b.append(y[i])
    quick_sort(b, a, 0, len(b) - 1)
    return (a, b)


def minimum_distance(x, y):
    min_distance = 10 ** 18
    if (len(x) < 2):
        return min_distance
    if (len(x) == 2):
        dist = math.sqrt ((x[0] - x[1]) ** 2 + (y[0] - y[1]) ** 2)
        return min(min_distance, dist)
    quick_sort(x, y, 0, len(x) - 1)
    ave = len(x) // 2
    m1 = minimum_distance(x[0 : ave], y[0 : ave])
    m2 = minimum_distance(x[ave + 1 :], y[ave + 1 :])
    min_distance = min(m1, m2, min_distance)
    ave_elem = x[ave]
    left = ave_elem - min_distance
    right = ave_elem + min_distance
    x, y = elems_in_center(x, y, left, right)
    return minimum_in_center(x, y, min_distance)

if __name__ == '__main__':
    # input = sys.stdin.read()
    # data = list(map(int, input.split()))
    # n = data[0]
    # x = data[1::2]
    # y = data[2::2]
    n = int(input())
    x = []
    y = []
    for _ in range(n):
        data = input().split()
        x.append(int(data[0]))
        y.append(int(data[1]))
    print("{0:.9f}".format(minimum_distance(x, y)))
