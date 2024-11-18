#include <iostream>
#include <algorithm>

using namespace std;

long long arr[100001];

int main() {
        int N, K;
        cin >> N >> K;
        for (int i = 0; i < N; i++) {
                cin >> arr[i];
        }
        for (int i = 0; i < K; i++) {
                sort(arr, arr + N);
                int l, r;
                long long v;
                cin >> l >> r >> v;
                for (int j = l - 1; j < r; j++) {
                        arr[j] += v;
                }
        }
        sort(arr, arr + N);
        for (int i = 0; i < N; i++) {
                cout << arr[i] << " ";
        }
        cout << "\n";
        return 0;
}