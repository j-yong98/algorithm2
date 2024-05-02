#include <stdio.h>

int n;
int k;
int cnt = 0;
int flag = 0;
int arr[11];
int ans = -1;

void print(int a, int b) {
	if (a == b - 1) {
		printf("%d\n", arr[a]);
		return;
	}
	printf("%d+", arr[a]);
	print(a + 1, b);
}

void f(int l, int sum) {
	if (flag) {
		return;
	}
	if (sum > n) {
		return;
	}
	if (sum == n) {
		cnt++;
	}
	if (cnt == k) {
		print(0, l);
		flag = 1;
		return;
	}
	if (n == l) {
		return;
	}
	for (int i = 1; i <= 3; i++) {
		arr[l] = i;
		f(l + 1, sum + arr[l]);
	}
}
int main() {
	scanf("%d %d", &n, &k);
	f(0, 0);
	if (!flag) {
		printf("%d\n", -1);
	}
	return 0;
}