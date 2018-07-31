#include <stdio.h>
#include <assert.h>
#include <string.h>

void reverse(char* str) {
	char* end = str;
	char tmp;
	if (str) {
		while (*end) {
			++end;
		}
		--end; /* set one char back, since last char is null */
		while (str < end) {
			tmp = *str;
			*str = *end;
			*end = tmp;
			str++;
			end--;
		}
	}

}	

int main() {
	char string[] = "abc";
	reverse(string);
	assert(strcmp(string, "cba") == 0);
	return 0;
}