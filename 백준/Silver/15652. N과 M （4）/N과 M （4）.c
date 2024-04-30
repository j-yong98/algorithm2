#include <stdio.h>
#include <stdlib.h>

int arr[8];
void f(int l, int s, int n, int m) {
	if (l == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}
	for (int i = s; i <= n; i++) {
		arr[l] = i;
		f(l + 1, i, n, m);
	}
}

int main() {
	int n, m;

	scanf("%d %d", &n, &m);
	f(0, 1, n, m);
	return 0;
}