#include<stdio.h>
#include<string.h>

struct book{    
	char title[30]; //����
	char author[30]; //������
	char publish[30]; //���ǻ�
	int count; //����

};

void menuoption() { //���� �޴��� ��Ʈ ��� �Լ�
	printf("������ ���α׷� �Դϴ�. \n\n");
	printf("å�� �߰��Ϸ���(1), �����Ϸ���(2), å ����Ʈ Ȯ��(3)�� �Է��ϼ���. \n");
}

int main(void) {
	struct book booklist[50]= {0,}; //�Է��� �� �ִ� å���� 50�̶� ����
	int choice = 0; //�� �޴��� ��ȣ
	int i = 0; //i= 0~49 �� 50
	int max = 0;
	char title[30] = {0};
	char author[30] = {0};

	while (1) {

		menuoption();
		scanf_s("%d", &choice);

		if (choice == 1) { //å �߰� ���ǹ�
			printf("å ����, ������, ���ǻ� ,���� ������ �Է��� �ּ���.\n");
			scanf_s("%s %s %s %d",booklist[i].title,30,  booklist[i].author, 30, booklist[i].publish, 30, &booklist[i].count);
			i++; //�Է��� ������ booklist�� �迭 ĭ�� �ϳ��� ����
			max = i; //�Է��� å�� ���� ��  ��Ÿ���� max 
			printf("{å}�� �߰��߽��ϴ�.\n\n");

		}
		else if (choice == 2) { //å ���� ���ǹ�
			struct book newbook;
			printf("�����ϰ��� �ϴ� å�� ����� �����̸� �Է����ּ���.\n");
			scanf_s("%s %s", &newbook.title, 30, &newbook.author,30);
			for (i = 0; i < max; i++) {
				if (strcmp(newbook.title, booklist[i].title) != 0 || strcmp(newbook.author, booklist[i].author) !=0) {
					
					continue;
				}
				printf("%s", newbook.title);
				
				booklist[i].count--;
				if (booklist[i].count == 0) {
					for (int j = i + 1; j < max; j++) { //�״���ĭ�� �ִ� ���� �� ������ ������ �ϴϱ� i+1��
						booklist[j - 1] = booklist[j]; //���� �� �迭 ĭ���� �ű�� �۾�

					}
					max--;
				}
				

				break;
				
			}
			printf("{å}�� �����߽��ϴ�.\n\n");
		}
		else if (choice == 3) { //å ��� ��� ���ǹ�
			printf("������ ���� ���� ����Ʈ\n");
			printf("==\n");
			for (i = 0; i < max; i++) {
				printf("%s %s %s %d\n", booklist[i].title, booklist[i].author, booklist[i].publish, booklist[i].count);
			}
			printf("\n");

		}
		else if (choice == 4) { //������ �����ε� QUIT�� �Է� �޾ƾ� �ؼ� �޴� ����� ���� 4�� ��ü..
			printf("������ ���α׷��� �����մϴ�.\n");
			return;
		}

		else {
			printf("[ERROR]\n");
			rewind(stdin);

		}


	}



	return 0;
}