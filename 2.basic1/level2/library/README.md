# 도서관 미션
> 도서관 유저를 완성하는 미션

## 기능 요구 사항
1. 사람은 휴대폰 번호, 이름, 대여 책 들을 가지고 있습니다.
2. 도서관 회원은 추가하거나 삭제할 수 있습니다.
3. 대여한 책이 존재하는 경우 회원 삭제를 할 수 없습니다.
4. `자바`or `코틀린`의 경우 `IllegalArugmentException`을 발생시켜야한다.
5. 잘못된 입력이 들어오게 되면 `[ERROR]`로 시작하는 에러 메세지  출력 후 다시 받는다.

## 입출력 요구 사항

### 입력

1. 회원 추가
```
홍길동, 01011112222
```
2. 회원 삭제
```
홍길동, 01011112222
```

3. 책 대여
```
Java의 정석, 남궁석
```

### 츌력
- 도서관 출력 문구
    ```
    도서관 프로그램 입니다.  
    ```
- 추가, 삭제 및 대여 선택 문구
    ```
    회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
    ```
- 회원 추가
    ```
    추가할 회원의 이름과 핸드폰 번호를 입력하세요.
    ```
- 회원 삭제
    ```
    삭제하고자 하는 회원의 이름과 핸드폰 번호를 입력하세요.
    ```
- 회원 삭제 실패
    ```
    해당 회원은 대여 중인 책이 존재하여 삭제할 수 없습니다.
    ```
- 책 대여
    ```
    대여할 사람의 핸드폰 번호와 이름을 입력하세요 
    책의 이름과 지은이를 선택하세요.
    ```
- 책 대여 실패
    ```
    해당 책을 대여할 수 없습니다.
    ```
- 도서관 프로그램 종료
    ```
    도서관 프로그램을 종료합니다.
    ```

### 전체 동작
```
도서관 프로그램 입니다.

회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
1

추가할 회원의 이름과 핸드폰 번호를 입력하세요.
홍길동 01011112222

회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
2

삭제하고자 하는 회원의 이름과 핸드폰 번호를 입력하세요.
홍길동 01011112222

회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
1

추가할 회원의 이름과 핸드폰 번호를 입력하세요.
홍길동 01055556666

회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
3

대여할 사람의 핸드폰 번호와 이름을 입력하세요 
홍길동 01055556666

책의 이름과 지은이를 선택하세요.
Java의 정석, 남궁석

대여에 성공했습니다.

회원 추가(1), 회원 삭제(2), 책 대여(3)중 선택하세요.
QUIT

도서관 프로그램을 종료합니다.
```