# Uses python3
import sys

def optimal_weight(W, w):
    result = [[0] * (W + 1) for i in range(len(w) + 1)]
    for i in range(1, len(w) + 1):
        for j in range(1, W + 1):
             result[i][j] = result[i - 1][j]
             if w[i - 1] <= j:
                 val = result[i - 1][j - w[i - 1]] + w[i - 1]
                 if result[i][j] < val:
                     result[i][j] = val
    return result[len(w)][W]

if __name__ == '__main__':
    input = sys.stdin.read()
    W, n, *w = list(map(int, input.split()))
    print(optimal_weight(W, w))
