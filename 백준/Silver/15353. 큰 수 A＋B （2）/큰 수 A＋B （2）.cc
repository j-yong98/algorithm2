#include <stdio.h>
#include <stdlib.h>

#define MAX 10000
int my_strlen(const char *str) {
	int len = 0;
	while (*str) {
		len++;
		str = str + 1;
	}
	return len;
}

char *reverse(char *tmp) {
	char *res = (char *) malloc(MAX + 10);

	int idx1 = 0;
	int idx2 = my_strlen(tmp) - 1;
	while (idx2 >= 0)
		*(res + idx1++) = *(tmp + idx2--);
	free(tmp);
	return res;
}

char *my_add(const char *a, const char *b) {
	char* tmp = (char *) malloc(MAX + 10);

	int idx = 0;
	int idx1 = my_strlen(a) - 1;
	int idx2 = my_strlen(b) - 1;

	int carry = 0;
	while (idx1 >= 0 && idx2 >= 0) {
		int sum = (*(a + idx1--) - '0') + (*(b + idx2--) - '0') + carry;
		carry = sum / 10;
		*(tmp + idx++) = (sum % 10) + '0';
	}

	while (idx1 >= 0) {
		int sum = carry + (*(a + idx1--) - '0');
		carry = sum / 10;
		*(tmp + idx++) = (sum % 10) + '0';
	}
	while (idx2 >= 0) {
		int sum = carry + (*(b + idx2--) - '0');
		carry = sum / 10;
		*(tmp + idx++) = (sum % 10) + '0';
	}

	if (carry > 0)
		*(tmp + idx++) = carry + '0';
	return reverse(tmp);
}


int main() {
	char* a = (char*) malloc(MAX + 1);
	char* b = (char*) malloc(MAX + 1);

	scanf("%s %s", a, b);

	char *ans = my_add(a, b);
	printf("%s\n", ans);
	free(a);
	free(b);
	free(ans);
}