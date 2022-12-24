# 도서관 미션
> 도서관 책을 완성하는 미션

## 기능 요구 사항
1. 책은 `책 제목`, `지은이`, `출판사`, `수량`으로 되어 있다.
2. 사용자는 책을 새로 넣을 경우 `책 제목, 지은이, 출판사, 수량`로 구분지어 입력받는다.
3. 도서관에는 책을 추가할 수 있고, 삭제할 수 있다.
4. `자바`or `코틀린`의 경우 `IllegalArugmentException`을 발생시켜야한다.
5. 잘못된 입력이 들어오게 되면 `[ERROR]`로 시작하는 에러 메세지  출력 후 다시 받는다.

## 입출력 요구 사항

### 입력

1. 책 관련 입력
```
Java의 정석, 남궁석, 도우출판
```
2. 책 삭제 입력
    - 책의 제목과 지은이를 입력하세요
```
Java의 정석, 남궁석
```
3. 메뉴 입력
    - 숫자만 가능
```
1
```

### 츌력
- 도서관 출력 문구
    ```
    도서관 프로그램 입니다.  
    ```
- 추가 및 삭제 선택 문구
    ```
    책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
    ```
- 도서 추가
    ```
    책 제목, 지은이, 출판사 ,수량 순으로 입력해 주세요.
    ```
- 도서 삭제
    ```
    삭제하고자 하는 책의 제목과 지은이를 입력해주세요.
    ```
- 도서 추가 및 삭제 완료
    ```
    {책}을 삭제했습니다.
    {책}을 추가했습니다.
    ```
- 도서관 프로그램 종료
    ```
    도서관 프로그램을 종료합니다.
    ```

### 전체 동작
```
도서관 프로그램 입니다.

책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
1

책 제목, 지은이, 출판사 ,수량 순으로 입력해 주세요.
Java의 정석, 남궁석, 도우출판, 5

책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
2

삭제하고자 하는 책의 제목과 지은이를 입력해주세요.
Java의 정석, 남궁석

책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
1

책 제목, 지은이, 출판사 ,수량 순으로 입력해 주세요.
핸즈온 머신러닝, 오렐리앙 제롱, 한빛미디어, 5

책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
3

도서관 내의 도서 리스트
===
핸즈온 머신러닝, 오렐리앙 제롱, 한빛미디어, 5

책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요
QUIT

도서관 프로그램을 종료합니다.
```