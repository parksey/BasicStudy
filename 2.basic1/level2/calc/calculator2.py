def calculator(input_equation):
    input_equation = input_equation.replace(" ", "")
    
    if input_equation[-1]!="=":
        print("[Error]")
    try:
        result= eval(input_equation[:-1])
        return result 
    except:
        print("[Error]")        
        
print("계산기를 시작합니다.")

print("계산할 수식을 입력해 주세요.")

equation=input()

result=calculator(equation)

print("최종 결과 값: %d"%result)
print("계산기를 종료합니다.")