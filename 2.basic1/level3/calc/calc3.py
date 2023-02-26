calculationList=[]
valid_chars = ['+', '-', '*', '/']
def calculation():
    
    while True:
        print("계산할 수식을 입력해 주세요.")
        try:
            equation=input()
            equation= equation.replace(" ","")
            if equation[-1]=="=":
                for char in equation:
                    if char in valid_chars and not char.isdigit():
                        result=eval(equation[:-1])
                        calculationList.append(equation+str(result))
                        return result
                
            else:
                raise ValueError
             
        except ValueError:
            print("[ERROR1]")
            continue
        except:
            print("[ERROR2]")
        break

def browse():
    for equation in calculationList:
        print(equation)
        



print("계산기를 시작합니다.")
while True:
    print("계산 시작하기(1), 사용한 계산식 가져오기(2)")
    try:
        userInput=input()
        if userInput=="1":
            print("최종 결과 값:", calculation())
        elif userInput=="2":
            browse()
        elif userInput=="QUIT":
            print("계산기를 종료합니다.")
            break
        else:
            raise ValueError

    except ValueError:
        print("[ERROR3]")
    except:
        print("[ERROR4]")
      