
def calculator(a,b,operator):
#사칙연산 함수
    if operator == "+":
        return a+b
    if operator == "*":
       
        return a*b
    if operator == "-":
       
        return a-b
    if operator == "/":
        return a/b

        

if __name__ =="__main__":
    
    operatorList=["+","*","-","/","="] #연산자 리스트 
     
    print("계산할 숫자를 입력해 주세요.")
    
    firstnum= int(input()) #초기입력 숫자
    
    calculation=firstnum #다음숫자 갱신용 변수
    
    print("현재 결과 값: %d"%firstnum)
    
    while True:
        try:#예외처리

            print("계산할 연산자를 입력해주세요 (+,*,-,/,=)")
            
            operator=input()
            if operator not in operatorList:#연산자 리스트 안에 없을시 에러 출력
                raise TypeError
            if operator =="=": #"="입력시 계산기 종료
                print("최종 결과 값: %d"%calculation)
                print("계산기를 종료합니다.")
                break
            else:
                print("계산할 숫자를 입력해 주세요.")
                nextNum=int(input())
                calculation=calculator(calculation,nextNum,str(operator))#변수 갱신후 출력 이후 반복문을 통해 반복
                print(calculation)
        except TypeError:
            print("[ERROR]")
        except:
            print("[ERROR]")
    
        