#include <stdio.h>

int n;
int arr[30][3];
int rgb[3];
int pick[3];
int ans = 2147483647;


int myabs(int a, int b) {
	return a > b ? a - b : b - a;
}

int min(int a, int b) {
	return a < b ? a : b;
}

int res(int c) {
	int r = pick[0] / c;
	int g = pick[1] / c;
	int b = pick[2] / c;
	return myabs(r, rgb[0]) + myabs(g, rgb[1]) + myabs(b, rgb[2]);

}

void f(int l, int cnt, int s) {
	if (l == n || cnt == 7) {
		return;
	}
	for (int i = s; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			pick[j] += arr[i][j];
		}
		int b = res(cnt + 1);
		if (cnt + 1 >= 2) {
			ans = min(ans, b);
		}
		f(l + 1, cnt + 1, i + 1);
		for (int j = 0; j < 3; j++) {
			pick[j] -= arr[i][j];
		}
	}
}



int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	for (int i = 0; i < 3; i++) {
		scanf("%d", (rgb + i));
	}

	f(0, 0, 0);
	printf("%d\n", ans);
	return 0;
}