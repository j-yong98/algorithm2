#include <iostream>

using namespace std;

int arr[1001][1001];
int R, C;
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};

bool inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
}

int main() {
        cin >> R >> C;
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                        cin >> arr[i][j];
                        if (arr[i][j] == 0) {
                                cnt0++;
                        } else {
                                cnt1++;
                        }
                }
        }

        if (cnt0 % 2 == 1 || cnt1 % 2 == 1) {
                cout << "-1\n";
                return 0;
        }

        for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                        for (int d = 0; d < 4; d++) {
                                int y = i + dy[d];
                                int x = j + dx[d];
                                if (!inRange(y, x)) {
                                        continue;
                                }
                                if (arr[i][j] == arr[y][x]) {
                                        cout << "1\n";
                                        return 0;
                                }
                        }
                }
        }
        cout << "-1\n";
        return 0;
}