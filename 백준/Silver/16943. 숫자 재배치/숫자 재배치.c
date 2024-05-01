#include <stdio.h>

int a, b;
int len;
int ans = -1;
int temp[10];

int max(int a, int b) {
	return a > b ? a : b;
}
int length(int n) {
	int len = 0;
	while (n > 0) {
		len++;
		n /= 10;
	} 
	return len;
}

void f(int l, int num, int visited) {
	if (num > b) {
		return;
	}
	if (l == len) {
		ans = max(ans, num);
		return;
	}
	for (int i = 0; i < len; i++) {
		if (l == 0 && temp[i] == 0) continue;
		if ((visited & (1 << i)) != 0) continue;
		f(l + 1, num * 10 + temp[i], visited | (1 << i));
	}
}

int main() {
	scanf("%d %d", &a, &b);
	len = length(a);
	int idx = len - 1;
	while (a > 0) {
		temp[idx--] = a % 10;
		a /= 10;
	}
	f(0, 0, 0);
	printf("%d\n", ans);
	return 0;
}