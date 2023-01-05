#include<stdio.h>
#include<string.h>

struct book{    
	char title[30]; //제목
	char author[30]; //지은이
	char publish[30]; //출판사
	int count; //수량

};

void menuoption() { //도서 메뉴얼 멘트 출력 함수
	printf("도서관 프로그램 입니다. \n\n");
	printf("책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요. \n");
}

int main(void) {
	struct book booklist[50]= {0,}; //입력할 수 있는 책수를 50이라 생각
	int choice = 0; //고른 메뉴얼 번호
	int i = 0; //i= 0~49 총 50
	int max = 0;
	char title[30] = {0};
	char author[30] = {0};

	while (1) {

		menuoption();
		scanf_s("%d", &choice);

		if (choice == 1) { //책 추가 조건문
			printf("책 제목, 지은이, 출판사 ,수량 순으로 입력해 주세요.\n");
			scanf_s("%s %s %s %d",booklist[i].title,30,  booklist[i].author, 30, booklist[i].publish, 30, &booklist[i].count);
			i++; //입력할 때마다 booklist의 배열 칸이 하나씩 생성
			max = i; //입력한 책의 종류 수  나타내는 max 
			printf("{책}을 추가했습니다.\n\n");

		}
		else if (choice == 2) { //책 삭제 조건문
			printf("삭제하고자 하는 책의 제목과 지은이를 입력해주세요.\n");
			scanf_s("%s, %s", &title[29],30, &author[29],30);
			for (i = 0; i < max; i++) {  //입력한 값과 booklist배열에 저장해놓은 문자열이 같을경우 빼는 동작을 원함.

			}
			
		}
		else if (choice == 3) { //책 목록 출력 조건문
			printf("도서관 내의 도서 리스트\n");
			printf("==\n");
			for (i = 0; i < max; i++) {
				printf("%s %s %s %d\n", booklist[i].title, booklist[i].author, booklist[i].publish, booklist[i].count);
			}
			printf("\n");

		}
		else if (choice == 4) { //정수값 변수인데 QUIT을 입력 받아야 해서 받는 방법을 몰라서 4로 대체..
			printf("도서관 프로그램을 종료합니다.\n");
			return;
		}

		else {
			printf("[ERROR]\n");

		}


	}



	return 0;
}