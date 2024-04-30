#include <stdio.h>
#include <stdlib.h>

int arr[8];
int input[8];


void merge(int l, int m, int r) {
	int i = l;
	int j = m + 1;

	int idx = l;
	int temp[8] = {0};

	while (i <= m && j <= r) {
		if (input[i] <= input[j]) {
			temp[idx++] = input[i++];
		} else {
			temp[idx++] = input[j++];
		}
	}

	while (i <= m) {
		temp[idx++] = input[i++];
	}

	while (j <= r) {
		temp[idx++] = input[j++];
	}

	for (int k = l; k <= r; k++) {
		input[k] = temp[k];
	}
}

void d(int l, int r) {
	if (l < r) {
		int m = (l + r) >> 1;
		d(l, m);
		d(m + 1, r);
		merge(l, m, r);
	}
}

void f(int l, int s, int n, int m, int visited) {
	if (l == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}
	for (int i = s; i < n; i++) {
		if ((visited & (1 << i)) != 0) continue;
		arr[l] = input[i];
		f(l + 1, i + 1, n, m, visited | (1 << i));
	}
}

int main() {
	int n, m;

	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", (input + i));
	}
	d(0, n - 1);
	f(0, 0, n, m, 0);
	return 0;
}