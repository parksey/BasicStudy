#include <stdio.h>

void main() {
	int num, sub_num;
	char oper;

	printf("���⸦ �����մϴ�.\n\n");

	printf("����� ���ڸ� �Է��� �ּ���.\n");
	scanf_s("%d", &num);
	printf("���� �����: %d\n\n", num);
	
	while (1) {
		
		printf("����� �����ڸ� �Է��� �ּ���.(+,*,-,/,=)\n");
		scanf_s(" %c", &oper, 1);

		if (oper == '+') {
			printf("����� ���ڸ� �Է��� �ּ���.\n");
			scanf_s("%d", &sub_num);
			num = num + sub_num; //�� ����
			printf("���� �����: %d\n\n",num);
		}
		else if (oper == '-') {
			printf("����� ���ڸ� �Է��� �ּ���.\n");
			scanf_s("%d", &sub_num);
			num = num - sub_num; //�� ����
			printf("���� �����: %d\n\n", num);
		}
		else if (oper == '*') {
			printf("����� ���ڸ� �Է��� �ּ���.\n");
			scanf_s("%d", &sub_num);
			num = num * sub_num; //�� ����
			printf("���� �����: %d\n\n", num);
		}
		else if (oper == '/') {
			printf("����� ���ڸ� �Է��� �ּ���.\n");
			scanf_s("%d", &sub_num);
			num = num / sub_num; //�� ����
			printf("���� �����: %d\n\n", num);
		}
		else if (oper == '=') {
			printf("���� �����: %d\n\n", num);
			printf("���⸦ �����մϴ�.\n\n");
			return;
		}
		else {
			printf("[ERROR]\n");
		}
	

	}
}