# Uses python3
import sys
import itertools

def partition3(A):
    # solve which works
    sum = 0
    for elem in A:
        sum += elem
    if sum % 3 == 0 and len(A) >= 3:
        W = sum // 3
        n = len(A)
        count = 0
        a = [[0] * (W + 1) for _ in range(n + 1)]
        for w in range(1, W + 1):
            for i in range(1, n + 1):
                a[i][w] = a[i - 1][w]
                if A[i - 1] <= w:
                    val = a[i - 1][w - A[i - 1]] + A[i - 1]
                    if val > a[i][w]:
                        a[i][w] = val
                if a[i][w] == W:
                    count += 1
                print(a[i][w], " ", count)
        if count >= 3:
            return 1
    return 0

def another_solve(A):
    sum = 0
    for elem in A:
        sum += elem
    if sum % 3 == 0 and len(A) >= 3:
        sum_part = sum / 3
        for _ in range(3):
            this_sum = 0
            for _ in range(len(A)):
                # searching for the most appropriate element
                elem = 0
                for i in range(0, len(A)):
                    if this_sum + A[i] <= sum_part and A[i] > elem:
                        elem = A[i]
                if not elem:
                    return 0
                this_sum += elem
                A.remove(elem)
                if this_sum == sum_part:
                    break
        if len(A) == 0:
            return 1
    return 0

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *A = list(map(int, input.split()))
    print(partition3(A))
