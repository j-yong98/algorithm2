#include <stdio.h>
#include <stdlib.h>

void f(int l, int n, int m, int visited, int* arr) {
	if (l == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (int i = 1; i <= n; i++) {
		if ((visited & (1 << i)) != 0) continue;
		arr[l] = i;
		f(l + 1, n, m, visited | (1 << i), arr);
	}
}

int main() {
	int n, m;

	scanf("%d %d", &n, &m);
	int *arr = (int *) malloc(sizeof(int) * m);
	f(0, n, m, 0, arr);
	return 0;
}